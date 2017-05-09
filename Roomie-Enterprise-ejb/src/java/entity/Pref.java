/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "pref")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pref.findAll", query = "SELECT p FROM Pref p")
    , @NamedQuery(name = "Pref.findByUserid", query = "SELECT p FROM Pref p WHERE p.userid = :userid")
    , @NamedQuery(name = "Pref.findByStudies", query = "SELECT p FROM Pref p WHERE p.studies = :studies")
    , @NamedQuery(name = "Pref.findByCoding", query = "SELECT p FROM Pref p WHERE p.coding = :coding")
    , @NamedQuery(name = "Pref.findBySports", query = "SELECT p FROM Pref p WHERE p.sports = :sports")
    , @NamedQuery(name = "Pref.findByDrama", query = "SELECT p FROM Pref p WHERE p.drama = :drama")
    , @NamedQuery(name = "Pref.findByMusic", query = "SELECT p FROM Pref p WHERE p.music = :music")
    , @NamedQuery(name = "Pref.findByFood", query = "SELECT p FROM Pref p WHERE p.food = :food")
    , @NamedQuery(name = "Pref.findByTravel", query = "SELECT p FROM Pref p WHERE p.travel = :travel")})
public class Pref implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userid")
    private String userid;
    @Column(name = "studies")
    private Integer studies;
    @Column(name = "coding")
    private Integer coding;
    @Column(name = "sports")
    private Integer sports;
    @Column(name = "drama")
    private Integer drama;
    @Column(name = "music")
    private Integer music;
    @Column(name = "food")
    private Integer food;
    @Column(name = "travel")
    private Integer travel;
    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hosteller hosteller;

    public Pref() {
    }

    public Pref(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getStudies() {
        return studies;
    }

    public void setStudies(Integer studies) {
        this.studies = studies;
    }

    public Integer getCoding() {
        return coding;
    }

    public void setCoding(Integer coding) {
        this.coding = coding;
    }

    public Integer getSports() {
        return sports;
    }

    public void setSports(Integer sports) {
        this.sports = sports;
    }

    public Integer getDrama() {
        return drama;
    }

    public void setDrama(Integer drama) {
        this.drama = drama;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getTravel() {
        return travel;
    }

    public void setTravel(Integer travel) {
        this.travel = travel;
    }

    public Hosteller getHosteller() {
        return hosteller;
    }

    public void setHosteller(Hosteller hosteller) {
        this.hosteller = hosteller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pref)) {
            return false;
        }
        Pref other = (Pref) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pref[ userid=" + userid + " ]";
    }
    
}
