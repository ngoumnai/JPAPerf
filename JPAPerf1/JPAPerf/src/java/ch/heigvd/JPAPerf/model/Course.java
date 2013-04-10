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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author gauss
 */
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Professor professor;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;  
    private String name;
    private int semester;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Course[ id=" + id + " ]";
    }
    
    public HashMap getDescriptor(){
        HashMap descriptor = new HashMap();
        descriptor.put("id",id);
        descriptor.put("name",name);
        descriptor.put("semester",semester);
        
        if (professor != null)
            descriptor.put("professorID",professor.getId());
        if(students != null){
            List<Long> studentsID= new LinkedList<Long>();
            for(Student s: students)
                studentsID.add(s.getId());
            descriptor.put("studentsID",studentsID); 
        }
        return descriptor;
    }
    
    public void setDescriptor(HashMap descriptor){
        id = (Long)descriptor.get("id");
        name = (String)descriptor.get("name");
        semester = (Integer)descriptor.get("semester");
        professor.setId((Long)descriptor.get("professorID"));           
        List<Long> studentsID = (LinkedList) descriptor.get("studentsID");
        Student s;
        for (Iterator<Long> it = studentsID.iterator(); it.hasNext();) {
            Long id = it.next();
            s = new Student();
            s.setId(id);
            students.add(s);
        }         
    } 
}
