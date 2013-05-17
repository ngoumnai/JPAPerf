/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.model.Specialization;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gauss
 */
@XmlRootElement
public class ProfessorDTO extends PersonDTO {
    
    private Specialization specialization;
    private List<CourseDTO>coursesDTO;
    private int period;
    
    public ProfessorDTO(){
        coursesDTO = new ArrayList<CourseDTO>();
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<CourseDTO> getCoursesDTO() {
        return coursesDTO;
    }

    public void setCoursesDTO(List<CourseDTO> coursesDTO) {
        this.coursesDTO = coursesDTO;
    }
    
    public void setDescriptor(Professor professor){
        this.setId(professor.getId());
        this.setName(professor.getLastName());
        this.specialization = professor.getSpecialization();
        this.period = professor.getPeriods();
        
        if(professor.getCourses() != null)
            for(Course course: professor.getCourses()){
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setId(course.getId());
                courseDTO.setName(course.getName());
                courseDTO.setSemester(course.getSemester());
                coursesDTO.add(courseDTO);
            }
    }    
}
