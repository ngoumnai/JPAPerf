/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.JPAPerf.services;

import ch.heigvd.JPAPerf.model.Professor;
import java.util.List;
import javax.ejb.Local;

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
    
}
