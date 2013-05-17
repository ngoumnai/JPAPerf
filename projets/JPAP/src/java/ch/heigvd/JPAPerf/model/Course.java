/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.StudentDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author gauss
 */
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /*
     * We want to attach Course to a Professor (CascadeType.PERSIST)
     * We don't want a Professor to be removed when a Course is deleted (CascadeType.REMOVE)
     */
    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private Professor professor;
    
    //We don't want a Professor to be removed when a Course is deleted (CascadeType.REMOVE)
    @ManyToMany(mappedBy = "courses", cascade ={CascadeType.REMOVE})
    private List<Student> students;  
    private String name;
    private int semester;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Course[ id=" + id + " ]";
    }
    
    public void setDescriptor(CourseDTO courseDTO){
        this.id = courseDTO.getId();
        this.name = courseDTO.getName();
        this.semester = courseDTO.getSemester();
        
        if(courseDTO.getProfessorDTO() != null){
            professor.setId(courseDTO.getProfessorDTO().getId());
            professor.setName(courseDTO.getProfessorDTO().getName());
            professor.setTitle(courseDTO.getProfessorDTO().getTitle());
            professor.setSpecialization(courseDTO.getProfessorDTO().getSpecialization());
        }
        
        Student student = new Student();
        if(courseDTO.getStudentsDTO() != null)        
            for(StudentDTO s: courseDTO.getStudentsDTO()){
                student.setId(s.getId());
                student.setName(s.getName());
                student.setTitle(s.getTitle());
                student.setMajor(s.getMajor());
                students.add(student);
            }
    }
}
