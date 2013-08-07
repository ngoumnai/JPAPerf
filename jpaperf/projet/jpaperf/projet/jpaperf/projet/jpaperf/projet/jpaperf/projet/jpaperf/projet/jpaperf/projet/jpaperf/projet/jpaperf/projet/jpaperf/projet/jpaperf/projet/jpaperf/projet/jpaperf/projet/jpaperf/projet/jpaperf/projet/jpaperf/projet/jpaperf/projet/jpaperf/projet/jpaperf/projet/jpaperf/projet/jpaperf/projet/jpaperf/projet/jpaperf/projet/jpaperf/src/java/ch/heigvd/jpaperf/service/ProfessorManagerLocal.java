/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Professor;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author gauss
 */
@Local
public interface ProfessorManagerLocal {

    void create(Professor professor);

    void edit(Professor professor);

    void remove(Professor professor);

    Professor find(Object id);

    List<Professor> findAll();

    List<Professor> findRange(int[] range);

    int count();

    public EntityManager getEntityManager();

    public Professor findProfessorByName(String name);

    public List findProfessorByPeriod(int period);

    public List findProfessorByPeriodInRange(int min, int max);

    public List findBusyProfessor();

    public List findFreeProfessor();

    public List findProfessorBySpecialization(String specialization);

    public Long countProfessor();
}
