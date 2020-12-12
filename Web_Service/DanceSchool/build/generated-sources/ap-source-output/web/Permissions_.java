package web;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import web.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T23:11:17")
@StaticMetamodel(Permissions.class)
public class Permissions_ { 

    public static volatile SingularAttribute<Permissions, String> permDesc;
    public static volatile SingularAttribute<Permissions, Integer> permID;
    public static volatile CollectionAttribute<Permissions, Users> usersCollection;

}