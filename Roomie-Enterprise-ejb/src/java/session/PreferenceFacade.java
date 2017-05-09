/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Preference;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class PreferenceFacade extends AbstractFacade<Preference> implements PreferenceFacadeLocal {

    @PersistenceContext(unitName = "roomi2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreferenceFacade() {
        super(Preference.class);
    }
    
}
