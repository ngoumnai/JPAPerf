/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Professor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless

public class ProfessorManager extends AbstractManager<Professor> implements ProfessorManagerLocal {
    @PersistenceContext
    private EntityManager em;
        
    public ProfessorManager() {
        super(Professor.class);
    }
        
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
    
