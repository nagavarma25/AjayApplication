package com.vijayadiamonds.resource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.vijayadiamonds.model.Transaction;

public class CustomerResource {

    /**
     * Id of the Customer
     */
    private Long id;

    /**
     * Name of the customer
     */
    private String name;

    /**
     * Phone number of the customer
     */
    private Long phoneNumber;

    /**
     * Address of the customer
     */
    private String address;

    private Set<Transaction> transactions = new HashSet<Transaction>();

    public CustomerResource() {

    }

    public CustomerResource(Long id, String name, Long phoneNumber,
            String address, Set<Transaction> transactions) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Transaction> getTransactions() {
        return Collections.unmodifiableSet(transactions);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        CustomerResource cust = new CustomerResource();
        return new EqualsBuilder().append(name, cust.name)
                .append(phoneNumber, cust.phoneNumber)
                .append(address, cust.address).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(phoneNumber)
                .append(address).hashCode();
    }

}
