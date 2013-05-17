/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.model.Specialization;
import ch.heigvd.JPAPerf.model.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class ServiceBean implements ServiceBeanLocal {

    @PersistenceContext
    private EntityManager em;
    private final int PROFESSORMAXHOURS = 20;
    private final int PROFESSORMINHOURS = 8;
    private final int STUDENTMAXHOURS = 38;
    private final int STUDENTMINHOURS = 20;
    
    @EJB
    EventManagerLocal eventManager;
    @EJB
    CourseManagerLocal courseManager;
    @EJB
    ProfessorManagerLocal professorManager;
    @EJB
    StudentManagerLocal studentManager;
     
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Course findCourseByName(String name){
        return (Course)courseManager.getEntityManager().createNamedQuery("Course.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public List findCourseBySemester(int semester){
        return courseManager.getEntityManager().createNamedQuery("Course.findBySemester")
                .setParameter("semester", semester)
                .getResultList();
    }
    
    @Override
    public List findCourseByPeriod(int period){
        return courseManager.getEntityManager().createNamedQuery("Course.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findCourseByPeriodInRange(int min, int max){
        return courseManager.getEntityManager().createNamedQuery("Course.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
    
    @Override
    public Professor findProfessorByName(String name){
        return (Professor)professorManager.getEntityManager().createNamedQuery("Professor.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public List findProfessorByPeriod(int period){
        return professorManager.getEntityManager().createNamedQuery("Professor.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findProfessorByPeriodInRange(int min, int max){
        return professorManager.getEntityManager().createNamedQuery("Professor.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
    
    @Override
    public List findBusyProfessor(){
        return professorManager.getEntityManager().createNamedQuery("Professor.findBusy")
                .setParameter("hours", PROFESSORMAXHOURS)
                .getResultList();
    }
    
    @Override
    public List findFreeProfessor(){
        return professorManager.getEntityManager().createNamedQuery("Professor.findFree")
                .setParameter("hours", PROFESSORMINHOURS)
                .getResultList();
    }
    
    @Override
    public List findProfessorBySpecialization(String specialization){
        return professorManager.getEntityManager().createNamedQuery("Professor.findBySpecialization")
                .setParameter("specialization", Specialization.valueOf(specialization))
                .getResultList();
    }
    
    @Override
    public Student findStudentByName(String name){
        return (Student)studentManager.getEntityManager().createNamedQuery("Student.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public List findStudentByPeriod(int period){
        return studentManager.getEntityManager().createNamedQuery("Student.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findStudentByPeriodInRange(int min, int max){
        return studentManager.getEntityManager().createNamedQuery("Student.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
    
    @Override
    public List findBusyStudent(){
        return studentManager.getEntityManager().createNamedQuery("Student.findBusy")
                .setParameter("hours", STUDENTMAXHOURS)
                .getResultList();
    }
    
    @Override
    public List findFreeStudent(){
        return studentManager.getEntityManager().createNamedQuery("Student.findFree")
                .setParameter("hours", STUDENTMINHOURS)
                .getResultList();
    }
    
    @Override
    public List findStudentByMajor(String major){
        return studentManager.getEntityManager().createNamedQuery("Student.findByMajor")
                .setParameter("major", Specialization.valueOf(major))
                .getResultList();
    }
    
    @Override
    public List findEventByDate(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date d = sdf.parse(date);
        return eventManager.getEntityManager().createNamedQuery("Event.findBydate")
                .setParameter("date", d)
                .getResultList();
    }
    
    @Override
    public List findEventByType(String eventType){
        return eventManager.getEntityManager().createNamedQuery("Event.eventType")
                .setParameter("eventType", Specialization.valueOf(eventType))
                .getResultList();
    }
}
