package web;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;


import persistence.Livraison;



/**
 *
 * @author user
 */
@Stateless(name="OrderManager")
@LocalBean
public class OrderManagerBean
{

	
	@EJB
	private DBManagerBean dbManager;
	
	
	
	public OrderManagerBean ()
	{}
	
	private long id;
	
	
	
	public long getId () {
		return id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	
	
	
	
	public void validate ()
	{
		Livraison l = dbManager.getLivraison(id);
	}
	
	public void cancel ()
	{
		Livraison l = dbManager.getLivraison(id);
		dbManager.remove(l);
	}
	

}
