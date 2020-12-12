package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Attendance;
import web.Class;
import web.Payments;
import web.Permissions;
import web.Report;
import web.Wages;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T01:50:53")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Permissions> permissionID;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile CollectionAttribute<Users, Report> reportCollection1;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile CollectionAttribute<Users, Wages> wagesCollection;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Report> reportCollection;
    public static volatile CollectionAttribute<Users, Attendance> attendanceCollection;
    public static volatile CollectionAttribute<Users, Payments> paymentsCollection;
    public static volatile CollectionAttribute<Users, Class> classCollection;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}