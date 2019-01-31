package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T11:11:22")
@StaticMetamodel(Articles.class)
public class Articles_ { 

    public static volatile SingularAttribute<Articles, Integer> iduser;
    public static volatile SingularAttribute<Articles, Boolean> paid;
    public static volatile SingularAttribute<Articles, String> description;
    public static volatile SingularAttribute<Articles, Boolean> actif;
    public static volatile SingularAttribute<Articles, Integer> idencheremax;
    public static volatile SingularAttribute<Articles, Integer> id;
    public static volatile SingularAttribute<Articles, String> label;
    public static volatile SingularAttribute<Articles, String> categories;
    public static volatile SingularAttribute<Articles, Date> deadline;
    public static volatile SingularAttribute<Articles, Double> startingprice;

}