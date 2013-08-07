/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.service;

import ch.heigvd.perfviewer.model.Jpaquery;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface JpaQueryMangerLocal {

    void create(Jpaquery metricevent);

    void edit(Jpaquery metricevent);

    void remove(Jpaquery metricevent);

    Jpaquery find(Object id);

    List<Jpaquery> findAll();

    List<Jpaquery> findRange(int[] range);

    int count();

    public void setHashMapOfMetric();

    public HashMap getHashMapOfMetric();
    
}
