/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.service;

import ch.heigvd.jpaperf.metric.model.JPAQuery;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface JPAQueryManagerLocal {

    void create(JPAQuery metricEvent);

    void edit(JPAQuery metricEvent);

    void remove(JPAQuery metricEvent);

    JPAQuery find(Object id);

    List<JPAQuery> findAll();

    List<JPAQuery> findRange(int[] range);

    int count();
    
}
