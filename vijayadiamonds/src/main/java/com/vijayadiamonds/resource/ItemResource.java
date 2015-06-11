package com.vijayadiamonds.resource;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ItemResource {

    private Long id;

    private String name;

    private String unit;

    private Long unitPrice;

    private Long sellingPrice;

    private Long quantity;

    private String shape;

    public ItemResource() {

    }

    public ItemResource(Long id, String name, String shape, String unit, Long unitPrice, Long sellingPrice, Long quantity) {
        this.id = id;
        this.name = name;
        this.shape = shape;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
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

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
        ItemResource item = (ItemResource) obj;
        return new EqualsBuilder().append(name, item.name)
                .append(unit, item.unit).append(unitPrice, item.unitPrice)
                .isEquals();
    }

}
