/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Promotions;

/**
 *
 * @author simon
 */
@Local
public interface PromotionManagerBeanLocal {
    public List<Promotions> getPromotions();
    public List<Promotions> getPromotionsActive(boolean active);
    public Promotions setActive(int id, boolean active);
}
