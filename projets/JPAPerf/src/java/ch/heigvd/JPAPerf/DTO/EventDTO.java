/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.DTO;

import ch.heigvd.JPAPerf.model.Event;
import ch.heigvd.JPAPerf.model.EventType;
import ch.heigvd.JPAPerf.model.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gauss
 */
@XmlRootElement
public class EventDTO {
    private Long id;
    private List<PersonDTO> personsDTO;
    private Date date;
    private EventType eventType;
    
    public EventDTO(){
        date = new Date();
        personsDTO = new ArrayList<PersonDTO>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public List<PersonDTO> getPersonsDTO() {
        return personsDTO;
    }

    public void setPersonsDTO(List<PersonDTO> personsDTO) {
        this.personsDTO = personsDTO;
    }
    
    public void setDescriptor(Event event){
        this.id = event.getId();
        this.date = event.getDate();
        this.eventType = event.getEventType();
        
        for(Person person: event.getPersons()){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setDescriptor(person);
            personsDTO.add(personDTO);
        }           
        
    }   
    
}
