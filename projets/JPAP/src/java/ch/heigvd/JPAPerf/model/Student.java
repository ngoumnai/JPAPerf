/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.StudentDTO;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author gauss
 */
@Entity
public class Student extends Person{
    private String major;
    
    //We don't want a Course to be removed when a Student is deleted (CascadeType.REMOVE)
    @ManyToMany(cascade ={CascadeType.REMOVE})
    private List<Course>courses;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Student[ id=" + getId() + " ]";
    }
    
    public void setDescriptor(StudentDTO StudentDTO){
        this.setId(StudentDTO.getId());
        this.setName(StudentDTO.getName());
        this.setAddress(StudentDTO.getAddress());
        this.setTitle(StudentDTO.getTitle());
        this.major = StudentDTO.getMajor();
        
        Course course = new Course();
        if(StudentDTO.getCoursesDTO() != null)
            for(CourseDTO courseDTO: StudentDTO.getCoursesDTO()){
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setSemester(courseDTO.getSemester());
                courses.add(course);
            }
    }     
}
