/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.jee.arquillian.petcatalogmaven.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import nl.fontys.jee.arquillian.petcatalogmaven.model.Item;

/**
 *
 * @author techlogic
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> {

    @PersistenceContext(unitName = "catalogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }

    @Override
    public void create(Item item) {
        em.persist(item);
    }

    @Override
    public void edit(Item item) {
        em.merge(item);
    }

    @Override
    public void remove(Item item) {
        em.remove(em.merge(item));
    }

    @Override
    public Item find(Object id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select object(o) from Item as o").getResultList();
    }

    public List<Item> findRange(int maxResults, int firstResult) {
        Query q = em.createQuery("select object(o) from Item as o");
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public int getItemCount() {
        return ((Long) em.createQuery("select count(o) from Item as o").getSingleResult()).intValue();
    }

}
