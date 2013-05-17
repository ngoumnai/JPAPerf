/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *An Event reports everything that a person 
 * has done at a given date
 * 
 * @author gauss
 */
@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    
    /*
     * We want to attach an Event to one Date_ (CascadeType.PERSIST)
     * We don't want a Date_ to be removed when an Event is deleted (CascadeType.REMOVE)
     */
    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private Date_ dateOfEvent;
    
    /*
     * We want to attach every Event to at least one person (CascadeType.PERSIST)
     * We don't want a Person to be removed when an Event is deleted (CascadeType.REMOVE)
     */
    @ManyToMany(mappedBy = "event",cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private Person person;
    String descriptionOfevent;

    public String getDescriptionOfevent() {
        return descriptionOfevent;
    }

    public void setDescriptionOfevent(String descriptionOfevent) {
        this.descriptionOfevent = descriptionOfevent;
    }

    public Date_ getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date_ dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ch.heigvd.JPAPerf.model.Absence[ id=" + id + " ]";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    } 
    
}
