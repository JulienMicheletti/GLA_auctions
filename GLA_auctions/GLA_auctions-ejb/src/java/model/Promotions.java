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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "PROMOTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p")
    , @NamedQuery(name = "Promotions.findById", query = "SELECT p FROM Promotions p WHERE p.id = :id")
    , @NamedQuery(name = "Promotions.findByNbminarticles", query = "SELECT p FROM Promotions p WHERE p.nbminarticles = :nbminarticles")
    , @NamedQuery(name = "Promotions.findByCode", query = "SELECT p FROM Promotions p WHERE p.code = :code")
    , @NamedQuery(name = "Promotions.findByActive", query = "SELECT p FROM Promotions p WHERE p.active = :active")})
public class Promotions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBMINARTICLES")
    private int nbminarticles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE")
    private Boolean active;

    public Promotions() {
    }

    public Promotions(Integer id) {
        this.id = id;
    }

    public Promotions(Integer id, int nbminarticles, String code, Boolean active) {
        this.id = id;
        this.nbminarticles = nbminarticles;
        this.code = code;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNbminarticles() {
        return nbminarticles;
    }

    public void setNbminarticles(int nbminarticles) {
        this.nbminarticles = nbminarticles;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promotions[ id=" + id + " ]";
    }
    
}
