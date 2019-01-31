/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotion;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.Promotions;
import persistence.ArticleManagerBeanLocal;
import persistence.PromotionManagerBeanLocal;

/**
 *
 * @author simon
 */
@Stateless
@LocalBean
public class PromotionTimerSessionBean {

    @EJB 
    PromotionManagerBeanLocal promotionManager;
        
    @Schedule(month = "*", hour = "0", dayOfMonth = "*", year = "*", minute = "0", second = "0")
    public void setNewPromotions() {
        System.out.println("Chargement des nouvelles promotions : " + new Date());
        
        List<Promotions> promotions = promotionManager.getPromotionsActive(true);
        for(Promotions promotion : promotions){
            promotionManager.setActive(promotion.getId(), false);
        }
        int randomNum = (int)(Math.random() * (promotions.size()-1));
        
        promotionManager.setActive(promotions.get(randomNum).getId(), true);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
