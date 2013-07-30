/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Course;
import ch.heigvd.jpaperf.model.Event;
import ch.heigvd.jpaperf.model.Person;
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
     * Aims to assign a course to a professor randomly
     */
    @Override
    public boolean assignCourseToProfessor(Course course) {
        List<Professor> professors = professorManager.findAll();
        int random = (int) (Math.random() * (professors.size() - 1)) + 1;
        Professor professor = professors.get(random);

        if (!professor.getCourses().contains(course)) {
            professor.addCourse(course);
            course.setProfessor(professor);
            return true;
        }

        return false;
    }

    /**
     * Aims to assign a course to a particular professor
     */
    @Override
    public boolean assignCourseToProfessor(Long IDProfessor, Long IDCourse) {
        Professor professor = professorManager.find(IDProfessor);
        Course course = courseManager.find(IDCourse);

        if (!professor.getCourses().contains(course)) {
            professor.addCourse(course);
            course.setProfessor(professor);
            return true;
        }

        return false;
    }

    /**
     * Aims to assign an Event to a professor randomly
     */
    @Override
    public boolean assignEventToProfessor(Event event) {
        Long random = (long) (Math.random() * (professorManager.count() - 1)) + 1;
        Person professor = professorManager.find(random);

        if (!professor.getEvent().contains(event)) {
            professor.addEvent(event);
            event.addPerson(professor);
            return true;
        }

        return false;
    }

    /**
     * Aims to assign an Event to a particular professor
     */
    @Override
    public boolean assignEventToProfessor(Professor professor, Event event) {

        if (!professor.getEvent().contains(event)) {
            professor.addEvent(event);
            event.addPerson(professor);
            return true;
        }

        return false;
    }

    /**
     * Aims to assign a course to a student randomly
     */
    @Override
    public boolean assignCourseToStudent(Course course) {
        Long random = (long) (Math.random() * (courseManager.count() - 1)) + 1;
        Student student = studentManager.find(random);

        if (!student.getCourses().contains(course)) {
            student.addCourse(course);
            course.addStudent(student);
            return true;
        }

        return false;
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
        
        courses.get(indexCourse);
        
 System.out.println(nbrMaxCourse);
 
        int startIndex =0;
        int endIndex = startIndex + nbrMaxCourse;
        
        for (Student student : students) {
            
            if (endIndex > nbrcourse -1) {
                endIndex = nbrcourse -1;
            }
            
            for (int count = 0; count < nbrMaxCourse; count++) {
                assignCourseToStudent(student, courses.get(indexCourse));
                
                indexCourse = (indexCourse +1)% nbrcourse;
                
//                indexCourse++;
//                if (indexCourse > nbrcourse -1) {
//                    indexCourse = 0;
//                }
            }
        }
    }

    /**
     * Aims to assign an Event to a student randomly
     */
    @Override
    public boolean assignEventToStudent(Event event) {
        Long random = (long) (Math.random() * (studentManager.count() - 1)) + 1;
        Person student = studentManager.find(random);

        if (!student.getEvent().contains(event)) {
            student.addEvent(event);
            event.addPerson(student);
            return true;
        }
        return false;
    }

    /**
     * Aims to assign an Event to a particular student
     */
    @Override
    public boolean assignEventToStudent(Student student, Event event) {

        if (!student.getEvent().contains(event)) {
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
                    assignCourseToProfessor(course);
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
     *
     * @param nbrEvent
     */
    @Override  
    public void populateEventDataBase(int nbrEvent) {
        
        List<Professor> professors = professorManager.findAll();
        List<Student> students = studentManager.findAll();
        
        int NBRPROFESSOR = professors.size();
        int NBRSTUDENT = students.size();
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
                
                if (indexProfessor > NBRPROFESSOR -1) {
                    indexProfessor = 0;
                }                
                
                if (indexStudent > NBRSTUDENT -1) {
                    indexStudent = 0;
                }  
                
                professor = professors.get(indexProfessor);
                student = students.get(indexStudent);               
                assignEventToProfessor(professor, event);
                assignEventToStudent(student, event);  
                indexProfessor++;
                indexStudent++;
            }
        }
    }
}
