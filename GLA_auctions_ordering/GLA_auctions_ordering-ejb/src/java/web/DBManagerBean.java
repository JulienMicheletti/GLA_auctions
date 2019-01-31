package web;


import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import persistence.Livraison;



/**
 *
 * @author user
 */
@Stateless(name="DBManager")
public class DBManagerBean
{

	
	@PersistenceContext(unitName = "GLA_auctions_ordering_PU")
    private EntityManager em;
	
	private String livraisonsHTML;
	
	
	
	public DBManagerBean ()
	{}
	
	
	
	public String getLivraisonsHTML()
	{
		this.livraisonsHTML = _getLivraisonsHTML();
		return livraisonsHTML;
	}

	public void setLivraisonsHTML(String livraisonsHTML) {
		this.livraisonsHTML = livraisonsHTML;
	}
	
	
	
	
	
	
	private List<Livraison> _getLivraisons ()
	{
		TypedQuery<Livraison> query = em.createNamedQuery("Livaisons.findAll", Livraison.class);
		return query.getResultList();
	}
	
	private String _getLivraisonsHTML ()
	{
		String s = "";
		for (Livraison l : _getLivraisons()) {
			s += ("<tr><td><input type=\"radio\" name=\"" + l.getId() + "\" /></td><td>" + l + "</td></tr>");
		}
		return s;
	}
	

}
