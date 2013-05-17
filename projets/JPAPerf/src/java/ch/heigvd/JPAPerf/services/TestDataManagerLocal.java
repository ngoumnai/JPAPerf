/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Event;
import ch.heigvd.JPAPerf.model.Student;
import java.util.List;
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
    
    boolean assignCourseToStudent (Student student, Course course);
    
    boolean assignEventToProfessor (Event event);
    
    boolean assignEventToProfessor (Long IDProfessor, Long IDEvent);
    
    boolean assignEventToStudent (Event event);
    
    boolean assignEventToStudent (Long IDStudent, Long IDEvent);
    
    void populateCourseDataBase(String nameFile);
    
    void populateEventDataBase(int nbrEvent, int nbrMaxProfessor, int nbrMaxStudent);
    
    void populateProfessorDateBase(String nameFile);
    
    void populateStudentDataBase(String nameFile);
    
}
