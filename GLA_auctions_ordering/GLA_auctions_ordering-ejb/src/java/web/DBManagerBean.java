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
	
	private List<Livraison> livraisons;
	
	
	
	public DBManagerBean ()
	{}
	
	
	
	public List<Livraison> getLivraisons ()
	{
		this.livraisons = _getLivraisons();
		return livraisons;
	}

	public void setLivraisons (List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
	
	
	
	
	
	private List<Livraison> _getLivraisons ()
	{
		TypedQuery<Livraison> query = em.createNamedQuery("Livaisons.findAll", Livraison.class);
		return query.getResultList();
	}
	
	public Livraison getLivraison (long id)
	{
		TypedQuery<Livraison> query = em.createNamedQuery("Livraisons.findById", Livraison.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	void remove (Livraison l)
	{
		em.remove(l);
	}
	

}
