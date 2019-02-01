/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import model.Articles;
import model.Users;

/**
 *
 * @author simon
 */
@Stateless(name = "PersonManager")
public class ArticleManagerBean implements ArticleManagerBeanLocal {

    @PersistenceContext(unitName = "GLAPU")
    private EntityManager em;

    
    public Boolean addArticle(String label, double startingprice, String description, Date deadline, int idUser) {
        Articles article = new Articles(label, startingprice, description, deadline, idUser);
        em.persist(article);
        return true;
    }
    
    public void deleteArticle(int id){
        Articles article = em.find(Articles.class, id);
        em.remove(article);
    }
    
    public Articles unactifArticle(int id){
        Articles article = em.find(Articles.class, id);
        article.setActif(Boolean.FALSE);
        em.persist(article);
        return article;
    }
    
    public Articles setIdEnchereMax(int id, int idEnchere){
        Articles article = em.find(Articles.class, id);
        article.setIdencheremax(idEnchere);
        return article;
    }
    
    public Articles setPaid(int id){
        Articles article = em.find(Articles.class, id);
        article.setPaid(Boolean.TRUE);
        em.persist(article);
        return article;
    }
    
    public List<Articles> allArticlesExceptUser(Users u){
        Query q  = em.createNamedQuery("Articles.findByActifExceptUser");
        q.setParameter("iduser", u.getId());
        return (List<Articles>)q.getResultList();
    }
    
    public List<Articles> allByUserArticles(Users u){
        Query q = em.createNamedQuery("Articles.findByIduser");
        q.setParameter("iduser", u.getId());
        return (List<Articles>)q.getResultList();
    }
    
}
