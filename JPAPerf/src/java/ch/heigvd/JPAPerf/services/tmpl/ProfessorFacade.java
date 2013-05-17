/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services.tmpl;

import ch.heigvd.JPAPerf.model.Professor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class ProfessorFacade extends AbstractFacade<Professor> {
    @PersistenceContext(unitName = "JPAPerfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfessorFacade() {
        super(Professor.class);
    }
    
}
