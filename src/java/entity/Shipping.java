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
@Table(name = "SHIPPING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipping.findAll", query = "SELECT s FROM Shipping s"),
    @NamedQuery(name = "Shipping.findByShipid", query = "SELECT s FROM Shipping s WHERE s.shipid = :shipid"),
    @NamedQuery(name = "Shipping.findByShipdate", query = "SELECT s FROM Shipping s WHERE s.shipdate = :shipdate"),
    @NamedQuery(name = "Shipping.findByShipcost", query = "SELECT s FROM Shipping s WHERE s.shipcost = :shipcost")})
public class Shipping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SHIPID")
    private String shipid;
    @Column(name = "SHIPDATE")
    @Temporal(TemporalType.DATE)
    private Date shipdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SHIPCOST")
    private BigDecimal shipcost;

    public Shipping() {
    }

    public Shipping(String shipid) {
        this.shipid = shipid;
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public BigDecimal getShipcost() {
        return shipcost;
    }

    public void setShipcost(BigDecimal shipcost) {
        this.shipcost = shipcost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipid != null ? shipid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipping)) {
            return false;
        }
        Shipping other = (Shipping) object;
        if ((this.shipid == null && other.shipid != null) || (this.shipid != null && !this.shipid.equals(other.shipid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shipping[ shipid=" + shipid + " ]";
    }
    
}
