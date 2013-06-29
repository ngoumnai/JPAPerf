/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author gauss
 */
@Stateless
public class CourseManager extends AbstractManager<Course> implements CourseManagerLocal{
     
    @PersistenceContext
    private EntityManager em;
        
    public CourseManager() {
        super(Course.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }       
    
    @Override
    public Long countCourse(){
        String query = "SELECT COUNT(c.id) FROM Course c";
        return (Long) em.createQuery(query).getSingleResult();
    }
    
    /**
     *
     * @param name
     * @return
     */
    @Override
    public Course findCourseByName(String name){
        return (Course)em.createNamedQuery("Course.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public List findCourseBySemester(int semester){
        return em.createNamedQuery("Course.findBySemester")
                .setParameter("semester", semester)
                .getResultList();
    }
    
    @Override
    public List findCourseByPeriod(int period){
        return em.createNamedQuery("Course.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findCourseByPeriodInRange(int min, int max){
        return em.createNamedQuery("Course.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
}
