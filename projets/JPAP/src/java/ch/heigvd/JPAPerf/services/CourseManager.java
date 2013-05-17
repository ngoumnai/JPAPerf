/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class CourseManager extends AbstractManager<Course> implements CourseManagerLocal {
     
    @PersistenceContext
    private EntityManager em;
        
    public CourseManager() {
        super(Course.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
}
