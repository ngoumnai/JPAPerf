/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.web;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.services.CourseManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author gauss
 */
@Path("course")
@Stateless
public class CourseResource {
    @EJB
    CourseManagerLocal courseManager;

    @Context
    private UriInfo context;
    private java.lang.Exception Exception;

    /**
     * Creates a new instance of CourseResource
     */
    public CourseResource() {
    }

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.CourseResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public CourseDTO getJson(@PathParam("id") Long id) {
        CourseDTO dto = new CourseDTO();
            Course course = courseManager.find(id);
            if(course == null) { 
                // Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " 
                  //       + id).build();
                Response.status(404);
                 return dto;
            }
                 dto.setDescriptor(course);
        return dto;
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postJson(CourseDTO dto) {
        Course course = new Course();
        course.setDescriptor(dto);
        courseManager.create(course);
        
        
        
    }

    /**
     * PUT method for updating or creating an instance of CourseResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @DELETE
    @Path("{id}")
    public void deleteJson(@PathParam("id") Long id){
        Course course = courseManager.find(id);
        
        if(course != null){
            
        }
    }

}
