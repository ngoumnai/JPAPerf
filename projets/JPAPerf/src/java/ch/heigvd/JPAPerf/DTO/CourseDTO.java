/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gauss
 */
public class CourseDTO {
    private Long id;
    private String name;
    private int semester;
    private int period;
    private ProfessorDTO professorDTO;
    private List<StudentDTO>studentsDTO;
    
    public CourseDTO(){
        professorDTO = new ProfessorDTO();
        studentsDTO = new ArrayList<StudentDTO>();
    }
        
    public ProfessorDTO getProfessorDTO() {
        return professorDTO;
    }

    public void setProfessorDTO(ProfessorDTO professorDTO) {
        this.professorDTO = professorDTO;
    }

    public List<StudentDTO> getStudentsDTO() {
        return studentsDTO;
    }

    public void setStudentsDTO(List<StudentDTO> student) {
        this.studentsDTO = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void setDescriptor(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.semester = course.getSemester();
        this.period = course.getPeriods();
        
        if(course.getProfessor() != null){
            professorDTO.setId(course.getProfessor().getId());
            professorDTO.setName(course.getProfessor().getLastName());
            professorDTO.setSpecialization(course.getProfessor().getSpecialization());
        }
        
        if(course.getStudents() != null)
            for(Student s: course.getStudents()){
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(s.getId());
                studentDTO.setName(s.getLastName());
                studentDTO.setMajor(s.getMajor());
                studentsDTO.add(studentDTO);
            }
    }
}
