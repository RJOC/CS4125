package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T01:50:53")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Users> studentID;
    public static volatile SingularAttribute<Report, Users> teacherID;
    public static volatile SingularAttribute<Report, String> description;
    public static volatile SingularAttribute<Report, Integer> id;

}