/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.service;

import ch.heigvd.perfviewer.model.MetricBean;
import ch.heigvd.perfviewer.model.Jpaquery;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class JpaQueryManager extends AbstractManager<Jpaquery> implements JpaQueryMangerLocal {
    @PersistenceContext(unitName = "perfViewerPU")
    private EntityManager em;
    HashMap hashtableOfMetric;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JpaQueryManager() {
        super(Jpaquery.class);
        hashtableOfMetric = new HashMap();
    }
    
    @Override
    public HashMap getHashMapOfMetric(){
        setHashMapOfMetric();        
        return hashtableOfMetric;        
    }
    
    @Override
    public void setHashMapOfMetric(){
        List<Jpaquery> queryList = findAll();
        for(Jpaquery me: queryList){
            if(hashtableOfMetric.containsKey(me.getQueryname())){
                ((MetricBean) hashtableOfMetric.get(me.getQueryname())).addMetricEvent(me);
            }
            else{
                MetricBean mb = new MetricBean();
                mb.addMetricEvent(me);
                hashtableOfMetric.put(me.getQueryname(), queryList);
            }
        }
    }
    
}
