package web;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-13T20:50:55")
@StaticMetamodel(Payments.class)
public class Payments_ { 

    public static volatile SingularAttribute<Payments, Date> date;
    public static volatile SingularAttribute<Payments, Users> studentID;
    public static volatile SingularAttribute<Payments, Integer> payment;
    public static volatile SingularAttribute<Payments, Integer> payID;

}