/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Specialization;
import ch.heigvd.jpaperf.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class StudentManager extends AbstractManager<Student> implements StudentManagerLocal {
    @PersistenceContext
    private EntityManager em;
    private final int STUDENTMAXHOURS = 38;
    private final int STUDENTMINHOURS = 20;
    
    public StudentManager() {
        super(Student.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }    
    
    @Override
    public Long countStudent(){
        String query = "SELECT COUNT(s.id) FROM Student s";
        return (Long) em.createQuery(query).getSingleResult();
    }
    
    @Override
    public Student findStudentByName(String name){
        return (Student)em.createNamedQuery("Student.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public List findStudentByPeriod(int period){
        return em.createNamedQuery("Student.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findStudentByPeriodInRange(int min, int max){
        return em.createNamedQuery("Student.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
    
    @Override
    public List findBusyStudent(){
        return em.createNamedQuery("Student.findBusy")
                .setParameter("hours", STUDENTMAXHOURS)
                .getResultList();
    }
    
    @Override
    public List findFreeStudent(){
        return em.createNamedQuery("Student.findFree")
                .setParameter("hours", STUDENTMINHOURS)
                .getResultList();
    }
    
    @Override
    public List findStudentByMajor(String major){
        return em.createNamedQuery("Student.findByMajor")
                .setParameter("major", Specialization.valueOf(major))
                .getResultList();
    }
}
