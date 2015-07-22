package com.vijayadiamonds.resource;

import com.vijayadiamonds.model.Customer;

import java.util.List;

public class Bill {
    private List<ItemResource> itemResources;
    private Long totalAmount;
    private Long paidAmount;
    private Customer customer;
    private String worker;

    public List<ItemResource> getItemResources() {
        return itemResources;
    }

    public void setItemResources(List<ItemResource> itemResources) {
        this.itemResources = itemResources;
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

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

}
