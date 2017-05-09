/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Hosteller;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class HostellerFacade extends AbstractFacade<Hosteller> implements HostellerFacadeLocal {

    @PersistenceContext(unitName = "roomi2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HostellerFacade() {
        super(Hosteller.class);
    }
    
}
