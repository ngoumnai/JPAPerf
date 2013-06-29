/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.dto;

import ch.heigvd.jpaperf.model.Course;
import ch.heigvd.jpaperf.model.Specialization;
import ch.heigvd.jpaperf.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gauss
 */
@XmlRootElement
public class StudentDTO extends PersonDTO{
    
    private Specialization major;
    private List<CourseDTO>coursesDTO;
    private int period;
    
    public StudentDTO(){
        coursesDTO = new ArrayList<CourseDTO>();
    }

    public Specialization getMajor() {
        return major;
    }

    public void setMajor(Specialization major) {
        this.major = major;
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
    
    public void setDescriptor(Student student){
        this.setId(student.getId());
        this.setName(student.getLastName());
        this.major = student.getMajor();
        this.period = student.getPeriods();
        
        if(student.getCourses() != null){
            for(Course course: student.getCourses()){
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setId(course.getId());
                courseDTO.setName(course.getName());
                courseDTO.setSemester(course.getSemester());
                coursesDTO.add(courseDTO);
            }
        }
    }      
}
