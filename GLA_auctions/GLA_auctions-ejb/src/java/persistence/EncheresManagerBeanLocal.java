/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Encheres;

/**
 *
 * @author grimmoj
 */
@Local
public interface EncheresManagerBeanLocal {
        public Boolean addEncheres(int idarticle, int iduser, double proposition, int idlastenchere);
        public Encheres firstEncheres();
        public Encheres getEncheres(int id);
        public List<Encheres> getEncheresUser(int idUser);
        public Encheres getEncheresArticle(int idArticle);
        public void deleteEncheres(int id);
        public Encheres find(String champs, String valeur);
        
}
