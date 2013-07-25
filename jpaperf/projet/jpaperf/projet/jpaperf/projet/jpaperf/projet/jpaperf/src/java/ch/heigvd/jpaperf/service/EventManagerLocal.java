/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Event;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author gauss
 */
@Local
public interface EventManagerLocal {

    void create(Event event);

    void edit(Event event);

    void remove(Event event);
    
    Event find(Object id);

    List<Event> findAll();

    List<Event> findRange(int[] range);

    int count();

    public EntityManager getEntityManager();

    public List findEventByDate(String date) throws ParseException;

    public List findEventByType(String eventType);

    public Long countEvent();
    
}
