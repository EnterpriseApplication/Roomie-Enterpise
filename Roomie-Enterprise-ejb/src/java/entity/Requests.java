/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "requests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r")
    , @NamedQuery(name = "Requests.findByFromRequest", query = "SELECT r FROM Requests r WHERE r.requestsPK.fromRequest = :fromRequest")
    , @NamedQuery(name = "Requests.findByToRequest", query = "SELECT r FROM Requests r WHERE r.requestsPK.toRequest = :toRequest")})
public class Requests implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequestsPK requestsPK;

    public Requests() {
    }

    public Requests(RequestsPK requestsPK) {
        this.requestsPK = requestsPK;
    }

    public Requests(String fromRequest, String toRequest) {
        this.requestsPK = new RequestsPK(fromRequest, toRequest);
    }

    public RequestsPK getRequestsPK() {
        return requestsPK;
    }

    public void setRequestsPK(RequestsPK requestsPK) {
        this.requestsPK = requestsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestsPK != null ? requestsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requests)) {
            return false;
        }
        Requests other = (Requests) object;
        if ((this.requestsPK == null && other.requestsPK != null) || (this.requestsPK != null && !this.requestsPK.equals(other.requestsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Requests[ requestsPK=" + requestsPK + " ]";
    }
    
}
