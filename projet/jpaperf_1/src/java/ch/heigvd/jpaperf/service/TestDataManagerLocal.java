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
    
    boolean assignCourseToProfessor (Course course);
    
    boolean assignCourseToProfessor (Long IDProfessor, Long IDCourse);
    
    void assignCoursesToStudent (int nbrMaxCourse);
    
    boolean assignCourseToStudent (Course course);
    
    void assignCourseToStudent (Student student, Course course);
    
    boolean assignEventToProfessor (Event event);
    
    boolean assignEventToProfessor (Professor professor, Event event);
    
    boolean assignEventToStudent (Event event);
    
    boolean assignEventToStudent (Student student, Event event);
    
    void populateCourseDataBase(String nameFile);
    
    void populateEventDataBase(int nbrEvent);
    
    void populateProfessorDateBase(String nameFile);
    
    void populateStudentDataBase(String nameFile);
    
}
