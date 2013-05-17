/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.model.Student;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gauss
 */
@XmlRootElement
public class StudentDTO extends PersonDTO{
    private String major;
    private List<CourseDTO>coursesDTO;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<CourseDTO> getCoursesDTO() {
        return coursesDTO;
    }

    public void setCoursesDTO(List<CourseDTO> coursesDTO) {
        this.coursesDTO = coursesDTO;
    }
    
    public void setDescriptor(Student student){
        this.setId(student.getId());
        this.setName(student.getName());
        this.setAddress(student.getAddress());
        this.setTitle(student.getTitle());
        this.major = student.getMajor();
        
        CourseDTO courseDTO = new CourseDTO();
        if(student.getCourses() != null)
            for(Course course: student.getCourses()){
                courseDTO.setId(course.getId());
                courseDTO.setName(course.getName());
                courseDTO.setSemester(course.getSemester());
                coursesDTO.add(courseDTO);
            }
    }      
}
