package com.vijayadiamonds.model;

import java.util.Calendar;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Entity class that will be interacting with Transaction table of the database
 * 
 * @author Janardhan
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction {

	/** Id of the transaction */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/** Customer for the transaction */
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	/** Total amount of the transaction */
	@Column(name = "total_amount")
	private Long totalAmount;

	/** Paid amount for the transaction */
	@Column(name = "paid_amount")
	private Long paidAmount;

	/** Date of the transaction */
	@Column(name = "transaction_date")
	@Temporal(TemporalType.DATE)
	private Calendar transactionDate;

	/** Last updated date for the transaction */
	@Column(name = "last_updated_date")
	@Temporal(TemporalType.DATE)
	private Calendar lastUpdatedDate;

	/** Comments for the transaction */
	@Column(name = "comments")
	private String comments;

	@OneToMany(fetch=FetchType.EAGER,mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sale> sales = new HashSet<Sale>();

	/**
	 * This constructor will be used by hibernate
	 */
	public Transaction() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param cusomer
	 * @param totalAmount
	 * @param paidAmount
	 * @param transactionDate
	 * @param lastUpdatedDate
	 * @param comments
	 */
	public Transaction(Long id, Customer customer, Long totalAmount,
			Long paidAmount, Calendar transactionDate,
			Calendar lastUpdatedDate, String comments) {
		this.id = id;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.transactionDate = transactionDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<Sale> getSales() {
		return Collections.unmodifiableSet(sales);
	}
	
	public void addSale(Sale sale){
		sales.add(sale);
	}

}
