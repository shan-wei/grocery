/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GOBS_TECH_02
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustid", query = "SELECT c FROM Customer c WHERE c.custid = :custid"),
    @NamedQuery(name = "Customer.findByCustic", query = "SELECT c FROM Customer c WHERE c.custic = :custic"),
    @NamedQuery(name = "Customer.findByCustfname", query = "SELECT c FROM Customer c WHERE c.custfname = :custfname"),
    @NamedQuery(name = "Customer.findByCustlname", query = "SELECT c FROM Customer c WHERE c.custlname = :custlname"),
    @NamedQuery(name = "Customer.findByCustemail", query = "SELECT c FROM Customer c WHERE c.custemail = :custemail"),
    @NamedQuery(name = "Customer.findByCustcontactnumber", query = "SELECT c FROM Customer c WHERE c.custcontactnumber = :custcontactnumber"),
    @NamedQuery(name = "Customer.findByCustaddress", query = "SELECT c FROM Customer c WHERE c.custaddress = :custaddress"),
    @NamedQuery(name = "Customer.findByCustpassword", query = "SELECT c FROM Customer c WHERE c.custpassword = :custpassword"),
    @NamedQuery(name = "Customer.findByCustjoindate", query = "SELECT c FROM Customer c WHERE c.custjoindate = :custjoindate"),
    @NamedQuery(name = "Customer.findByCustimagename", query = "SELECT c FROM Customer c WHERE c.custimagename = :custimagename")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTID")
    private String custid;
    @Column(name = "CUSTIC")
    private String custic;
    @Column(name = "CUSTFNAME")
    private String custfname;
    @Column(name = "CUSTLNAME")
    private String custlname;
    @Column(name = "CUSTEMAIL")
    private String custemail;
    @Column(name = "CUSTCONTACTNUMBER")
    private String custcontactnumber;
    @Column(name = "CUSTADDRESS")
    private String custaddress;
    @Column(name = "CUSTPASSWORD")
    private String custpassword;
    @Column(name = "CUSTJOINDATE")
    @Temporal(TemporalType.DATE)
    private Date custjoindate;
    @Lob
    @Column(name = "CUSTIMAGE")
    private Serializable custimage;
    @Column(name = "CUSTIMAGENAME")
    private String custimagename;
    @OneToMany(mappedBy = "custid")
    private Collection<Cart> cartCollection;

    public Customer() {
    }

    public Customer(String custid) {
        this.custid = custid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustic() {
        return custic;
    }

    public void setCustic(String custic) {
        this.custic = custic;
    }

    public String getCustfname() {
        return custfname;
    }

    public void setCustfname(String custfname) {
        this.custfname = custfname;
    }

    public String getCustlname() {
        return custlname;
    }

    public void setCustlname(String custlname) {
        this.custlname = custlname;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getCustcontactnumber() {
        return custcontactnumber;
    }

    public void setCustcontactnumber(String custcontactnumber) {
        this.custcontactnumber = custcontactnumber;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    public Date getCustjoindate() {
        return custjoindate;
    }

    public void setCustjoindate(Date custjoindate) {
        this.custjoindate = custjoindate;
    }

    public Serializable getCustimage() {
        return custimage;
    }

    public void setCustimage(Serializable custimage) {
        this.custimage = custimage;
    }

    public String getCustimagename() {
        return custimagename;
    }

    public void setCustimagename(String custimagename) {
        this.custimagename = custimagename;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custid != null ? custid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custid == null && other.custid != null) || (this.custid != null && !this.custid.equals(other.custid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ custid=" + custid + " ]";
    }
    
}
