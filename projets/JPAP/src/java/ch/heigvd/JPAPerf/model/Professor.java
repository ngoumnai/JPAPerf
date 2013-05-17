/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.DTO.ProfessorDTO;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author gauss
 */
@Entity
public class Professor extends Person {
   private String specialization;
    @OneToMany(mappedBy = "professor")
    private List<Course>courses;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Professor " + getName() + "\tID "+ getId();
    }
    
    public void setDescriptor(ProfessorDTO professorDTO){
        this.setId(professorDTO.getId());
        this.setName(professorDTO.getName());
        this.setAddress(professorDTO.getAddress());
        this.setTitle(professorDTO.getTitle());
        this.specialization = professorDTO.getSpecialization();
        
        Course course = new Course();
        if(professorDTO.getCoursesDTO() != null)
            for(CourseDTO courseDTO: professorDTO.getCoursesDTO()){
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setSemester(courseDTO.getSemester());
                courses.add(course);
            }
    }    
}
