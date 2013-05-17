/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Professor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless

public class ProfessorManager extends AbstractManager<Professor> implements ProfessorManagerLocal {
    @PersistenceContext
    private EntityManager em;
    
    public ProfessorManager() {
        super(Professor.class);
    }
    
    public void assignCourseToProfessor (Long courseID, Long professorID){
        Course course = em.find(Course.class, courseID);
        Professor professor = find(professorID);
        
        if((!(professor.getCourses()).contains(course))&&(course != null)){
            (professor.getCourses()).add(course);
            course.setProfessor(professor);
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    
    
    
}
