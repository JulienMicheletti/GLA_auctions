/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import model.Promotions;

/**
 *
 * @author simon
 */
@Stateless(name = "PromotionManager")
public class PromotionManagerBean implements PromotionManagerBeanLocal {
    
    @PersistenceContext(unitName = "GLAPU")
    private EntityManager em;

    
    public List<Promotions> getPromotions(){
        return em.createNamedQuery("Promotions.findAll").getResultList();
    }
    
    public List<Promotions> getPromotionsActive(boolean active){
        return em.createNamedQuery("Promotions.findByActive").setParameter("active", active).getResultList();
    }
    
    
    public Promotions setActive(int id, boolean active){
        Promotions promotion = em.find(Promotions.class, id);
        promotion.setActive(active);
        em.persist(promotion);
        return promotion;
    }
   
}
