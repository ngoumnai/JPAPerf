/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.web;

import ch.heigvd.jpaperf.dto.TestDataDTO;
import ch.heigvd.jpaperf.service.TestDataManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author gauss
 */
@Path("populateDataBase")
@Stateless
public class PopulateDataBaseResource {

    @Context
    private UriInfo context;
    
    @EJB
    TestDataManagerLocal testDataManager;

    /**
     * Creates a new instance of PopulateDataBaseResource
     */
    public PopulateDataBaseResource() {}
    
    @POST
    @Path("professor")
    @Consumes({"application/xml", "application/json"})
    public void populateProfessorDateBase (TestDataDTO testDataDTO) {
        testDataManager.populateProfessorDateBase(testDataDTO.getProfessorNamePath());
    }
    
    @POST
    @Path("student")
    @Consumes({"application/xml", "application/json"})
    public void populateStudentDataBase (TestDataDTO testDataDTO) {
        testDataManager.populateStudentDataBase(testDataDTO.getStudentNamePath());
    }
    
    @POST
    @Path("course")
    @Consumes({"application/xml", "application/json"})
    public void populateCourseDataBase (TestDataDTO testDataDTO) {
        testDataManager.populateCourseDataBase(testDataDTO.getCourseNamePath());
    }
    
    @POST
    @Path("courseToStudent")
    @Consumes({"application/xml", "application/json"})
    public void assignCoursesToStudent (TestDataDTO testDataDTO) {
        testDataManager.assignCoursesToStudent(testDataDTO.getNbrMaxCoursPerStudent());
    }
    
    @POST
    @Path("event")
    @Consumes({"application/xml", "application/json"})
    public void populateEventDataBase (TestDataDTO testDataDTO) {
        testDataManager.populateEventDataBase(testDataDTO.getNbrEvent());
    }
    
}
