/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.service;

import ch.heigvd.perfviewer.model.query.JPAQuery;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface JpaQueryMangerLocal {

    void create(JPAQuery metricevent);

    void edit(JPAQuery metricevent);

    void remove(JPAQuery metricevent);

    JPAQuery find(Object id);

    List<JPAQuery> findAll();

    List<JPAQuery> findRange(int[] range);

    int count();

    public void setHashMapOfJPQLRequest();

    public HashMap getHashMapOfJPQLRequest();

    public List findByQueryname(String name);
    
}
