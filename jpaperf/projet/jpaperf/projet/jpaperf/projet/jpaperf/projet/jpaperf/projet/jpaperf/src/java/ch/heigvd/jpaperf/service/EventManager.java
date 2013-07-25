/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Event;
import ch.heigvd.jpaperf.model.Specialization;
import ch.heigvd.jpaperf.service.EventManagerLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class EventManager extends AbstractManager<Event> implements EventManagerLocal {
    @PersistenceContext(unitName = "jpaperfPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EventManager() {
        super(Event.class);
    }
    
    @Override
    public Long countEvent(){
        String query = "SELECT COUNT(e.id) FROM Course e";
        return (Long) em.createQuery(query).getSingleResult();
    }
    
    
    @Override
    public List findEventByDate(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date d = sdf.parse(date);
        return em.createNamedQuery("Event.findBydate")
                .setParameter("date", d)
                .getResultList();
    }
    
    @Override
    public List findEventByType(String eventType){
        return em.createNamedQuery("Event.eventType")
                .setParameter("eventType", Specialization.valueOf(eventType))
                .getResultList();
    }
    
}
