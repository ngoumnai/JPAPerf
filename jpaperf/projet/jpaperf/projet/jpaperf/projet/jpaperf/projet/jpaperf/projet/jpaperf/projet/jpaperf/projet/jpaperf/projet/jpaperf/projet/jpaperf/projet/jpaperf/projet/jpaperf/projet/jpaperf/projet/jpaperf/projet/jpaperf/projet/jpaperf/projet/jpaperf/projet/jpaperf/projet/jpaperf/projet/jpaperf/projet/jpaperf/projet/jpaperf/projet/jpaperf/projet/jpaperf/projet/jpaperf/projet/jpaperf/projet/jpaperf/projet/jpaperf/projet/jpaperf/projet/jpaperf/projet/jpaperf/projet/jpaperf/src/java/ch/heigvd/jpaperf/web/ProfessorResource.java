/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.web;

import ch.heigvd.jpaperf.dto.ProfessorDTO;
import ch.heigvd.jpaperf.model.Professor;
import ch.heigvd.jpaperf.service.ProfessorManagerLocal;
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
@Path("professor")
@Stateless
public class ProfessorResource {

    @EJB
    ProfessorManagerLocal professorManager;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProfessorResource
     */
    public ProfessorResource() {}
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postProfessor(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setDescriptor(dto);
        professorManager.create(professor);
    }

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.ProfessorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("id/{id}")
    @Produces({"application/xml", "application/json"})
    public ProfessorDTO getProfessorByID(@PathParam("id") Long id) {
        ProfessorDTO dto = new ProfessorDTO();
        Professor professor = professorManager.find(id);
        if(professor == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(professor);
        return dto;
    }
    
    @GET
    @Path("name/{name}")
    @Produces({"application/xml", "application/json"})
    public ProfessorDTO getProfessorByName(@PathParam("name") String name) {
        ProfessorDTO dto = new ProfessorDTO();
        Professor professor = professorManager.findProfessorByName(name);
        if(professor == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(professor);
        return dto;
    }
    
    @GET
    @Path("period/{period}")
    @Produces({"application/json"})
    public List<ProfessorDTO> getProfessorsByPeriod(@PathParam("period") int period) {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findProfessorByPeriod(period);
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }
    
    @GET
    @Path("periodInRange/{min}/{max}")
    @Produces({"application/json"})
    public List<ProfessorDTO> getProfessorsByPeriodInRange(@PathParam("min") int min, @PathParam("max") int max) {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findProfessorByPeriodInRange(min, max);
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }
    
    @GET
    @Path("specialization/{specialization}")
    @Produces({"application/json"})
    public List<ProfessorDTO> getProfessorsBySpecialization(@PathParam("specialization") String specialization) {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findProfessorBySpecialization(specialization);
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }
    
    @GET
    @Path("busy")
    @Produces({"application/json"})
    public List<ProfessorDTO> getBusyProfessor() {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findBusyProfessor();
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }
    
    @GET
    @Path("free")
    @Produces({"application/json"})
    public List<ProfessorDTO> getFreeProfessor() {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findFreeProfessor();
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }
    
    @GET
    @Path("list")
    @Produces({"application/json"})
    public List<ProfessorDTO> getListProfessor() {
        List<ProfessorDTO> professorsDTO = new ArrayList<ProfessorDTO>();
        List<Professor> professors = professorManager.findAll();
        if(professors == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Professor professor: professors){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setDescriptor(professor);
            professorsDTO.add(professorDTO);
        }
        return professorsDTO;
    }

    /**
     * PUT method for updating or creating an instance of ProfessorResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putProfessor(String content) {
    }
    
    @DELETE
    @Path("{id}")
    public void deleteProfessor(@PathParam("id") Long id){
        Professor professor = professorManager.find(id);        
        if(professor == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        professorManager.remove(professor);
    }
}
