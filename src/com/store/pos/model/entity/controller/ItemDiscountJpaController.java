/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.model.entity.controller;

import com.store.pos.model.entity.ItemDiscount;
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
public class ItemDiscountJpaController implements Serializable {

    public ItemDiscountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemDiscount itemDiscount) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemDiscount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemDiscount itemDiscount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemDiscount = em.merge(itemDiscount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = itemDiscount.getId();
                if (findItemDiscount(id) == null) {
                    throw new NonexistentEntityException("The itemDiscount with id " + id + " no longer exists.");
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
            ItemDiscount itemDiscount;
            try {
                itemDiscount = em.getReference(ItemDiscount.class, id);
                itemDiscount.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemDiscount with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemDiscount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemDiscount> findItemDiscountEntities() {
        return findItemDiscountEntities(true, -1, -1);
    }

    public List<ItemDiscount> findItemDiscountEntities(int maxResults, int firstResult) {
        return findItemDiscountEntities(false, maxResults, firstResult);
    }

    private List<ItemDiscount> findItemDiscountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemDiscount.class));
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

    public ItemDiscount findItemDiscount(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemDiscount.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemDiscountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemDiscount> rt = cq.from(ItemDiscount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
