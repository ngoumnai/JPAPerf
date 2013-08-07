/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.metric.service;

import ch.heigvd.jpaperf.metric.model.JPAQuery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class JPAQueryManager extends AbstractManager<JPAQuery> implements JPAQueryManagerLocal {
    @PersistenceContext(unitName = "metricPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JPAQueryManager() {
        super(JPAQuery.class);
    }
    
}
