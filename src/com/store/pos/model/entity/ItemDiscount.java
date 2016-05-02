/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sanjeewa;
 */
@Entity
public class ItemDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String itemCcode;
    private String itemName;
    private String category;
    private float price;
    private float wholesaleDiscount;
    private float retailDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDiscount)) {
            return false;
        }
        ItemDiscount other = (ItemDiscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.store.pos.model.entity.ItemDiscount[ id=" + id + " ]";
    }

    /**
     * @return the itemCcode
     */
    public String getItemCcode() {
        return itemCcode;
    }

    /**
     * @param itemCcode the itemCcode to set
     */
    public void setItemCcode(String itemCcode) {
        this.itemCcode = itemCcode;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the wholesaleDiscount
     */
    public float getWholesaleDiscount() {
        return wholesaleDiscount;
    }

    /**
     * @param wholesaleDiscount the wholesaleDiscount to set
     */
    public void setWholesaleDiscount(float wholesaleDiscount) {
        this.wholesaleDiscount = wholesaleDiscount;
    }

    /**
     * @return the retailDiscount
     */
    public float getRetailDiscount() {
        return retailDiscount;
    }

    /**
     * @param retailDiscount the retailDiscount to set
     */
    public void setRetailDiscount(float retailDiscount) {
        this.retailDiscount = retailDiscount;
    }
    
}
