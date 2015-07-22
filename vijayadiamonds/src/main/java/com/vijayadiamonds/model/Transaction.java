package com.vijayadiamonds.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class that will be interacting with Transaction table of the database
 *
 * @author Janardhan
 */
@Entity
@Table(name = "transaction")
public class Transaction {

	/**
	 * Id of the transaction
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * Customer for the transaction
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	/**
	 * Total amount of the transaction
	 */
	@Column(name = "total_amount")
	private Long totalAmount;

	/**
	 * Paid amount for the transaction
	 */
	@Column(name = "paid_amount")
	private Long paidAmount;

	/**
	 * Date of the transaction
	 */
	@Column(name = "transaction_date")
	@Temporal(TemporalType.DATE)
	private Calendar transactionDate;

	/**
	 * Last updated date for the transaction
	 */
	@Column(name = "last_updated_date")
	@Temporal(TemporalType.DATE)
	private Calendar lastUpdatedDate;

	/**
	 * Comments for the transaction
	 */
	@Column(name = "comments")
	private String comments;

	@Column(name = "worker")
	private String worker;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
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
	public Transaction(Customer customer, Long totalAmount, Long paidAmount,
			Calendar transactionDate, Calendar lastUpdatedDate, String comments , String worker) {
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.transactionDate = transactionDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.comments = comments;
		this.worker = worker ;
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
	

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public Set<Sale> getSales() {
		return Collections.unmodifiableSet(sales);
	}

	public void addSale(Sale sale) {
		sales.add(sale);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(customer).append(totalAmount)
				.append(paidAmount).append(comments).hashCode();
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

		Transaction tran = (Transaction) obj;
		return new EqualsBuilder().append(customer, tran.customer)
				.append(totalAmount, tran.totalAmount)
				.append(paidAmount, tran.paidAmount)
				.append(comments, tran.comments).isEquals();

	}
}
