/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.DTO.EventDTO;
import ch.heigvd.JPAPerf.DTO.PersonDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *An Event reports everything that a persons 
 * has done at a given date
 * 
 * @author gauss
 */
@NamedQueries({
    @NamedQuery(name="Event.findBydate",
        query="SELECT e FROM Event e WHERE e.date = :date"),
    @NamedQuery(name="Event.findByType",
        query="SELECT e FROM Event e WHERE e.eventType = :eventType")
})
@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;      
    @Temporal(TemporalType.DATE)
    @Column(name="eventDate")
    private Date date;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    
    /*
     * We want to attach every Event to at least one persons (CascadeType.PERSIST)
     * We don't want a Person to be removed when an Event is deleted (CascadeType.REMOVE)
     */
    @ManyToMany(mappedBy = "event",cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    //@Column(name="concerne")
    private List<Person> persons;
    
    public Event(){
        persons = new ArrayList<Person>();
        int day = (int)(Math.random()*28 ) + 1;
        int month = (int)(Math.random()*11) + 1;
        int year = (int)(Math.random()*3) + 113;
        date = new Date(year, month, day);
        
        EventType eventArray[] = EventType.values();
        int random = (int)(Math.random()*(eventArray.length));
        eventType = eventArray[random];
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return eventType.name() + "Date " + date.toString();
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    } 
    
    public void addPerson(Person person) {
        this.persons.add(person);
    }
    
    public void setDescriptor(EventDTO eventDTO){
        this.id = eventDTO.getId();
        this.date = eventDTO.getDate();
        this.eventType = eventDTO.getEventType();
        
        for(PersonDTO personDTO: eventDTO.getPersonsDTO()){
            Person person = new Person();
            person.setDescriptor(personDTO);
            persons.add(person);
        }                 
    }
}
