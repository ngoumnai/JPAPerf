/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.service;

import ch.heigvd.perfviewer.model.Bean.JPQLRequestBean;
import ch.heigvd.perfviewer.model.query.JPAQuery;
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
public class JpaQueryManager extends AbstractManager<JPAQuery> implements JpaQueryMangerLocal {
    @PersistenceContext(unitName = "perfViewerPU")
    private EntityManager em;
    HashMap<String, JPQLRequestBean> hashMapOfJPQLRequest;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JpaQueryManager() {
        super(JPAQuery.class);
    }
    
    @Override
    public List findByQueryname(String name){
        return em.createNamedQuery("Jpaquery.findByQueryname")
                .setParameter("name", name)
                .getResultList();
    }
    
    @Override
    public HashMap getHashMapOfJPQLRequest(){
        setHashMapOfJPQLRequest();        
        return hashMapOfJPQLRequest;        
    }
    
    @Override
    public void setHashMapOfJPQLRequest(){
        List<JPAQuery> queryList = findAll();
        hashMapOfJPQLRequest = new HashMap<String, JPQLRequestBean>();
        
        for(JPAQuery jpaQuery: queryList){
            //on ajoute la nouvelle requete a la liste des requetes identiques du JPQLRequestBean
            if(hashMapOfJPQLRequest.containsKey(jpaQuery.getQueryname())){
                ((JPQLRequestBean) hashMapOfJPQLRequest.get(jpaQuery.getQueryname())).setJPQLRequestInfo(jpaQuery);
            }
            //On cree une liste de requete si ce type de requete n'a pas encore ete effectuee
            else{
                JPQLRequestBean jpqlR = new JPQLRequestBean(jpaQuery);
                hashMapOfJPQLRequest.put(jpaQuery.getQueryname(), jpqlR);
            }
        }
    }
    
}
