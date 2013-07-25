/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.model;

import ch.heigvd.jpaperf.dto.PersonDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 *
 * @author gauss
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int periods =0;
    private String lastName;
    
    //we don't want to delete an event when a person is removed
    @ManyToMany(cascade ={CascadeType.REMOVE})
    private List<Event> event;

    public Person() {}

    public Person(String name) {
        this.lastName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
    
    public void addEvent(Event event) {
        this.event.add(event);
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }
    
    public void setDescriptor(PersonDTO personDTO){}
          
}
