/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.dto;

/**
 *
 * @author gauss
 */
public class TestDataDTO {
    String courseNamePath;
    String professorNamePath;
    String studentNamePath;
    int nbrEvent,
            nbrMaxCoursPerStudent,
            nbrMaxProfessor,
            nbrMaxStudent;

    public String getCourseNamePath() {
        return courseNamePath;
    }

    public String getProfessorNamePath() {
        return professorNamePath;
    }

    public String getStudentNamePath() {
        return studentNamePath;
    }

    public int getNbrEvent() {
        return nbrEvent;
    }

    public int getNbrMaxProfessor() {
        return nbrMaxProfessor;
    }

    public int getNbrMaxStudent() {
        return nbrMaxStudent;
    }

    public int getNbrMaxCoursPerStudent() {
        return nbrMaxCoursPerStudent;
    }
    
    
}
