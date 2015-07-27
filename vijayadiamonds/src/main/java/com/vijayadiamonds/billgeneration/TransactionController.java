package com.vijayadiamonds.billgeneration;

import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijayadiamonds.exception.ResourceNotFound;
import com.vijayadiamonds.mapper.TransactionResourceMapper;
import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.resource.Bill;
import com.vijayadiamonds.resource.ItemResource;
import com.vijayadiamonds.resource.TransactionResource;
import com.vijayadiamonds.service.ItemService;
import com.vijayadiamonds.service.SaleService;
import com.vijayadiamonds.service.ShapeService;
import com.vijayadiamonds.service.TransactionService;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private SaleService saleService;

	@Autowired
	private ShapeService shapeService;

	@Autowired
	private TransactionResourceMapper transactionResourceMapper;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String loadAddPage(Locale locale, Model model) {
		return "addtransaction";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String loadEditPage(Locale locale, Model model) {
		return "edittransaction";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Long saveTransaction(@RequestBody Bill bill) throws ResourceNotFound {
		Transaction transaction = new Transaction(bill.getCustomer(),
				bill.getTotalAmount(), bill.getPaidAmount(),
				Calendar.getInstance(), Calendar.getInstance(), "",
				bill.getWorker());
		transactionService.addTransaction(transaction);
		for (ItemResource itemResource : bill.getItemResources()) {
			String itemName = itemResource.getName();
			String itemShape = itemResource.getShape();
			Optional<Item> item = itemService.getItemByNameAndShape(itemName,
					shapeService.getShapeNameFromValue(itemShape));
			item.orElseThrow(() -> new ResourceNotFound("Item with shape :"
					+ itemShape + "and name " + itemName + "does not exists"));
			Sale sale = new Sale(transaction, item.get(),
					itemResource.getQuantity(), itemResource.getSellingPrice());
			saleService.addSale(sale);
		}
		/*
		 * GenerateBill generateBill = new GenerateBill();
		 * generateBill.generateBill(bill);
		 * System.out.println(transaction.getId()+"Tid");
		 */
		return transaction.getId();
	}

	@RequestMapping(value = "/addSale", method = RequestMethod.GET)
	public void saveSale() throws ResourceNotFound {
		System.out.println("addsale");
		Sale sale = new Sale();
		Optional<Item> item = itemService.getItemById(9L);
		item.orElseThrow(() -> new ResourceNotFound(
				"Unable to find Item with Id : " + 9L));
		sale.setItem(item.get());
		sale.setQuantity(2L);
		sale.setSellingPrice(200L);
		Optional<Transaction> transaction = transactionService
				.getTransaction(7L);
		transaction.orElseThrow(() -> new ResourceNotFound(
				"Transaction details not available for Id :" + 7L));
		sale.setTransaction(transaction.get());
		saleService.addSale(sale);
	}

	@RequestMapping(value = "/{transactionId}/settle", method = RequestMethod.PUT)
	@ResponseBody
	public Long settleTransaction(@PathVariable Long transactionId) {
		System.out.println("Inside put method");
		transactionService.settleTransaction(transactionId);
		return transactionId;
	}

	@RequestMapping(value = "/{transactionId}")
	@ResponseBody
	public TransactionResource getTransactionDetails(
			@PathVariable Long transactionId) throws ResourceNotFound {
		Optional<Transaction> transaction = transactionService
				.getTransaction(transactionId);
		transaction.orElseThrow(() -> new ResourceNotFound(
				"Transaction details not available for Id :" + transactionId));
		return transactionResourceMapper.apply(transaction.get());

	}
}
