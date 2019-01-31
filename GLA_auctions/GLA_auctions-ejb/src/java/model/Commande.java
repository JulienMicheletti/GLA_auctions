package model;


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



    public List<Articles> articles = new ArrayList<>();

    public String addressFacturation;
    public String addressLivraison;

    public int modePaiement;
    public String CB;






    public List<Articles> getArticles () {
        return this.articles;
    }


}