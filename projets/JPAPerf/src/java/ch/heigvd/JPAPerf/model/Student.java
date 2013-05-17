/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.StudentDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author gauss
 */
@NamedQueries({
    @NamedQuery(name="Student.findByName",
        query="SELECT s FROM Student s WHERE s.lastName = :name"),
    @NamedQuery(name="Student.findByPeriod",
        query="SELECT s FROM Student s WHERE s.periods = :periods"),
    @NamedQuery(name="Student.findByPeriodInRange",
        query="SELECT s FROM Student s WHERE s.periods > :min AND s.periods < :max"),
    @NamedQuery(name="Student.findBusy",
        query="SELECT s FROM Student s WHERE s.periods > :hours"),
    @NamedQuery(name="Student.findFree",
        query="SELECT s FROM Student s WHERE s.periods < :hours"),
    @NamedQuery(name="Student.findByMajor",
        query="SELECT s FROM Student s WHERE s.major = :major")
})
@Entity
public class Student extends Person{
    
    @Enumerated(EnumType.STRING)
    private Specialization major;
    
    //We don't want a Course to be removed when a Student is deleted (CascadeType.REMOVE)
    @ManyToMany(cascade ={CascadeType.REMOVE})
    private List<Course>courses;

    public Student() {
    }

    public Student(String name) {
        super(name);
        
        Specialization majorArray[] = Specialization.values();
        int random = (int)(Math.random()*(majorArray.length));
        this.major = majorArray[random];
        
        this.courses = new ArrayList<Course>();
    }
    
    public Specialization getMajor() {
        return major;
    }

    public void setMajor(Specialization major) {
        this.major = major;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        for(Course course: courses)
            addCourse(course);
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
        setPeriods(getPeriods() + course.getPeriods());
    }

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Student[ id=" + getId() + " ]";
    }
    
    public void setDescriptor(StudentDTO studentDTO){
        this.setId(studentDTO.getId());
        this.setLastName(studentDTO.getName());
        this.major = studentDTO.getMajor();
        setPeriods(studentDTO.getPeriod());
        
        if(studentDTO.getCoursesDTO() != null)
            for(CourseDTO courseDTO: studentDTO.getCoursesDTO()){
                Course course = new Course();
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setSemester(courseDTO.getSemester());
                courses.add(course);
            }
    }     
}
