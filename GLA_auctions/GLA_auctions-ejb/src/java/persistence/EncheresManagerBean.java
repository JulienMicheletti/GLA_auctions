/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import model.Encheres;
import model.Users;

/**
 *
 * @author grimmoj
 */
@Stateless(name = "EncheresManager")
public class EncheresManagerBean implements EncheresManagerBeanLocal{

    @PersistenceContext(unitName = "GLA_auctions-ejbPU")
    private EntityManager em;

    @Resource(lookup = "jdbc/GLA")
    private DataSource dataSource;
    private Connection connection;
    
    @PostConstruct
    public void initialize() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @PreDestroy
    public void cleanup() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @Override
    public Boolean addEncheres(int idarticle, int iduser, double proposition, int idlastenchere) {
        Encheres e = new Encheres(idarticle, iduser, proposition, idlastenchere);
        em.persist(e);
        return true;
    }

    @Override
    public Encheres firstEncheres() {
        Encheres e = em.find(Encheres.class, 1L);
        return e;
    }

    @Override
    public Encheres getEncheres(int id) {
        Encheres e = em.find(Encheres.class, id);
        return e;
    }

    @Override
    public List<Encheres> getEncheresUser(int idUser) {
        Query query = em.createNamedQuery("Encheres.findByIduser");
        query.setParameter("iduser", idUser);
        return query.getResultList();
    }

    @Override
    public Encheres getEncheresArticle(int idArticle) {
        Query query = em.createNamedQuery("Encheres.findByIdarticle");
        query.setParameter("idarticle", idArticle);
        return (Encheres) query.getSingleResult();
    }

    @Override
    public void deleteEncheres(int id) {
        Encheres e = this.getEncheres(id);
        em.remove(e);
    }

    @Override
    public Encheres find(String champ, String valeur) {
        Encheres res = new Encheres();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u FROM ENCHERES WHERE "+champ+"="+valeur);
            while(rs.next()){
                res.setIdarticle(rs.getInt("idarticle"));
                res.setIduser(rs.getInt("iduser"));
                res.setProposition(rs.getDouble("proposition"));
                res.setIdlastenchere(rs.getInt("idlastenchere"));
                res.setId(rs.getInt("id"));
                
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return res;
    }
    
}
