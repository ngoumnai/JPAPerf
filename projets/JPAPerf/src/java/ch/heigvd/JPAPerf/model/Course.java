/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.StudentDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author gauss
 */
@NamedQueries({
    @NamedQuery(name="Course.findByName",
        query="SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name="Course.findBySemester",
        query="SELECT c FROM Course c WHERE c.semester = :semester"),
    @NamedQuery(name="Course.findBySemesterInRange",
        query="SELECT c FROM Course c WHERE c.semester > :min AND c.semester < :max"),
    @NamedQuery(name="Course.findByPeriod",
        query="SELECT c FROM Course c WHERE c.periods = :periods"),
    @NamedQuery(name="Course.findByPeriodInRange",
        query="SELECT c FROM Course c WHERE c.periods > :min AND c.periods < :max")
})
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
    private int periods;

    public Course() {
        this.students = new ArrayList<Student>();
    }

    public Course(String name, int semester, int period) {
        this.students = new ArrayList<Student>();
        this.name = name;
        this.semester = semester;
        this.periods = period;
    }
    
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

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
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
        this.periods = courseDTO.getPeriod();
        
        if(courseDTO.getProfessorDTO() != null){
            professor.setId(courseDTO.getProfessorDTO().getId());
            professor.setLastName(courseDTO.getProfessorDTO().getName());
            professor.setSpecialization(courseDTO.getProfessorDTO().getSpecialization());
        }
        
        if(courseDTO.getStudentsDTO() != null)        
            for(StudentDTO s: courseDTO.getStudentsDTO()){
                Student student = new Student();
                student.setId(s.getId());
                student.setLastName(s.getName());
                student.setMajor(s.getMajor());
                students.add(student);
            }
    }
}
