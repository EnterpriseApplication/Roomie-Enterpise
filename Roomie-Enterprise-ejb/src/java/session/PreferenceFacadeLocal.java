/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Preference;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface PreferenceFacadeLocal {

    void create(Preference preference);

    void edit(Preference preference);

    void remove(Preference preference);

    Preference find(Object id);

    List<Preference> findAll();

    List<Preference> findRange(int[] range);

    int count();
    
}
