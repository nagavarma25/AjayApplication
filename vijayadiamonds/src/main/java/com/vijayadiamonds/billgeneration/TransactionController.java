package com.vijayadiamonds.billgeneration;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vijayadiamonds.model.Sale;
import com.vijayadiamonds.model.Transaction;
import com.vijayadiamonds.model.Item.Shape;
import com.vijayadiamonds.resource.Bill;
import com.vijayadiamonds.resource.ItemResource;
import com.vijayadiamonds.service.ItemService;
import com.vijayadiamonds.service.SaleService;
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
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String loadAddPage(Locale locale, Model model) {
		return "addtransaction";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String loadEditPage(Locale locale, Model model) {
		return "edittransaction";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void saveTransaction(@RequestBody Bill bill) {
		System.out.println("IN");
		Transaction transaction = new Transaction();
		System.out.println(bill.getCustomer().getId());
		transaction.setCustomer(bill.getCustomer());
		transaction.setPaidAmount(bill.getPaidAmount());
		transaction.setTotalAmount(bill.getTotalAmount());
		transaction.setTransactionDate(Calendar.getInstance());
		transaction.setLastUpdatedDate(Calendar.getInstance());
		Transaction persisted = transactionService.addTransaction(transaction);
		for (ItemResource itemResource : bill.getItemResources()) {
			Sale sale = new Sale();
			sale.setQuantity(itemResource.getQuantity());
			sale.setSellingPrice(itemResource.getSellingPrice());
			System.out.println(Shape.valueOf(itemResource.getShape()));
			sale.setItem(itemService.getItemByNameAndShape(
					itemResource.getName(),
					Shape.valueOf(itemResource.getShape())));
			sale.setTransaction(persisted);
			saleService.addSale(sale);

		}
		System.out.println(transaction.getId());
	}

	@RequestMapping(value = "/addSale", method = RequestMethod.GET)
	public void saveSale() {
		System.out.println("addsale");
		Sale sale = new Sale();
		sale.setItem(itemService.getItemById(9L));
		sale.setQuantity(2L);
		sale.setSellingPrice(200L);
		sale.setTransaction(transactionService.getTransaction(7L));
		saleService.addSale(sale);
	}
}
