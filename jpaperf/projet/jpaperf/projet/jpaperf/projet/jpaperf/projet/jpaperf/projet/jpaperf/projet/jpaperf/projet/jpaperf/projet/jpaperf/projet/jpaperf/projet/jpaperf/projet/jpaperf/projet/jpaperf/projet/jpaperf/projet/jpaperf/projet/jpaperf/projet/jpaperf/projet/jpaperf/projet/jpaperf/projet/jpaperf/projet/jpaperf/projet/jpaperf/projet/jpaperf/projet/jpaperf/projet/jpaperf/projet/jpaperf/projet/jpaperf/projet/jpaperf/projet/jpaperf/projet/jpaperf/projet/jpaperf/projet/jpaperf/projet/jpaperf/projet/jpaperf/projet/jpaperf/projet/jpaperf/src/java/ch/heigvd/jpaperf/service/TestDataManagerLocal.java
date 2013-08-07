/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Course;
import ch.heigvd.jpaperf.model.Event;
import ch.heigvd.jpaperf.model.Professor;
import ch.heigvd.jpaperf.model.Student;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface TestDataManagerLocal {
    
    void assignCourseToProfessor (Professor professor, Course course);
    
    void assignCoursesToStudent (int nbrMaxCourse);
    
    void assignCourseToStudent (Student student, Course course);
    
    void assignEventToProfessor (Professor professor, Event event);
    
    void assignEventToStudent (Student student, Event event);
    
    void populateCourseDataBase(String nameFile);
    
    void populateEventDataBase(int nbrEvent);
    
    void populateProfessorDateBase(String nameFile);
    
    void populateStudentDataBase(String nameFile);

    public void assignCourseToProfessor(int nbrMaxCourse);
    
}
