/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Requests;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface RequestsFacadeLocal {

    void create(Requests requests);

    void edit(Requests requests);

    void remove(Requests requests);

    Requests find(Object id);

    List<Requests> findAll();

    List<Requests> findRange(int[] range);

    int count();
    
}
