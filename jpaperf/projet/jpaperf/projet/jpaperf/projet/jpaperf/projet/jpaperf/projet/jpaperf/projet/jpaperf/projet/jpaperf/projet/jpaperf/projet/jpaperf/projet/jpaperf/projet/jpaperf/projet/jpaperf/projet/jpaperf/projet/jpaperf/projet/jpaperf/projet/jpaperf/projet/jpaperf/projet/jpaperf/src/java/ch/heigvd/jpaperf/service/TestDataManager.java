/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Course;
import ch.heigvd.jpaperf.model.Event;
import ch.heigvd.jpaperf.model.Professor;
import ch.heigvd.jpaperf.model.Student;
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
    @PersistenceContext(unitName = "jpaperfPU")
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

    /**
     * Permet de peupler la table Professor de la base de données.
     * @param nameFile: Chemin du fichier dans lequel on va lire le nom des professeurs 
     */
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
                } else {
                    eof = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error when reading file");
        } finally {
            try {
                LecteurBufferise.close();
            } catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        }
    }
    
     /**
     * Aims to assign a fixed number of courses to students
     * @param nbrMaxCourse: The number of course per student 
     */
    @Override
    public void assignCourseToProfessor(int nbrMaxCourse) {
        List<Professor> professors = professorManager.findAll();
        List<Course> courses = courseManager.findAll();
        int nbrcourse = courses.size();
        int indexCourse = 0;  
        int indexProfessor = 0;
        while(indexProfessor < (nbrcourse/nbrMaxCourse)) { 
            for (int i = 0; i < nbrMaxCourse; i++) {
                assignCourseToProfessor(professors.get(indexProfessor), courses.get(indexCourse));               
                indexCourse = (indexCourse +1)% nbrcourse; 
            }
            indexProfessor++;
        }
    }

    /**
     * Aims to assign a course to a particular professor
     */
    @Override
    public void assignCourseToProfessor(Professor professor, Course course) {
        if (!professor.getCourses().contains(course)) {
            professor.addCourse(course);
            course.setProfessor(professor);
        }
    }
   
    /**
     * Aims to assign an Event to a particular professor
     */
    @Override
    public void assignEventToProfessor(Professor professor, Event event) {

        if (!professor.getEvent().contains(event)) {
            professor.addEvent(event);
            event.addPerson(professor);
        }
    }
   
    /**
     * Aims to assign a course to a particular student
     */
    @Override
    public void assignCourseToStudent(Student student, Course course) {

        if (!student.getCourses().contains(course)) {
            student.addCourse(course);
            course.addStudent(student);
        }
    }

    
    /**
     * Aims to assign a fixed number of courses to students
     * @param nbrMaxCourse: The number of course per student 
     */
    @Override
    public void assignCoursesToStudent(int nbrMaxCourse) {
        List<Student> students = studentManager.findAll();
        List<Course> courses = courseManager.findAll();
        int nbrcourse = courses.size();
        int indexCourse = 0; 
        for (Student student : students) { 
            for (int count = 0; count < nbrMaxCourse; count++) {
                assignCourseToStudent(student, courses.get(indexCourse));               
                indexCourse = (indexCourse +1)% nbrcourse; 
            }
        }
    }
    
    /**
     * Aims to assign an Event to a particular student
     */
    @Override
    public void assignEventToStudent(Student student, Event event) {

        if (!student.getEvent().contains(event)) {
            event.addPerson(student);
            student.addEvent(event);
        }
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
                } else {
                    eof = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error when reading file");
        } finally {
            try {
                LecteurBufferise.close();
            } catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        }
    }

    @Override
    public void populateCourseDataBase(String nameFile) {
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
                    int semester = (int) (Math.random() * (MAXSEMESTER - 1)) + 1;
                    int period = (int) (Math.random() * (MAXPERIOD - 1)) + 2;
                    Course course = new Course(courseName, semester, period);
                    courseManager.create(course);
                } else {
                    eof = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error when reading file");
        } finally {
            try {
                LecteurBufferise.close();
            } catch (IOException ex1) {
                System.out.println("Error when closing file");
            }
        }
    }

    /**
     * Allows to create events and assign them to teachers and students
     * @param nbrEvent
     */
    @Override  
    public void populateEventDataBase(int nbrEvent) {
        
        List<Professor> professors = professorManager.findAll();
        List<Student> students = studentManager.findAll();
        
        int nbrprofessor = professors.size(); // Total number of professor
        int nbrstudent = students.size(); // Total number of student
        int indexProfessor = 0,
                indexStudent = 0;
        int countEvent = 0;
        Professor professor;
        Student student;

        for (int count = 0; count < nbrEvent; count++) {
            Event event = new Event();
            eventManager.create(event);
            countEvent++;

            if (countEvent > 10) {
                countEvent = 1;
            }

            for (int i = 1; i <= countEvent; i++) {
                professor = professors.get(indexProfessor);
                student = students.get(indexStudent);               
                assignEventToProfessor(professor, event);
                assignEventToStudent(student, event);  
                indexProfessor = (indexProfessor + 1)% nbrprofessor;
                indexStudent = (indexStudent + 1)% nbrstudent;
            }
        }
    }
}
