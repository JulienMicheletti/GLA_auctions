package web;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import persistence.Livraison;



/**
 *
 * @author user
 */
@Stateless(name="DBManager")
@LocalBean
public class DBManagerBean
{

	
	@PersistenceContext(unitName = "GLA_livraisons-ejbPU")
    private EntityManager em;
	
	
	
	public DBManagerBean ()
	{}
	
	
	
	public List<Livraison> getLivraisons ()
	{
		TypedQuery<Livraison> query = em.createNamedQuery("Livraisons.findAll", Livraison.class);
		return query.getResultList();
	}
	

}
