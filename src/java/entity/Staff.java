/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStfId", query = "SELECT s FROM Staff s WHERE s.stfId = :stfId"),
    @NamedQuery(name = "Staff.findByStfFname", query = "SELECT s FROM Staff s WHERE s.stfFname = :stfFname"),
    @NamedQuery(name = "Staff.findByStfLname", query = "SELECT s FROM Staff s WHERE s.stfLname = :stfLname"),
    @NamedQuery(name = "Staff.findByStfPosition", query = "SELECT s FROM Staff s WHERE s.stfPosition = :stfPosition"),
    @NamedQuery(name = "Staff.findByStfIc", query = "SELECT s FROM Staff s WHERE s.stfIc = :stfIc"),
    @NamedQuery(name = "Staff.findByStfGender", query = "SELECT s FROM Staff s WHERE s.stfGender = :stfGender"),
    @NamedQuery(name = "Staff.findByStfPhone", query = "SELECT s FROM Staff s WHERE s.stfPhone = :stfPhone"),
    @NamedQuery(name = "Staff.findByStfEmail", query = "SELECT s FROM Staff s WHERE s.stfEmail = :stfEmail"),
    @NamedQuery(name = "Staff.findByStfPswd", query = "SELECT s FROM Staff s WHERE s.stfPswd = :stfPswd"),
    @NamedQuery(name = "Staff.findByStfJoindate", query = "SELECT s FROM Staff s WHERE s.stfJoindate = :stfJoindate"),
    @NamedQuery(name = "Staff.findByStfBirthdate", query = "SELECT s FROM Staff s WHERE s.stfBirthdate = :stfBirthdate"),
    @NamedQuery(name = "Staff.findByStfAvatarname", query = "SELECT s FROM Staff s WHERE s.stfAvatarname = :stfAvatarname")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STF_ID")
    private String stfId;
    @Column(name = "STF_FNAME")
    private String stfFname;
    @Column(name = "STF_LNAME")
    private String stfLname;
    @Column(name = "STF_POSITION")
    private String stfPosition;
    @Column(name = "STF_IC")
    private String stfIc;
    @Column(name = "STF_GENDER")
    private Character stfGender;
    @Column(name = "STF_PHONE")
    private String stfPhone;
    @Column(name = "STF_EMAIL")
    private String stfEmail;
    @Column(name = "STF_PSWD")
    private String stfPswd;
    @Column(name = "STF_JOINDATE")
    @Temporal(TemporalType.DATE)
    private Date stfJoindate;
    @Column(name = "STF_BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date stfBirthdate;
    @Lob
    @Column(name = "STF_AVATAR")
    private Serializable stfAvatar;
    @Column(name = "STF_AVATARNAME")
    private String stfAvatarname;

    public Staff() {
    }

    public Staff(String stfId) {
        this.stfId = stfId;
    }

    public String getStfId() {
        return stfId;
    }

    public void setStfId(String stfId) {
        this.stfId = stfId;
    }

    public String getStfFname() {
        return stfFname;
    }

    public void setStfFname(String stfFname) {
        this.stfFname = stfFname;
    }

    public String getStfLname() {
        return stfLname;
    }

    public void setStfLname(String stfLname) {
        this.stfLname = stfLname;
    }

    public String getStfPosition() {
        return stfPosition;
    }

    public void setStfPosition(String stfPosition) {
        this.stfPosition = stfPosition;
    }

    public String getStfIc() {
        return stfIc;
    }

    public void setStfIc(String stfIc) {
        this.stfIc = stfIc;
    }

    public Character getStfGender() {
        return stfGender;
    }

    public void setStfGender(Character stfGender) {
        this.stfGender = stfGender;
    }

    public String getStfPhone() {
        return stfPhone;
    }

    public void setStfPhone(String stfPhone) {
        this.stfPhone = stfPhone;
    }

    public String getStfEmail() {
        return stfEmail;
    }

    public void setStfEmail(String stfEmail) {
        this.stfEmail = stfEmail;
    }

    public String getStfPswd() {
        return stfPswd;
    }

    public void setStfPswd(String stfPswd) {
        this.stfPswd = stfPswd;
    }

    public Date getStfJoindate() {
        return stfJoindate;
    }

    public void setStfJoindate(Date stfJoindate) {
        this.stfJoindate = stfJoindate;
    }

    public Date getStfBirthdate() {
        return stfBirthdate;
    }

    public void setStfBirthdate(Date stfBirthdate) {
        this.stfBirthdate = stfBirthdate;
    }

    public Serializable getStfAvatar() {
        return stfAvatar;
    }

    public void setStfAvatar(Serializable stfAvatar) {
        this.stfAvatar = stfAvatar;
    }

    public String getStfAvatarname() {
        return stfAvatarname;
    }

    public void setStfAvatarname(String stfAvatarname) {
        this.stfAvatarname = stfAvatarname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stfId != null ? stfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.stfId == null && other.stfId != null) || (this.stfId != null && !this.stfId.equals(other.stfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ stfId=" + stfId + " ]";
    }
    
}
