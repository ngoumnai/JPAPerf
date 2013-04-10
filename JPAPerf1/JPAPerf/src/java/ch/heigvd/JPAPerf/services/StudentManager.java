/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gauss
 */
@Stateless
public class StudentManager extends AbstractManager<Student> implements StudentManagerLocal {
    @PersistenceContext(unitName = "JPAPerfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentManager() {
        super(Student.class);
        em = super.getEntityManager();
    }
    
}
