/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.model.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sanjeewa;
 */
@Entity
public class ItemStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String itemCode;
    private String itemName;
    private int contity;
    private Date exDate;
    private float retailDis;
    private float wholeSaleDis;

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
        if (!(object instanceof ItemStock)) {
            return false;
        }
        ItemStock other = (ItemStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.store.pos.model.entity.ItemStock[ id=" + id + " ]";
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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
     * @return the contity
     */
    public int getContity() {
        return contity;
    }

    /**
     * @param contity the contity to set
     */
    public void setContity(int contity) {
        this.contity = contity;
    }

    /**
     * @return the exDate
     */
    public Date getExDate() {
        return exDate;
    }

    /**
     * @param exDate the exDate to set
     */
    public void setExDate(Date exDate) {
        this.exDate = exDate;
    }

    /**
     * @return the retailDis
     */
    public float getRetailDis() {
        return retailDis;
    }

    /**
     * @param retailDis the retailDis to set
     */
    public void setRetailDis(float retailDis) {
        this.retailDis = retailDis;
    }

    /**
     * @return the wholeSaleDis
     */
    public float getWholeSaleDis() {
        return wholeSaleDis;
    }

    /**
     * @param wholeSaleDis the wholeSaleDis to set
     */
    public void setWholeSaleDis(float wholeSaleDis) {
        this.wholeSaleDis = wholeSaleDis;
    }
    
}
