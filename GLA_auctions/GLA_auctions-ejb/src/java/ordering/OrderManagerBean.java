package ordering;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import model.Commande;



/**
 *
 * @author naota
 */
@Stateless
@LocalBean
public class OrderManagerBean
{

    
    @Inject
    JMSContext context;
   
    @Resource(lookup = "jms/CommandeQueue")
    Destination orderQueue;
    
    
    
    public void sendOrder (Commande c)
    {
        context.createProducer().send(orderQueue, c);
    }
    

}
