package com.vijayadiamonds.billgeneration;

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
import com.vijayadiamonds.utils.GenerateBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Locale;

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
    public Long saveTransaction(@RequestBody Bill bill) {
        Transaction transaction = new Transaction(bill.getCustomer(),
                bill.getTotalAmount(), bill.getPaidAmount(),
                Calendar.getInstance(), Calendar.getInstance(), "");
        transactionService.addTransaction(transaction);
        for (ItemResource itemResource : bill.getItemResources()) {
            Item item = itemService
                    .getItemByNameAndShape(itemResource.getName(), shapeService
                            .getShapeNameFromValue(itemResource.getShape()));
            Sale sale = new Sale(transaction, item, itemResource.getQuantity(),
                    itemResource.getSellingPrice());
            saleService.addSale(sale);
        }
        GenerateBill generateBill = new GenerateBill();
        generateBill.generateBill(bill);
        System.out.println(transaction.getId()+"Tid");
        return transaction.getId();
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
            @PathVariable Long transactionId) {
        Transaction transaction = transactionService
                .getTransaction(transactionId);
        return transactionResourceMapper.apply(transaction);

    }
}
