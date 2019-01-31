package ordering;


import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;



/**
 *
 * @author naota
 */
public class Commande implements Serializable
{

    
    public Commande ()
    {}
    
    
    
    public List<Article> articles = new ArrayList<>();
    
    public String addressFacturation;
    public String addressLivraison;
    
    public int modePaiement;
    public String CB;
    
    
    
    
    
    
    public List<Article> getArticles () {
        return this.articles;
    }
    

}
