package ordering;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;



/**
 *
 * @author user
 */
@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/commandeQueue"),
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class OrderMessageBean implements MessageListener
{

	
	public OrderMessageBean ()
	{}
	
	@Resource
	private MessageDrivenContext context;
	
	@EJB
	OrderManagerBean om;
	
	
	
	@Override
	public void onMessage (Message message)
	{
		try
		{
			Commande cmd = message.getBody(Commande.class);
			System.out.println("DEBUG :: message : " + cmd.toString());
			om.treatCommande(cmd);
		}
		catch (JMSException ex) {
			Logger.getLogger(OrderMessageBean.class.getName()).log(Level.SEVERE, null, ex);
			context.setRollbackOnly();
		}
	}
	

}
