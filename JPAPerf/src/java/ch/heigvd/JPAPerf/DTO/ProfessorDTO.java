/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Professor;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gauss
 */
@XmlRootElement
public class ProfessorDTO extends PersonDTO {
    private String specialization;
    private List<CourseDTO>coursesDTO;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<CourseDTO> getCoursesDTO() {
        return coursesDTO;
    }

    public void setCoursesDTO(List<CourseDTO> coursesDTO) {
        this.coursesDTO = coursesDTO;
    }
    
    public void setDescriptor(Professor professor){
        this.setId(professor.getId());
        this.setName(professor.getName());
        this.setAddress(professor.getAddress());
        this.setTitle(professor.getTitle());
        this.specialization = professor.getSpecialization();
        
        CourseDTO courseDTO = new CourseDTO();
        if(professor.getCourses() != null)
            for(Course course: professor.getCourses()){
                courseDTO.setId(course.getId());
                courseDTO.setName(course.getName());
                courseDTO.setSemester(course.getSemester());
                coursesDTO.add(courseDTO);
            }
    }    
}
