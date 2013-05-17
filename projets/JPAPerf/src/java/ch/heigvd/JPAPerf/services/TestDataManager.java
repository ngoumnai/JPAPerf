/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Event;
import ch.heigvd.JPAPerf.model.Person;
import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.model.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class TestDataManager implements TestDataManagerLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
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

    @Override
    public void populateProfessorDateBase(String nameFile) {
        BufferedReader LecteurBufferise = null;
        String professorName;
        boolean eof = false;
        try {
            LecteurBufferise = new BufferedReader(new FileReader(nameFile));
            while (!eof) {
                professorName = LecteurBufferise.readLine();
                if (professorName != null) {
                    professorManager.create(new Professor(professorName));
                }
                else
                    eof = true;    
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("Error when reading file");
        }
        finally {
            try {
                LecteurBufferise.close();
            }
            catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        }
    }
    
    /**
    *Aims to assign a course to a professor randomly
    */
    @Override
    public boolean assignCourseToProfessor (Course course){        
        Long random = (long)(Math.random()*(professorManager.count() - 1)) + 1;
        Professor professor = professorManager.find(random);
        
        if(!professor.getCourses().contains(course)){
            professor.addCourse(course);
            course.setProfessor(professor);  
            return true;
        }    
        
        return false;
    }
    
    /**
    *Aims to assign a course to a particular professor
    */
    @Override
    public boolean assignCourseToProfessor (Long IDProfessor, Long IDCourse){
        Professor professor = professorManager.find(IDProfessor);
        Course course = courseManager.find(IDCourse);  
        
        if(!professor.getCourses().contains(course)){
            professor.addCourse(course);
            course.setProfessor(professor);
            return true;
        }    
        
        return false;
    }
    
    /**
    *Aims to assign an Event to a professor randomly
    */
    @Override
    public boolean assignEventToProfessor (Event event){        
        Long random = (long)(Math.random()*(professorManager.count() - 1)) + 1;
        Person professor = professorManager.find(random);
        
        if(!professor.getEvent().contains(event)){
            professor.addEvent(event);
            event.addPerson(professor);
            return true;
        }    
        
        return false;
    }
    
    /**
    *Aims to assign an Event to a particular professor
    */
    @Override
    public boolean assignEventToProfessor (Long IDProfessor, Long IDEvent){        
        Person professor = professorManager.find(IDProfessor);
        Event event = eventManager.find(IDEvent);
        
        if(!professor.getEvent().contains(event)){
            professor.addEvent(event);
            event.addPerson(professor);  
            return true;
        }    
        
        return false;       
    }
        
    /**
    *Aims to assign a course to a student randomly
    */
    @Override
    public boolean assignCourseToStudent (Course course){        
        Long random = (long)(Math.random()*(courseManager.count() - 1)) + 1;
        Student student = studentManager.find(random);
        
        if(!student.getCourses().contains(course)){
            student.addCourse(course);
            course.addStudent(student); 
            return true;
        }    
        
        return false; 
    }
    
    /**
    *Aims to assign a course to a particular student
    */
    @Override
    public boolean assignCourseToStudent (Student student, Course course){
        
        if(!student.getCourses().contains(course)){
            student.addCourse(course);
            course.addStudent(student);
            return true;
        }    
        
        return false;      
    }
    
    /**
    *Aims to assign courses to a student
    */
    @Override
    public void assignCoursesToStudent (int nbrMaxCourse){
        List<Student> students = studentManager.findAll();
        int nbrCourse = courseManager.count() -1;
        boolean resultat = true;
        Long random;
        
        for(Student student: students){
            resultat = true;
            for(int count=0; count < nbrMaxCourse; count++){
                random = (long)(Math.random()*nbrCourse) + 1;
                assignCourseToStudent(student, courseManager.find(random));
            }
        }   
    }
        
    /**
    *Aims to assign an Event to a student randomly
    */
    @Override
    public boolean assignEventToStudent (Event event){        
        Long random = (long)(Math.random()*(studentManager.count() - 1)) + 1;
        Person student = studentManager.find(random);
        
        if(!student.getEvent().contains(event)){
            student.addEvent(event);
            event.addPerson(student);
            return true;
        }
        return false;
    }
    
    /**
    *Aims to assign an Event to a particular student
    */
    @Override
    public boolean assignEventToStudent (Long IDStudent, Long IDEvent){        
        Person student = studentManager.find(IDStudent);
        Event event = eventManager.find(IDEvent);        
        
        if(!student.getEvent().contains(event)){           
            event.addPerson(student);
            student.addEvent(event);
            return true;
        }
        return false;
    }
    
    @Override
    public void populateStudentDataBase(String nameFile) {
        BufferedReader LecteurBufferise = null;
        String studentName;
        boolean eof = false;
        try {
            LecteurBufferise = new BufferedReader(new FileReader(nameFile));
            while (!eof) {
                studentName = LecteurBufferise.readLine();
                if (studentName != null) {
                    studentManager.create(new Student(studentName));
                }
                else
                    eof = true;    
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("Error when reading file");
        }
        finally {
            try {
                LecteurBufferise.close();
            }
            catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        }    
    }
    
    @Override
    public void populateCourseDataBase(String nameFile){
        BufferedReader LecteurBufferise = null;
        int MAXSEMESTER = 6;
        int MAXPERIOD = 15;
        String courseName;
        boolean eof = false;
        try {
            LecteurBufferise = new BufferedReader(new FileReader(nameFile));
            while (!eof) {
                courseName = LecteurBufferise.readLine();
                if (courseName != null) {
                    int semester = (int)(Math.random()*(MAXSEMESTER -1)) + 1;
                    int period = (int)(Math.random()*(MAXPERIOD -1)) + 2;
                    Course course = new Course(courseName,semester ,period);
                    courseManager.create(course);
                    assignCourseToProfessor(course);
                }
                else
                    eof = true;    
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("Error when reading file");
        }
        finally {
            try {
                LecteurBufferise.close();
            }
            catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        } 
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void populateEventDataBase(int nbrEvent, int nbrMaxProfessor, int nbrMaxStudent){
        int nbrProfessor = (int)(Math.random()*nbrMaxProfessor);
        int nbrStudent = (int)(Math.random()*nbrMaxStudent); 
        
        for(int countEvent =0; countEvent < nbrEvent; countEvent++){
            Event event = new Event();
            eventManager.create(event);
            
            for(int countProfessor =0; countProfessor < nbrProfessor; countProfessor++)
                while(!assignEventToProfessor(event))
                    ;
            
            for(int countStudent =0; countStudent < nbrStudent; countStudent++)
                while(!assignEventToStudent(event))
                    ;
        }
    }
}
