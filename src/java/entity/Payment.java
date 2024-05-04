/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GOBS_TECH_02
 */
@Entity
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid"),
    @NamedQuery(name = "Payment.findByPaymenttotal", query = "SELECT p FROM Payment p WHERE p.paymenttotal = :paymenttotal"),
    @NamedQuery(name = "Payment.findByPaymenttype", query = "SELECT p FROM Payment p WHERE p.paymenttype = :paymenttype"),
    @NamedQuery(name = "Payment.findByPaymentdate", query = "SELECT p FROM Payment p WHERE p.paymentdate = :paymentdate")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAYMENTID")
    private String paymentid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENTTOTAL")
    private BigDecimal paymenttotal;
    @Column(name = "PAYMENTTYPE")
    private String paymenttype;
    @Column(name = "PAYMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date paymentdate;

    public Payment() {
    }

    public Payment(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public BigDecimal getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(BigDecimal paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ paymentid=" + paymentid + " ]";
    }
    
}
