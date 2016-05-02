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
public class CustomerLoan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long customerID;
    private String name;
    private float loan; // given loan price
    private Date giveDate;
    private Date dueDate;
    private boolean isPay; // he succesfully pay it or not;

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
        if (!(object instanceof CustomerLoan)) {
            return false;
        }
        CustomerLoan other = (CustomerLoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.store.pos.model.entity.CustomerLoan[ id=" + id + " ]";
    }

    /**
     * @return the customerID
     */
    public Long getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the loan
     */
    public float getLoan() {
        return loan;
    }

    /**
     * @param loan the loan to set
     */
    public void setLoan(float loan) {
        this.loan = loan;
    }

    /**
     * @return the giveDate
     */
    public Date getGiveDate() {
        return giveDate;
    }

    /**
     * @param giveDate the giveDate to set
     */
    public void setGiveDate(Date giveDate) {
        this.giveDate = giveDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the isPay
     */
    public boolean isIsPay() {
        return isPay;
    }

    /**
     * @param isPay the isPay to set
     */
    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }
    
}
