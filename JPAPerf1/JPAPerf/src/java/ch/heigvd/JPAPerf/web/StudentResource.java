/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.web;

import ch.heigvd.JPAPerf.DTO.StudentDTO;
import ch.heigvd.JPAPerf.model.Student;
import ch.heigvd.JPAPerf.services.StudentManager;
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

/**
 * REST Web Service
 *
 * @author gauss
 */
@Path("student")
public class StudentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void postJson(StudentDTO dto) {
        StudentManager cm = new StudentManager();
        Student student = new Student();
        student.setDescriptor(dto.getDescriptor());
        cm.create(student);
    }
    
    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.StudentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public StudentDTO getJson(@PathParam("id") Long id) {
        StudentManager cm = new StudentManager();
        StudentDTO dto = new StudentDTO();
        Student student = cm.find(id);
        if(student != null)
            dto.setDescriptor(student.getDescriptor());
        return dto;
    }

    /**
     * PUT method for updating or creating an instance of StudentResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
        StudentManager cm = new StudentManager();
    }
    
    @DELETE
    @Consumes("application/json")
    public void deleteJson(@PathParam("id") Long id){
        StudentManager cm = new StudentManager();
        Student student = cm.find(id);
        if (student != null){
            cm.remove(student);
        }
    }
}
