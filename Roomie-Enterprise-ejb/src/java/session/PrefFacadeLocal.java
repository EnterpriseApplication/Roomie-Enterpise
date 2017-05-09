/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Pref;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface PrefFacadeLocal {

    void create(Pref pref);

    void edit(Pref pref);

    void remove(Pref pref);

    Pref find(Object id);

    List<Pref> findAll();

    List<Pref> findRange(int[] range);

    int count();
    
}
