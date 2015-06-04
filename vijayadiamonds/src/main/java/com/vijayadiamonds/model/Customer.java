package com.vijayadiamonds.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class interacts with Customer table of the dabase
 * 
 * @author Janardhan
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	/** Id of the Customer */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/** Name of the customer */
	@Column(name = "name")
	private String name;

	/** Phone number of the customer */
	@Column(name = "phone_number")
	private Long phoneNumber;

	/** Address of the customer */
	@Column(name = "address")
	private String address;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="customer",cascade = CascadeType.ALL, orphanRemoval = true)
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

}
