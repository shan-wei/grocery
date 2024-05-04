/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProdid", query = "SELECT p FROM Product p WHERE p.prodid = :prodid"),
    @NamedQuery(name = "Product.findByProdprice", query = "SELECT p FROM Product p WHERE p.prodprice = :prodprice"),
    @NamedQuery(name = "Product.findByProdname", query = "SELECT p FROM Product p WHERE p.prodname = :prodname"),
    @NamedQuery(name = "Product.findByProddesc", query = "SELECT p FROM Product p WHERE p.proddesc = :proddesc"),
    @NamedQuery(name = "Product.findByProdquantity", query = "SELECT p FROM Product p WHERE p.prodquantity = :prodquantity"),
    @NamedQuery(name = "Product.findByProdrating", query = "SELECT p FROM Product p WHERE p.prodrating = :prodrating"),
    @NamedQuery(name = "Product.findByProdcomment", query = "SELECT p FROM Product p WHERE p.prodcomment = :prodcomment")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODID")
    private String prodid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODPRICE")
    private BigDecimal prodprice;
    @Column(name = "PRODNAME")
    private String prodname;
    @Column(name = "PRODDESC")
    private String proddesc;
    @Lob
    @Column(name = "PRODIMAGE")
    private Serializable prodimage;
    @Column(name = "PRODQUANTITY")
    private Integer prodquantity;
    @Column(name = "PRODRATING")
    private BigDecimal prodrating;
    @Column(name = "PRODCOMMENT")
    private String prodcomment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<Cartdetails> cartdetailsCollection;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category categoryid;

    public Product() {
    }

    public Product(String prodid) {
        this.prodid = prodid;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public BigDecimal getProdprice() {
        return prodprice;
    }

    public void setProdprice(BigDecimal prodprice) {
        this.prodprice = prodprice;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProddesc() {
        return proddesc;
    }

    public void setProddesc(String proddesc) {
        this.proddesc = proddesc;
    }

    public Serializable getProdimage() {
        return prodimage;
    }

    public void setProdimage(Serializable prodimage) {
        this.prodimage = prodimage;
    }

    public Integer getProdquantity() {
        return prodquantity;
    }

    public void setProdquantity(Integer prodquantity) {
        this.prodquantity = prodquantity;
    }

    public BigDecimal getProdrating() {
        return prodrating;
    }

    public void setProdrating(BigDecimal prodrating) {
        this.prodrating = prodrating;
    }

    public String getProdcomment() {
        return prodcomment;
    }

    public void setProdcomment(String prodcomment) {
        this.prodcomment = prodcomment;
    }

    @XmlTransient
    public Collection<Cartdetails> getCartdetailsCollection() {
        return cartdetailsCollection;
    }

    public void setCartdetailsCollection(Collection<Cartdetails> cartdetailsCollection) {
        this.cartdetailsCollection = cartdetailsCollection;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodid != null ? prodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ prodid=" + prodid + " ]";
    }
    
}
