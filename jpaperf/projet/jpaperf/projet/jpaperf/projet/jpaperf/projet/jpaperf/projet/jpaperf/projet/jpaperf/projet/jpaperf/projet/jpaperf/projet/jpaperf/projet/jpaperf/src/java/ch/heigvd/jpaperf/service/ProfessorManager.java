/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Professor;
import ch.heigvd.jpaperf.model.Specialization;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless

public class ProfessorManager extends AbstractManager<Professor> implements ProfessorManagerLocal {
    @PersistenceContext(unitName = "jpaperfPU")
    private EntityManager em;
    private final int PROFESSORMANYHOURS = 20;
    private final int PROFESSORLESSHOURS = 8;
        
    public ProfessorManager() {
        super(Professor.class);
    }
        
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Long countProfessor(){
        String query = "SELECT COUNT(p.id) FROM Professor p";
        return (Long) em.createQuery(query).getSingleResult();
    }
    
    /**
     * Return the first professor found
     * @param name
     * @return 
     */
    @Override
    public Professor findProfessorByName(String name){
        return (Professor)em.createNamedQuery("Professor.findByName")
                .setParameter("name", name)
                .getResultList().get(0);
    }
    
    @Override
    public List findProfessorByPeriod(int period){
        return em.createNamedQuery("Professor.findByPeriod")
                .setParameter("periods", period)
                .getResultList();
    }
    
    @Override
    public List findProfessorByPeriodInRange(int min, int max){
        return em.createNamedQuery("Professor.findByPeriodInRange")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
    
    @Override
    public List findBusyProfessor(){
        return em.createNamedQuery("Professor.findBusy")
                .setParameter("hours", PROFESSORMANYHOURS)
                .getResultList();
    }
    
    @Override
    public List findFreeProfessor(){
        return em.createNamedQuery("Professor.findFree")
                .setParameter("hours", PROFESSORLESSHOURS)
                .getResultList();
    }
    
    @Override
    public List findProfessorBySpecialization(String specialization){
        return em.createNamedQuery("Professor.findBySpecialization")
                .setParameter("specialization", Specialization.valueOf(specialization))
                .getResultList();
    }

}
    
