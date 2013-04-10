/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gauss
 */
public class ProfessorDTO extends PersonDTO {
    private String specialization;
    private List<CourseDTO>courses;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
    
    public HashMap getDescriptor(){
        HashMap descriptor = new HashMap();
        descriptor.put("id",this.getId());
        descriptor.put("name",this.getName());
        descriptor.put("title",this.getTitle());
        descriptor.put("address",this.getAddress());
        descriptor.put("specialization",specialization);
        if(courses != null){
            List<Long> coursesID= new LinkedList();
            for(CourseDTO c: courses)
                coursesID.add(c.getId());
            descriptor.put("coursesID",coursesID);
        }
        return descriptor;
    }
    
    public void setDescriptor(HashMap descriptor){
        this.setId((Long)descriptor.get("id"));
        this.setName((String)descriptor.get("name"));
        this.setTitle((String)descriptor.get("title"));
        this.setAddress((String)descriptor.get("address"));
        specialization = (String)descriptor.get("specialization");
        if(courses != null){
            List<Long> coursesID = (LinkedList) descriptor.get("coursesID");
            CourseDTO c;
            for (Iterator<Long> it = coursesID.iterator(); it.hasNext();) {
                Long id = it.next();
                c = new CourseDTO();
                c.setId(id);
                courses.add(c);
            }  
        }
    }
}
