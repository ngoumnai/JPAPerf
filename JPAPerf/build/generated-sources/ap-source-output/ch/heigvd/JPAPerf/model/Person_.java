package ch.heigvd.JPAPerf.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-12T18:01:13")
@StaticMetamodel(Person.class)
public abstract class Person_ { 

    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> title;
    public static volatile SingularAttribute<Person, String> address;
    public static volatile SingularAttribute<Person, String> name;

}