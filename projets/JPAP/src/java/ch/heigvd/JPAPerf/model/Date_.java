/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author gauss
 */
@Entity
public class Date_ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int day_;
    private int month_;
    private int year_;      
    @OneToMany(mappedBy = "dateOfEvent")
    private List<Event> events;

    public Date_() {
    }
    
    public Date_(int day, int month, int year){
        this.day_ = day;
        this.month_ = month;
        this.year_ = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }      

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }      
           
    @Override
    public String toString(){
        return "" + day_ + "." + month_ +"." + year_;
    }    
    
}
