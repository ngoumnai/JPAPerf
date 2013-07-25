/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.dto;

import ch.heigvd.jpaperf.model.Person;

/**
 *
 * @author gauss
 */
public class PersonDTO {
    private Long id;
    private int periods =0;
    private String lastName;

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

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }
    
    public void setDescriptor(Person person){}
}
