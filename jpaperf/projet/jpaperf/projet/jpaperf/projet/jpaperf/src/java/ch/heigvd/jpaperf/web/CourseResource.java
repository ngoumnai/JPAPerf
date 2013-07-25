/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.web;

import ch.heigvd.jpaperf.dto.CourseDTO;
import ch.heigvd.jpaperf.model.Course;
import ch.heigvd.jpaperf.service.CourseManagerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
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

     /**
     * Creates a new instance of CourseResource
     */
    public CourseResource() {
        
    }

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.CourseResource
     * @return an instance of CourseDTO
     */
    @GET
    @Path("id/{id}")
    @Produces({"application/json"})
    public CourseDTO getCourseByID(@PathParam("id") Long id) {
        CourseDTO dto = new CourseDTO();
        Course course = courseManager.find(id);
        if(course == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(course);
        return dto;
    }
    
    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.CourseResource
     * @return an instance of CourseDTO
     */
    @GET
    @Path("name/{name}")
    @Produces({"application/json"})
    public CourseDTO getCourseByName(@PathParam("name") String name) {
        CourseDTO dto = new CourseDTO();
        Course course = courseManager.findCourseByName(name);
        if(course == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(course);
        return dto;
    }
    
    @GET
    @Path("semester/{semester}")
    @Produces({"application/json"})
    public List<CourseDTO> getCoursesBySemester(@PathParam("semester") int semester) {
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
        List<Course> courses = courseManager.findCourseBySemester(semester);
        if(courses == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Course course: courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setDescriptor(course);
            coursesDTO.add(courseDTO);
        }
        return coursesDTO;
    }
    
    @GET
    @Path("period/{period}")
    @Produces({"application/json"})
    public List<CourseDTO> getCoursesByPeriod(@PathParam("period") int period) {
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
        List<Course> courses = courseManager.findCourseByPeriod(period);
        if(courses == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Course course: courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setDescriptor(course);
            coursesDTO.add(courseDTO);
        }
        return coursesDTO;
    }
    
    @GET
    @Path("periodInRange/{min}/{max}")
    @Produces({"application/json"})
    public List<CourseDTO> getCoursesByPeriodInRange(@PathParam("min") int min, @PathParam("max") int max) {
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
        List<Course> courses = courseManager.findCourseByPeriodInRange(min, max);
        if(courses == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Course course: courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setDescriptor(course);
            coursesDTO.add(courseDTO);
        }
        return coursesDTO;
    }
   
    @GET
    @Path("list")
    @Produces({"application/json"})
    public List<CourseDTO> getListCourse() {
        List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
        List<Course> courses = courseManager.findAll();
        if(courses == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Course course: courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setDescriptor(course);
            coursesDTO.add(courseDTO);
        }
        return coursesDTO;
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
    public void putJson(String content) {}
    
    @DELETE
    @Path("{id}")
    public void deleteCourse(@PathParam("id") Long id){
        Course course = courseManager.find(id);        
        if(course == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        courseManager.remove(course);
    }
}
