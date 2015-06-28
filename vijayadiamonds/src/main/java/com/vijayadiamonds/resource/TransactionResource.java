package com.vijayadiamonds.resource;

import java.util.Calendar;
import java.util.List;

import com.vijayadiamonds.model.Customer;

public class TransactionResource {
	private Long id;
    private List<ItemResource> items;
    private Long totalAmount;
    private Long paidAmount;
    private Customer customer;
    private Calendar transactionDate;
    

    public TransactionResource() {

    }

    public TransactionResource(Long id,List<ItemResource> items, Long totalAmount,
            Long paidAmount, Customer customer, Calendar transactionDate) {
    	this.id = id;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.customer = customer;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemResource> getItems() {
        return items;
    }

    public void setItems(List<ItemResource> items) {
        this.items = items;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}

    
}
