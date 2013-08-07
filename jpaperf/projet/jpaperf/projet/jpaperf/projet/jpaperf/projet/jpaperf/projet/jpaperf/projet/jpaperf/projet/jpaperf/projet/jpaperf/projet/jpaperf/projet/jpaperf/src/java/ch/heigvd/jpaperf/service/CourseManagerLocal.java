/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.jpaperf.service;

import ch.heigvd.jpaperf.model.Course;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author gauss
 */
@Local
public interface CourseManagerLocal {

    void create(Course course);

    void edit(Course course);

    void remove(Course course);

    Course find(Object id);

    List<Course> findAll();

    List<Course> findRange(int[] range);

    int count();

    public EntityManager getEntityManager();

    public Course findCourseByName(String name);

    public List findCourseBySemester(int semester);

    public List findCourseByPeriod(int period);

    public List findCourseByPeriodInRange(int min, int max);

    public Long countCourse();
    
}
