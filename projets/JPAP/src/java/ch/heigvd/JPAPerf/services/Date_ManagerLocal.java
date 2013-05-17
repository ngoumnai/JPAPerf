/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Date_;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface Date_ManagerLocal {

    void create(Date_ date_);

    void edit(Date_ date_);

    void remove(Date_ date_);

    Date_ find(Object id);

    List<Date_> findAll();

    List<Date_> findRange(int[] range);

    int count();
    
}
