/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author GOBS_TECH_02
 */
@Embeddable
public class CartdetailsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CARTID")
    private String cartid;
    @Basic(optional = false)
    @Column(name = "PRODID")
    private String prodid;

    public CartdetailsPK() {
    }

    public CartdetailsPK(String cartid, String prodid) {
        this.cartid = cartid;
        this.prodid = prodid;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartid != null ? cartid.hashCode() : 0);
        hash += (prodid != null ? prodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartdetailsPK)) {
            return false;
        }
        CartdetailsPK other = (CartdetailsPK) object;
        if ((this.cartid == null && other.cartid != null) || (this.cartid != null && !this.cartid.equals(other.cartid))) {
            return false;
        }
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartdetailsPK[ cartid=" + cartid + ", prodid=" + prodid + " ]";
    }
    
}
