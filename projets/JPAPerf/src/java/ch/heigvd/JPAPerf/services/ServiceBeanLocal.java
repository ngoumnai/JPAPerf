/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.model.Student;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gauss
 */
@Local
public interface ServiceBeanLocal {

    public Course findCourseByName(String name);

    public List findCourseBySemester(int semester);

    public List findCourseByPeriod(int period);

    public List findCourseByPeriodInRange(int min, int max);

    public Professor findProfessorByName(String name);

    public List findProfessorByPeriod(int period);

    public List findProfessorByPeriodInRange(int min, int max);

    public List findBusyProfessor();

    public List findFreeProfessor();

    public List findProfessorBySpecialization(String specialization);

    public Student findStudentByName(String name);

    public List findStudentByPeriod(int period);

    public List findStudentByPeriodInRange(int min, int max);

    public List findBusyStudent();

    public List findFreeStudent();

    public List findStudentByMajor(String specialization);

    public List findEventByDate(String date) throws ParseException;

    public List findEventByType(String eventType);
    
}
