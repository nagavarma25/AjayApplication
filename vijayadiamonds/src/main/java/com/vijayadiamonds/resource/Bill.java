package com.vijayadiamonds.resource;

import java.util.List;

import com.vijayadiamonds.model.Customer;

public class Bill {
	private List<ItemResource> itemResources;
	private Long totalAmount;
	private Long paidAmount;
	private Customer customer;

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

}
