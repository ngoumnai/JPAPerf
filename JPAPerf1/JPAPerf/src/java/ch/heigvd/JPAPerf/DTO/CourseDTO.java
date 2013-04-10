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
public class CourseDTO {
    private long id;
    private String name;
    private int semester;
    private ProfessorDTO professor;
    private List<StudentDTO>students;

    public HashMap getDescriptor(){
        HashMap descriptor = new HashMap();
        descriptor.put("id",id);
        descriptor.put("name",name);
        descriptor.put("semester",semester);
        if(professor != null)
            descriptor.put("professorID",professor.getId());
        if(students != null){
            List<Long> studentsID= new LinkedList();
            for(StudentDTO s: students)
                studentsID.add(s.getId());
            descriptor.put("studentsID",studentsID);
        }
        return descriptor;
    }
    
    public void setDescriptor(HashMap descriptor){
        id = (Long)descriptor.get("id");
        name = (String)descriptor.get("name");
        semester = (Integer)descriptor.get("semester");
        if(professor != null)
            professor.setId((Long)descriptor.get("professorID")); 
        if(students != null){
            List<Long> studentsID = (LinkedList) descriptor.get("studentsID");
            StudentDTO s;
            for (Iterator<Long> it = studentsID.iterator(); it.hasNext();) {
                Long id = it.next();
                s = new StudentDTO();
                s.setId(id);
                students.add(s);
            }
        }         
    }
    
    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public List<StudentDTO> getStudent() {
        return students;
    }

    public void setStudent(List<StudentDTO> student) {
        this.students = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
