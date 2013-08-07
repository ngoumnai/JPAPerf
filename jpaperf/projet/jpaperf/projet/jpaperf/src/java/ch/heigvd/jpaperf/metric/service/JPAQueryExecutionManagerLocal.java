/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.service;

import ch.heigvd.jpaperf.metric.model.JPAQueryExecution;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface JPAQueryExecutionManagerLocal {

    void create(JPAQueryExecution jPAQueryExecution);

    void edit(JPAQueryExecution jPAQueryExecution);

    void remove(JPAQueryExecution jPAQueryExecution);

    JPAQueryExecution find(Object id);

    List<JPAQueryExecution> findAll();

    List<JPAQueryExecution> findRange(int[] range);

    int count();
    
}
