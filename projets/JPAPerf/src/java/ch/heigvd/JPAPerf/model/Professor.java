/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.ProfessorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author gauss
 */
@NamedQueries({
    @NamedQuery(name="Professor.findByName",
        query="SELECT p FROM Professor p WHERE p.lastName = :name"),
    @NamedQuery(name="Professor.findByPeriod",
        query="SELECT p FROM Professor p WHERE p.periods = :periods"),
    @NamedQuery(name="Professor.findByPeriodInRange",
        query="SELECT p FROM Professor p WHERE p.periods > :min AND p.periods < :max"),
    @NamedQuery(name="Professor.findBusy",
        query="SELECT p FROM Professor p WHERE p.periods > :hours"),
    @NamedQuery(name="Professor.findFree",
        query="SELECT p FROM Professor p WHERE p.periods < :hours"),
    @NamedQuery(name="Professor.findBySpecialization",
        query="SELECT p FROM Professor p WHERE p.specialization = :specialization")
})
@Entity
public class Professor extends Person {
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @OneToMany(mappedBy = "professor")
    private List<Course>courses;

    public Professor() {
    }

    public Professor(String name) {
        super(name);
        
        Specialization array[] = Specialization.values();
        int random = (int)(Math.random()*(array.length));
        this.specialization = array[random];
        
        courses = new ArrayList<Course>();
    }

    
    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        for(Course course : courses)
            addCourse(course);
    }
    
    public void addCourse(Course course) {
        courses.add(course);
        setPeriods(getPeriods()  + course.getPeriods());
    }

    @Override
    public String toString() {
        return "Professor " + getLastName() + "\tID "+ getId();
    }
    
    public void setDescriptor(ProfessorDTO professorDTO){
        this.setId(professorDTO.getId());
        this.setLastName(professorDTO.getName());
        this.specialization = professorDTO.getSpecialization();
        this.setPeriods(professorDTO.getPeriod());
        
        if(professorDTO.getCoursesDTO() != null)
            for(CourseDTO courseDTO: professorDTO.getCoursesDTO()){
                Course course = new Course();
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setSemester(courseDTO.getSemester());
                courses.add(course);
            }
    }    
}
