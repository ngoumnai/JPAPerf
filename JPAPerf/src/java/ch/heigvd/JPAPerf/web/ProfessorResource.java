/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.web;

import ch.heigvd.JPAPerf.DTO.ProfessorDTO;
import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.services.ProfessorManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
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
@Path("professor")
public class ProfessorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProfessorResource
     */
    public ProfessorResource() {
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postJson(ProfessorDTO dto) {
        ProfessorManager cm = new ProfessorManager();
        Professor professor = new Professor();
        professor.setDescriptor(dto);
        cm.create(professor);
    }

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.ProfessorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public ProfessorDTO getJson(@PathParam("id") Long id) {
        ProfessorManager cm = new ProfessorManager();
        ProfessorDTO dto = new ProfessorDTO();
        Professor professor = cm.find(id);
        if(professor != null)
            dto.setDescriptor(professor);
        return dto;
    }

    /**
     * PUT method for updating or creating an instance of ProfessorResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
