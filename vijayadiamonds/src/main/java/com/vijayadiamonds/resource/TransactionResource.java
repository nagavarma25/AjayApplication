package com.vijayadiamonds.resource;

import java.util.List;

import com.vijayadiamonds.model.Customer;

public class TransactionResource {
    private List<ItemResource> itemResources;
    private Long totalAmount;
    private Long paidAmount;
    private Customer customer;

    public TransactionResource() {

    }

    public TransactionResource(List<ItemResource> itemResources, Long totalAmount,
            Long paidAmount, Customer customer) {
        this.itemResources = itemResources;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.customer = customer;

    }

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
