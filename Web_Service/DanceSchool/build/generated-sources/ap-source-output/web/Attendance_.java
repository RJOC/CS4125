package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Class;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-14T09:33:15")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, Users> studentID;
    public static volatile SingularAttribute<Attendance, Class> classID;
    public static volatile SingularAttribute<Attendance, Integer> attendID;

}