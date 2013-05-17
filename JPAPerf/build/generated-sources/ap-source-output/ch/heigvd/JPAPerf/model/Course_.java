package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.model.Professor;
import ch.heigvd.JPAPerf.model.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-12T18:01:13")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Long> id;
    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Professor> professor;
    public static volatile SingularAttribute<Course, Integer> semester;

}