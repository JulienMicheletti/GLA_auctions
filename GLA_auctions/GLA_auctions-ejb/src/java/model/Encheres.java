/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "ENCHERES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encheres.findAll", query = "SELECT e FROM Encheres e")
    , @NamedQuery(name = "Encheres.findById", query = "SELECT e FROM Encheres e WHERE e.id = :id")
    , @NamedQuery(name = "Encheres.findByIdarticle", query = "SELECT e FROM Encheres e WHERE e.idarticle = :idarticle")
    , @NamedQuery(name = "Encheres.findByIduser", query = "SELECT e FROM Encheres e WHERE e.iduser = :iduser")
    , @NamedQuery(name = "Encheres.findByProposition", query = "SELECT e FROM Encheres e WHERE e.proposition = :proposition")
    , @NamedQuery(name = "Encheres.findByIdlastenchere", query = "SELECT e FROM Encheres e WHERE e.idlastenchere = :idlastenchere")})
public class Encheres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDARTICLE")
    private int idarticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSER")
    private int iduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPOSITION")
    private double proposition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLASTENCHERE")
    private int idlastenchere;

    public Encheres() {
    }

    public Encheres(Integer id) {
        this.id = id;
    }

    public Encheres(int idarticle, int iduser, double proposition, int idlastenchere) {
        //this.id = id;
        this.idarticle = idarticle;
        this.iduser = iduser;
        this.proposition = proposition;
        this.idlastenchere = idlastenchere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public double getProposition() {
        return proposition;
    }

    public void setProposition(double proposition) {
        this.proposition = proposition;
    }

    public int getIdlastenchere() {
        return idlastenchere;
    }

    public void setIdlastenchere(int idlastenchere) {
        this.idlastenchere = idlastenchere;
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
        if (!(object instanceof Encheres)) {
            return false;
        }
        Encheres other = (Encheres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Encheres[ id=" + id + " ]";
    }
    
}
