package article;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articles;
import model.Users;
import persistence.ArticleManagerBeanLocal;

/**
 *
 * @author simon
 */
@ManagedBean(name = "articleBean")
@RequestScoped
public class ArticleBean {
    
    @EJB 
    ArticleManagerBeanLocal articleManager;
    
    private String label, description;
    private Date deadline;
    private String[] categories;
    private double startingprice, actualPrice;
    private HttpSession session;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Double getStartingprice() {
        return startingprice;
    }

    public void setStartingprice(Double startingprice) {
        this.startingprice = startingprice;
    }
    
      public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }
    
    public void submit(){
        //TODO CHANGE IDUSER
        articleManager.addArticle(label, startingprice, description, deadline, 1);
    }
    /**
     * Creates a new instance of ArticleBean
     */
    public ArticleBean(HttpSession s) {
        this.session = s;
    }
        
    public List<Articles> allUserArtcles(){
        Users u = (Users) session.getAttribute(connection.Connexion.ATT_SESSION_USER);
        return articleManager.allByUserArticles(u);
    }
    
    public List<Articles> allExceptUserArtcles(){
        Users u = (Users) session.getAttribute(connection.Connexion.ATT_SESSION_USER);
        return articleManager.allArticlesExceptUser(u);    
    }
    
    public void retirerArticle(){
    }
    
    public void acheterArticle(){
    }
}
