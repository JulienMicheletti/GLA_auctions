/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Date;
import javax.ejb.Local;
import model.Articles;

/**
 *
 * @author simon
 */
@Local
public interface ArticleManagerBeanLocal {
    public Articles setPaid(int id);
    public Articles setIdEnchereMax(int id, int idEnchere);
    public Articles unactifArticle(int id);
    public void deleteArticle(int id);
    public Boolean addArticle(String label, double startingprice, String description, Date deadline, int idUser);
    
}
