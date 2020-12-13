package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Attendance;
import web.Skill;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-13T23:31:56")
@StaticMetamodel(Class.class)
public class Class_ { 

    public static volatile SingularAttribute<Class, Skill> skillID;
    public static volatile SingularAttribute<Class, Users> teacherID;
    public static volatile CollectionAttribute<Class, Attendance> attendanceCollection;
    public static volatile SingularAttribute<Class, String> name;
    public static volatile SingularAttribute<Class, Integer> maxAttend;
    public static volatile SingularAttribute<Class, Integer> id;
    public static volatile SingularAttribute<Class, String> classDesc;

}