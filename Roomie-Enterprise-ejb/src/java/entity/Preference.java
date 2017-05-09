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
@Table(name = "preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preference.findAll", query = "SELECT p FROM Preference p")
    , @NamedQuery(name = "Preference.findByUserid", query = "SELECT p FROM Preference p WHERE p.userid = :userid")
    , @NamedQuery(name = "Preference.findByPref1", query = "SELECT p FROM Preference p WHERE p.pref1 = :pref1")
    , @NamedQuery(name = "Preference.findByPref2", query = "SELECT p FROM Preference p WHERE p.pref2 = :pref2")
    , @NamedQuery(name = "Preference.findByPref3", query = "SELECT p FROM Preference p WHERE p.pref3 = :pref3")})
public class Preference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "userid")
    private String userid;
    @Size(max = 40)
    @Column(name = "pref1")
    private String pref1;
    @Size(max = 40)
    @Column(name = "pref2")
    private String pref2;
    @Size(max = 40)
    @Column(name = "pref3")
    private String pref3;
    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hosteller hosteller;

    public Preference() {
    }

    public Preference(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPref1() {
        return pref1;
    }

    public void setPref1(String pref1) {
        this.pref1 = pref1;
    }

    public String getPref2() {
        return pref2;
    }

    public void setPref2(String pref2) {
        this.pref2 = pref2;
    }

    public String getPref3() {
        return pref3;
    }

    public void setPref3(String pref3) {
        this.pref3 = pref3;
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
        if (!(object instanceof Preference)) {
            return false;
        }
        Preference other = (Preference) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Preference[ userid=" + userid + " ]";
    }
    
}
