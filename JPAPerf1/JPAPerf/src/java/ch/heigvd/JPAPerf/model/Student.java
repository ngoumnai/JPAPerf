/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author gauss
 */
@Entity
public class Student extends Person implements Serializable {
    private String major;
    @ManyToMany
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
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null
                && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Student[ id=" + getId() + " ]";
    }
    
    public HashMap getDescriptor(){
        HashMap descriptor = new HashMap();
        descriptor.put("id",this.getId());
        descriptor.put("name",this.getName());
        descriptor.put("title",this.getTitle());
        descriptor.put("address",this.getAddress());
        descriptor.put("major",major);
        if(courses != null){
            List<Long> coursesID= new LinkedList();
            for(Course c: courses)
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
        this.setMajor((String)descriptor.get("major"));         
        if(courses != null){
            List<Long> coursesID = (LinkedList) descriptor.get("coursesID");
            Course c;
            for (Iterator<Long> it = coursesID.iterator(); it.hasNext();) {
                Long id = it.next();
                c = new Course();
                c.setId(id);
                courses.add(c);
            }   
        }
    }
    
}