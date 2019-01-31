package persistence;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import ordering.Article;



/**
 *
 * @author user
 */
@Entity
@Table(name="LIVRAISONS")
@NamedQueries({
	@NamedQuery(name="Livraisons.findAll", query="SELECT l FROM Livraison l")
})
public class Livraison implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="creationdate")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@NotNull
	@Size(min = 1, max = 8192)
	@Column(name="articles")
	private String articles;
	
	@NotNull
	@Column(name="price")
	private double price;
	
	@NotNull
	@Column(name="addrFacturation")
	@Size(min = 1, max = 64)
	String addressFacturation;
	
	@NotNull
	@Column(name="addrLivraison")
	@Size(min = 1, max = 64)
    public String addressLivraison;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}
	
	public Date getCreationDate () {
		return this.creationDate;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddressFacturation() {
		return addressFacturation;
	}

	public void setAddressFacturation(String addressFacturation) {
		this.addressFacturation = addressFacturation;
	}

	public String getAddressLivraison() {
		return addressLivraison;
	}

	public void setAddressLivraison(String addressLivraison) {
		this.addressLivraison = addressLivraison;
	}
	
	
	
	
	
	
	public void addArticle (Article article)
	{
		this.articles += ("" + article.label + "\n" + article.description + "\n" + article.codes + "\n\n");
		this.price += article.price;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Livraison)) {
			return false;
		}
		Livraison other = (Livraison) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String s = "persistence.Livraison[ id=" + id + ", " + this.creationDate.toString() + " ] " + this.addressLivraison;
		
		if (!this.addressFacturation.equalsIgnoreCase(this.addressLivraison))
			s += ("(facturation : " + this.addressFacturation);
		
		s += this.articles;
		
		return s;
	}
	
}
