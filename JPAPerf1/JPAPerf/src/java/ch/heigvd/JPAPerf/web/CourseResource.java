/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.web;

import ch.heigvd.JPAPerf.DTO.CourseDTO;
import ch.heigvd.JPAPerf.model.Course;
import ch.heigvd.JPAPerf.services.CourseManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author gauss
 */
@Path("course")
public class CourseResource {

    @Context
    private UriInfo context;

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
        CourseManager cm = new CourseManager();
        CourseDTO dto = new CourseDTO();
        Course course = cm.find(id);
        if(course != null)
            dto.setDescriptor(course.getDescriptor());
        return dto;
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postJson(CourseDTO dto) {
        CourseManager cm = new CourseManager();
        Course course = new Course();
        course.setDescriptor(dto.getDescriptor());
        cm.create(course);
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
}
