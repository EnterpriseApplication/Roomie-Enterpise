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
@Table(name = "additional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Additional.findAll", query = "SELECT a FROM Additional a")
    , @NamedQuery(name = "Additional.findByUserid", query = "SELECT a FROM Additional a WHERE a.userid = :userid")
    , @NamedQuery(name = "Additional.findByFoodChoice", query = "SELECT a FROM Additional a WHERE a.foodChoice = :foodChoice")
    , @NamedQuery(name = "Additional.findByHigherStudy", query = "SELECT a FROM Additional a WHERE a.higherStudy = :higherStudy")})
public class Additional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userid")
    private String userid;
    @Column(name = "food_choice")
    private Integer foodChoice;
    @Column(name = "higher_study")
    private Integer higherStudy;
    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hosteller hosteller;

    public Additional() {
    }

    public Additional(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getFoodChoice() {
        return foodChoice;
    }

    public void setFoodChoice(Integer foodChoice) {
        this.foodChoice = foodChoice;
    }

    public Integer getHigherStudy() {
        return higherStudy;
    }

    public void setHigherStudy(Integer higherStudy) {
        this.higherStudy = higherStudy;
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
        if (!(object instanceof Additional)) {
            return false;
        }
        Additional other = (Additional) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Additional[ userid=" + userid + " ]";
    }
    
}
