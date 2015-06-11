package com.vijayadiamonds.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity class that will be interacting with item table of the database
 */
@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = {
        "name", "shape"}))
public class Item {

    /**
     * Id of the item
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Name of the item
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Unit to measure the item
     */
    @Column(name = "unit", nullable = false)
    private String unit;

    /**
     * Price of the item for one unit
     */
    @Column(name = "unit_price", nullable = false)
    private Long unitPrice;

    /**
     * Shape of the item
     */
    @Column(name = "shape", nullable = false)
    @Enumerated(EnumType.STRING)
    private Shape shape;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Sale> sales = new HashSet<Sale>();

    // This will be used by hibernate
    public Item() {

    }

    /**
     * Constructor
     *
     * @param name
     * @param unit
     * @param unitPrice
     * @param shape
     */
    public Item(String name, String unit, Long unitPrice, Shape shape) {
        Objects.requireNonNull(name, "Item name cannot be null");
        Objects.requireNonNull(shape, "Item shape cannot be null");
        Objects.requireNonNull(unit, "Item unit cannot be null");
        Objects.requireNonNull(unitPrice,
                "Unit price of the item cannot be null");
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.shape = shape;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(sales);
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(unit)
                .append(unitPrice).hashCode();
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
        Item item = (Item) obj;
        return new EqualsBuilder().append(name, item.name)
                .append(unit, item.unit).append(unitPrice, item.unitPrice)
                .isEquals();
    }

    public enum Shape {

        ROUND("Round"), OTHER("Other");
        private String name;

        Shape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }

    }
}
