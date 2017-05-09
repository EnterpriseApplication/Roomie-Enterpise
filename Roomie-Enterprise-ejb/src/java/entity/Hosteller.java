/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */





@Entity
@Table(name = "hosteller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hosteller.findAll", query = "SELECT h FROM Hosteller h")
    , @NamedQuery(name = "Hosteller.findByHostellername", query = "SELECT h FROM Hosteller h WHERE h.hostellername = :hostellername")
    , @NamedQuery(name = "Hosteller.findByUserid", query = "SELECT h FROM Hosteller h WHERE h.userid = :userid")
    , @NamedQuery(name = "Hosteller.findByPassword", query = "SELECT h FROM Hosteller h WHERE h.password = :password")
    , @NamedQuery(name = "Hosteller.findByHoemtown", query = "SELECT h FROM Hosteller h WHERE h.hoemtown = :hoemtown")
    , @NamedQuery(name = "Hosteller.findByAllotedStatus", query = "SELECT h FROM Hosteller h WHERE h.allotedStatus = :allotedStatus")})


/*
@SqlResultSetMapping(name="updateStatus", columns = { @ColumnResult(name = "alloted_status")})
 
@NamedNativeQueries({
        @NamedNativeQuery(
                name    =   "updateStatus",
                query   =   "UPDATE employee SET alloted_status = ?,  WHERE userid = ?"
                ,resultSetMapping = "updateStatus"
        )
})
*/

public class Hosteller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "hostellername")
    private String hostellername;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "userid")
    private String userid;
    @Size(max = 40)
    @Column(name = "password")
    private String password;
    @Size(max = 40)
    @Column(name = "hoemtown")
    private String hoemtown;
    @Size(max = 2)
    @Column(name = "alloted_status")
    private String allotedStatus;

    public Hosteller() {
    }

    public Hosteller(String userid) {
        this.userid = userid;
    }

    public String getHostellername() {
        return hostellername;
    }

    public void setHostellername(String hostellername) {
        this.hostellername = hostellername;
        
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoemtown() {
        return hoemtown;
    }

    public void setHoemtown(String hoemtown) {
        this.hoemtown = hoemtown;
    }

    public String getAllotedStatus() {
        
        return allotedStatus;
    }

    public void setAllotedStatus(String allotedStatus) {
        this.allotedStatus = allotedStatus;
        
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
        if (!(object instanceof Hosteller)) {
            return false;
        }
        Hosteller other = (Hosteller) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hosteller[ userid=" + userid + " ]";
    }
    
}
