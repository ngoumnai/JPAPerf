/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.web;

import ch.heigvd.jpaperf.dto.StudentDTO;
import ch.heigvd.jpaperf.model.Student;
import ch.heigvd.jpaperf.service.StudentManagerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author gauss
 */
@Path("student")
@Stateless
public class StudentResource {

    @EJB
    StudentManagerLocal studentManager;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void postStudent(StudentDTO dto) {
        Student student = new Student();
        student.setDescriptor(dto);
        studentManager.create(student);
    }
    
    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.StudentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("id/{id}")
    @Produces({"application/xml", "application/json"})
    public StudentDTO getStudent(@PathParam("id") Long id) {
        StudentDTO dto = new StudentDTO();
        Student student = studentManager.find(id);
        if(student == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(student);
        return dto;
    }
    
    @GET
    @Path("name/{name}")
    @Produces({"application/xml", "application/json"})
    public StudentDTO getStudentByName(@PathParam("name") String name) {
        StudentDTO dto = new StudentDTO();
        Student student = studentManager.findStudentByName(name);
        if(student == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(student);
        return dto;
    }
    
    @GET
    @Path("major/{major}")
    @Produces({"application/json"})
    public List<StudentDTO> getStudentByMajor(@PathParam("major") String major) {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findStudentByMajor(major);
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
    
    @GET
    @Path("period/{period}")
    @Produces({"application/json"})
    public List<StudentDTO> getStudentByPeriod(@PathParam("period") int period) {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findStudentByPeriod(period);
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
    
    @GET
    @Path("periodInRange/{min}/{max}")
    @Produces({"application/json"})
    public List<StudentDTO> getStudentByPeriodInRange(@PathParam("min") int min, @PathParam("max") int max) {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findStudentByPeriodInRange(min, max);
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
   
    @GET
    @Path("busy")
    @Produces({"application/json"})
    public List<StudentDTO> getBusyStudent() {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findBusyStudent();
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
    
    @GET
    @Path("free")
    @Produces({"application/json"})
    public List<StudentDTO> getFreeStudent() {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findFreeStudent();
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
    
    @GET
    @Path("list")
    @Produces({"application/json"})
    public List<StudentDTO> getListStudent() {
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        List<Student> students = studentManager.findAll();
        if(students == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Student student: students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setDescriptor(student);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }

    /**
     * PUT method for updating or creating an instance of StudentResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putStudent(String content) {
        
    }
    
    @DELETE
    @Path("{id}")
    public void deleteStudent(@PathParam("id") Long id) {
        Student student = studentManager.find(id);
        if(student == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        studentManager.remove(student);      
    }
}
