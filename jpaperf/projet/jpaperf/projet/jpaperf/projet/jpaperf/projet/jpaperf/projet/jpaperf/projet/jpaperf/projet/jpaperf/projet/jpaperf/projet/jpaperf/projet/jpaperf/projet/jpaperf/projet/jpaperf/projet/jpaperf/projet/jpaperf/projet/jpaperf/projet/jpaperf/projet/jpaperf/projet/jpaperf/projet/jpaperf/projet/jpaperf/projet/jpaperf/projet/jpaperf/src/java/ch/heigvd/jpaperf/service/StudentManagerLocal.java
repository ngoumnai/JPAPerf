/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Student;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author gauss
 */
@Local
public interface StudentManagerLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();

    public EntityManager getEntityManager();

    public Student findStudentByName(String name);

    public List findStudentByPeriod(int period);

    public List findStudentByPeriodInRange(int min, int max);

    public List findBusyStudent();

    public List findFreeStudent();

    public List findStudentByMajor(String major);

    public Long countStudent();
}
