package persistence;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-30T18:47:43")
@StaticMetamodel(Livraison.class)
public class Livraison_ { 

    public static volatile SingularAttribute<Livraison, Double> price;
    public static volatile SingularAttribute<Livraison, Long> id;
    public static volatile SingularAttribute<Livraison, Date> creationDate;
    public static volatile SingularAttribute<Livraison, String> articles;
    public static volatile SingularAttribute<Livraison, String> addressFacturation;
    public static volatile SingularAttribute<Livraison, String> addressLivraison;

}