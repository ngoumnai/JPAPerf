/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.web;

import ch.heigvd.JPAPerf.DTO.TestDataDTO;
import ch.heigvd.JPAPerf.services.TestDataManagerLocal;
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
    public PopulateDataBaseResource() {
    }

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.PopulateDataBaseResource
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public void PopulateDataBase (TestDataDTO testDataDTO) {
        testDataManager.populateProfessorDateBase(testDataDTO.getProfessorNamePath());
        testDataManager.populateStudentDataBase(testDataDTO.getStudentNamePath());
        testDataManager.populateCourseDataBase(testDataDTO.getCourseNamePath());
       
        testDataManager.assignCoursesToStudent(testDataDTO.getNbrMaxCoursPerStudent());
    
        testDataManager.populateEventDataBase(testDataDTO.getNbrEvent(),
                testDataDTO.getNbrMaxProfessor(), testDataDTO.getNbrMaxStudent());
     
    }
}
