/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public StudentManager() {
        super(Student.class);
    }
    
    public void assignCourseToStudent (Long courseID, Long studentID){
        Course course = em.find(Course.class, courseID);
        Student student = em.find(Student.class, studentID);
        
        if(!(student.getCourses()).contains(courseID))
            (student.getCourses()).add(course);
        if(!(course.getStudents()).contains(courseID))
            (course.getStudents()).add(student);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
