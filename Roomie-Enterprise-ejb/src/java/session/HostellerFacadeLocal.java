/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Hosteller;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface HostellerFacadeLocal {

    void create(Hosteller hosteller);

    void edit(Hosteller hosteller);

    void remove(Hosteller hosteller);

    Hosteller find(Object id);

    List<Hosteller> findAll();

    List<Hosteller> findRange(int[] range);

    int count();
    
}
