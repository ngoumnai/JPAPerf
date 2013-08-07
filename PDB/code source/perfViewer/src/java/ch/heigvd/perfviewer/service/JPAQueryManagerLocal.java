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
public interface JPAQueryManagerLocal {

    void create(JPAQuery jpaquery);

    void edit(JPAQuery jpaquery);

    void remove(JPAQuery jpaquery);

    JPAQuery find(Object id);

    List<JPAQuery> findAll();

    List<JPAQuery> findRange(int[] range);

    int count();

    public List findByQueryname(String name);

    public HashMap getHashMapOfJPQLRequest();

    public void setHashMapOfJPQLRequest();
    
}
