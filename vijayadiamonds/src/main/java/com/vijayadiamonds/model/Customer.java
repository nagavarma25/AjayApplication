package com.vijayadiamonds.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class interacts with Customer table of the dabase
 *
 * @author Janardhan
 */
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * Id of the Customer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Name of the customer
     */
    @Column(name = "name")
    private String name;

    /**
     * Phone number of the customer
     */
    @Column(name = "phone_number")
    private Long phoneNumber;

    /**
     * Address of the customer
     */
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Transaction> transactions = new HashSet<Transaction>();

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
        Customer cust = new Customer();
        return new EqualsBuilder().append(name, cust.name).append(phoneNumber, cust.phoneNumber).append(address, cust.address).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(phoneNumber).append(address).hashCode();
    }
}
