/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.model.entity.controller;

import com.store.pos.model.entity.CustomerLoan;
import com.store.pos.model.entity.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sanjeewa;
 */
public class CustomerLoanJpaController implements Serializable {

    public CustomerLoanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CustomerLoan customerLoan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(customerLoan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CustomerLoan customerLoan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            customerLoan = em.merge(customerLoan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customerLoan.getId();
                if (findCustomerLoan(id) == null) {
                    throw new NonexistentEntityException("The customerLoan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CustomerLoan customerLoan;
            try {
                customerLoan = em.getReference(CustomerLoan.class, id);
                customerLoan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customerLoan with id " + id + " no longer exists.", enfe);
            }
            em.remove(customerLoan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CustomerLoan> findCustomerLoanEntities() {
        return findCustomerLoanEntities(true, -1, -1);
    }

    public List<CustomerLoan> findCustomerLoanEntities(int maxResults, int firstResult) {
        return findCustomerLoanEntities(false, maxResults, firstResult);
    }

    private List<CustomerLoan> findCustomerLoanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CustomerLoan.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CustomerLoan findCustomerLoan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CustomerLoan.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerLoanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CustomerLoan> rt = cq.from(CustomerLoan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
