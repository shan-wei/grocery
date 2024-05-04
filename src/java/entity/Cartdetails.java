/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GOBS_TECH_02
 */
@Entity
@Table(name = "CARTDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartdetails.findAll", query = "SELECT c FROM Cartdetails c"),
    @NamedQuery(name = "Cartdetails.findByCartid", query = "SELECT c FROM Cartdetails c WHERE c.cartdetailsPK.cartid = :cartid"),
    @NamedQuery(name = "Cartdetails.findByProdid", query = "SELECT c FROM Cartdetails c WHERE c.cartdetailsPK.prodid = :prodid"),
    @NamedQuery(name = "Cartdetails.findByCartquantity", query = "SELECT c FROM Cartdetails c WHERE c.cartquantity = :cartquantity")})
public class Cartdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartdetailsPK cartdetailsPK;
    @Column(name = "CARTQUANTITY")
    private Integer cartquantity;
    @JoinColumn(name = "CARTID", referencedColumnName = "CARTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cart cart;
    @JoinColumn(name = "PRODID", referencedColumnName = "PRODID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Cartdetails() {
    }

    public Cartdetails(CartdetailsPK cartdetailsPK) {
        this.cartdetailsPK = cartdetailsPK;
    }

    public Cartdetails(String cartid, String prodid) {
        this.cartdetailsPK = new CartdetailsPK(cartid, prodid);
    }

    public CartdetailsPK getCartdetailsPK() {
        return cartdetailsPK;
    }

    public void setCartdetailsPK(CartdetailsPK cartdetailsPK) {
        this.cartdetailsPK = cartdetailsPK;
    }

    public Integer getCartquantity() {
        return cartquantity;
    }

    public void setCartquantity(Integer cartquantity) {
        this.cartquantity = cartquantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartdetailsPK != null ? cartdetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartdetails)) {
            return false;
        }
        Cartdetails other = (Cartdetails) object;
        if ((this.cartdetailsPK == null && other.cartdetailsPK != null) || (this.cartdetailsPK != null && !this.cartdetailsPK.equals(other.cartdetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cartdetails[ cartdetailsPK=" + cartdetailsPK + " ]";
    }
    
}
