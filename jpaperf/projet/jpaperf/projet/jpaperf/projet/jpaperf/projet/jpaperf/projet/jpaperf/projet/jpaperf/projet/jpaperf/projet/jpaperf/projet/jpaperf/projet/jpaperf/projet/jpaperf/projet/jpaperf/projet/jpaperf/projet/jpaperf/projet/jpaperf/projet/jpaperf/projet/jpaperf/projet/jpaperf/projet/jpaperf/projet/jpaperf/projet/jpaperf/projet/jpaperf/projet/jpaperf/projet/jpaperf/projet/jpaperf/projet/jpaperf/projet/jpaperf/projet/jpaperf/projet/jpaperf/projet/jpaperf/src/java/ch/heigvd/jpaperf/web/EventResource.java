/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.web;

import ch.heigvd.jpaperf.dto.EventDTO;
import ch.heigvd.jpaperf.model.Event;
import ch.heigvd.jpaperf.service.EventManagerLocal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
@Path("event")
public class EventResource {

    @EJB
    EventManagerLocal eventManager;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EventResource
     */
    public EventResource() {}

    /**
     * Retrieves representation of an instance of ch.heigvd.JPAPerf.web.EventResource
     * @return an instance of EventDTO
     */
    @GET
    @Path("id/{id}")
    @Produces({"application/json"})
    public EventDTO getEventByID(@PathParam("id") Long id) {
        EventDTO dto = new EventDTO();
        Event event = eventManager.find(id);
        if(event == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dto.setDescriptor(event);
        return dto;
    }
    
    @GET
    @Path("date/{date}")
    @Produces({"application/json"})
    public List<EventDTO> getEventByDate(@PathParam("date") String date) throws ParseException {
        List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
        List<Event> events = eventManager.findEventByDate(date);
        if(events == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Event event: events){
            EventDTO eventDTO = new EventDTO();
            eventDTO.setDescriptor(event);
            eventsDTO.add(eventDTO);
        }
        return eventsDTO;
    }
    
    @GET
    @Path("eventType/{eventType}")
    @Produces({"application/json"})
    public List<EventDTO> getEventByType(@PathParam("eventType") String eventType) throws ParseException {
        List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
        List<Event> events = eventManager.findEventByType(eventType);
        if(events == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Event event: events){
            EventDTO eventDTO = new EventDTO();
            eventDTO.setDescriptor(event);
            eventsDTO.add(eventDTO);
        }
        return eventsDTO;
    }
    
    @GET
    @Produces({"application/json"})
    public List<EventDTO> getListEvent() {
        List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
        List<Event> events = eventManager.findAll();
        if(events == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for(Event event: events){
            EventDTO eventDTO = new EventDTO();
            eventDTO.setDescriptor(event);
            eventsDTO.add(eventDTO);
        }
        return eventsDTO;
    }

    /**
     * PUT method for updating or creating an instance of EventResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {}
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postJson(EventDTO dto) {
        Event event = new Event();
        event.setDescriptor(dto);
        eventManager.create(event);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteJson(@PathParam("id") Long id){
        Event event = eventManager.find(id);        
        if(event == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        eventManager.remove(event);
    }
}
