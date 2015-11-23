/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.jee.arquillian.carseller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author techlogic
 */
@Stateless
public class CarBrandFacade extends AbstractFacade<CarBrand> {
    @PersistenceContext(unitName = "nl.fontys.jee.arquillian_carseller_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarBrandFacade() {
        super(CarBrand.class);
    }
    
}
