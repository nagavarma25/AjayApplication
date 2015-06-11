package com.vijayadiamonds.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Entity class that will be interacting with Sales table of the database
 *
 * @author Janardhan
 */
@Entity
@Table(name = "sale")
public class Sale {

    /**
     * Id of the sales
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Transaction Id for the sales
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    /**
     * Item id for the sales
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id")
    //@JsonIgnore
    private Item item;

    /**
     * Number of items
     */
    @Column(name = "quantity")
    private Long quantity;

    /**
     * Selling price of the item
     */
    @Column(name = "selling_price")
    private Long sellingPrice;

    /**
     * This constructor used by Hibernate
     */
    public Sale() {

    }

    /**
     * @param id
     * @param transaction
     * @param item
     * @param quantity
     * @param sellingPrice
     */
    public Sale(Transaction transaction, Item item, Long quantity,
                Long sellingPrice) {
        this.transaction = transaction;
        this.item = item;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(transaction).append(item).append(quantity).append(sellingPrice).hashCode();
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

        Sale sale = (Sale) obj;
        return new EqualsBuilder().append(item, sale.item).append(transaction, sale.transaction).append(quantity, sale.quantity).append(sellingPrice, sale.sellingPrice).isEquals();

    }
}
