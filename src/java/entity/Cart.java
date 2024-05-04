/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GOBS_TECH_02
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByCartstatus", query = "SELECT c FROM Cart c WHERE c.cartstatus = :cartstatus")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CARTID")
    private String cartid;
    @Column(name = "CARTSTATUS")
    private String cartstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Collection<Cartdetails> cartdetailsCollection;
    @JoinColumn(name = "CUSTID", referencedColumnName = "CUSTID")
    @ManyToOne
    private Customer custid;

    public Cart() {
    }

    public Cart(String cartid) {
        this.cartid = cartid;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getCartstatus() {
        return cartstatus;
    }

    public void setCartstatus(String cartstatus) {
        this.cartstatus = cartstatus;
    }

    @XmlTransient
    public Collection<Cartdetails> getCartdetailsCollection() {
        return cartdetailsCollection;
    }

    public void setCartdetailsCollection(Collection<Cartdetails> cartdetailsCollection) {
        this.cartdetailsCollection = cartdetailsCollection;
    }

    public Customer getCustid() {
        return custid;
    }

    public void setCustid(Customer custid) {
        this.custid = custid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartid != null ? cartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartid == null && other.cartid != null) || (this.cartid != null && !this.cartid.equals(other.cartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ cartid=" + cartid + " ]";
    }
    
}
