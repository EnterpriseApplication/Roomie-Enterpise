/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Embeddable
public class RequestsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "from_request")
    private String fromRequest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "to_request")
    private String toRequest;

    public RequestsPK() {
    }

    public RequestsPK(String fromRequest, String toRequest) {
        this.fromRequest = fromRequest;
        this.toRequest = toRequest;
    }

    public String getFromRequest() {
        return fromRequest;
    }

    public void setFromRequest(String fromRequest) {
        this.fromRequest = fromRequest;
    }

    public String getToRequest() {
        return toRequest;
    }

    public void setToRequest(String toRequest) {
        this.toRequest = toRequest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fromRequest != null ? fromRequest.hashCode() : 0);
        hash += (toRequest != null ? toRequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestsPK)) {
            return false;
        }
        RequestsPK other = (RequestsPK) object;
        if ((this.fromRequest == null && other.fromRequest != null) || (this.fromRequest != null && !this.fromRequest.equals(other.fromRequest))) {
            return false;
        }
        if ((this.toRequest == null && other.toRequest != null) || (this.toRequest != null && !this.toRequest.equals(other.toRequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RequestsPK[ fromRequest=" + fromRequest + ", toRequest=" + toRequest + " ]";
    }
    
}
