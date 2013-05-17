package ch.heigvd.JPAPerf.model;

import ch.heigvd.JPAPerf.model.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-12T18:01:13")
@StaticMetamodel(Student.class)
public class Student_ extends Person_ {

    public static volatile ListAttribute<Student, Course> courses;
    public static volatile SingularAttribute<Student, String> major;

}