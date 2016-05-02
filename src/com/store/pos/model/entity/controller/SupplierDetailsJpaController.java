/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.model.entity.controller;

import com.store.pos.model.entity.SupplierDetails;
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
public class SupplierDetailsJpaController implements Serializable {

    public SupplierDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SupplierDetails supplierDetails) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(supplierDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SupplierDetails supplierDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            supplierDetails = em.merge(supplierDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = supplierDetails.getSupplierID();
                if (findSupplierDetails(id) == null) {
                    throw new NonexistentEntityException("The supplierDetails with id " + id + " no longer exists.");
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
            SupplierDetails supplierDetails;
            try {
                supplierDetails = em.getReference(SupplierDetails.class, id);
                supplierDetails.getSupplierID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The supplierDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(supplierDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SupplierDetails> findSupplierDetailsEntities() {
        return findSupplierDetailsEntities(true, -1, -1);
    }

    public List<SupplierDetails> findSupplierDetailsEntities(int maxResults, int firstResult) {
        return findSupplierDetailsEntities(false, maxResults, firstResult);
    }

    private List<SupplierDetails> findSupplierDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SupplierDetails.class));
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

    public SupplierDetails findSupplierDetails(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SupplierDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupplierDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SupplierDetails> rt = cq.from(SupplierDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
