package web;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-13T00:42:02")
@StaticMetamodel(Wages.class)
public class Wages_ { 

    public static volatile SingularAttribute<Wages, Date> date;
    public static volatile SingularAttribute<Wages, Users> teacherID;
    public static volatile SingularAttribute<Wages, Integer> id;
    public static volatile SingularAttribute<Wages, Integer> wage;

}