/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "ARTICLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a")
    , @NamedQuery(name = "Articles.findById", query = "SELECT a FROM Articles a WHERE a.id = :id")
    , @NamedQuery(name = "Articles.findByLabel", query = "SELECT a FROM Articles a WHERE a.label = :label")
    , @NamedQuery(name = "Articles.findByStartingprice", query = "SELECT a FROM Articles a WHERE a.startingprice = :startingprice")
    , @NamedQuery(name = "Articles.findByDescription", query = "SELECT a FROM Articles a WHERE a.description = :description")
    , @NamedQuery(name = "Articles.findByCategories", query = "SELECT a FROM Articles a WHERE a.categories = :categories")
    , @NamedQuery(name = "Articles.findByDeadline", query = "SELECT a FROM Articles a WHERE a.deadline = :deadline")
    , @NamedQuery(name = "Articles.findByActif", query = "SELECT a FROM Articles a WHERE a.actif = :actif")
    , @NamedQuery(name = "Articles.findByIdencheremax", query = "SELECT a FROM Articles a WHERE a.idencheremax = :idencheremax")
    , @NamedQuery(name = "Articles.findByIduser", query = "SELECT a FROM Articles a WHERE a.iduser = :iduser")
    , @NamedQuery(name = "Articles.findByPaid", query = "SELECT a FROM Articles a WHERE a.paid = :paid")})
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LABEL")
    private String label;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTINGPRICE")
    private double startingprice;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 2048)
    @Column(name = "CATEGORIES")
    private String categories;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEADLINE")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIF")
    private Boolean actif;
    @Column(name = "IDENCHEREMAX")
    private Integer idencheremax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSER")
    private int iduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAID")
    private Boolean paid;

    public Articles() {
    }

    public Articles(Integer id) {
        this.id = id;
    }

    public Articles(Integer id, String label, double startingprice, Date deadline, Boolean actif, int iduser, Boolean paid) {
        this.id = id;
        this.label = label;
        this.startingprice = startingprice;
        this.deadline = deadline;
        this.actif = actif;
        this.iduser = iduser;
        this.paid = paid;
    }
    
        public Articles(String label, double startingprice, String description, Date deadline, int idUser) {
        this.label = label;
        this.description = description;
        this.startingprice = startingprice;
        this.deadline = deadline;
        this.iduser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getStartingprice() {
        return startingprice;
    }

    public void setStartingprice(double startingprice) {
        this.startingprice = startingprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Integer getIdencheremax() {
        return idencheremax;
    }

    public void setIdencheremax(Integer idencheremax) {
        this.idencheremax = idencheremax;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
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
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Articles[ id=" + id + " ]";
    }
    
}
