/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Additional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface AdditionalFacadeLocal {

    void create(Additional additional);

    void edit(Additional additional);

    void remove(Additional additional);

    Additional find(Object id);

    List<Additional> findAll();

    List<Additional> findRange(int[] range);

    int count();
    
}
