/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryid", query = "SELECT c FROM Category c WHERE c.categoryid = :categoryid"),
    @NamedQuery(name = "Category.findByCategorydesc", query = "SELECT c FROM Category c WHERE c.categorydesc = :categorydesc")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORYID")
    private String categoryid;
    @Column(name = "CATEGORYDESC")
    private String categorydesc;
    @OneToMany(mappedBy = "categoryid")
    private Collection<Product> productCollection;

    public Category() {
    }

    public Category(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategorydesc() {
        return categorydesc;
    }

    public void setCategorydesc(String categorydesc) {
        this.categorydesc = categorydesc;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryid != null ? categoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ categoryid=" + categoryid + " ]";
    }
    
}
