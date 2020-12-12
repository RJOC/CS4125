/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dcod1
 */
@Entity
@Table(name = "wages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wages.findAll", query = "SELECT w FROM Wages w")
    , @NamedQuery(name = "Wages.findById", query = "SELECT w FROM Wages w WHERE w.id = :id")
    , @NamedQuery(name = "Wages.findByWage", query = "SELECT w FROM Wages w WHERE w.wage = :wage")
    , @NamedQuery(name = "Wages.findByDate", query = "SELECT w FROM Wages w WHERE w.date = :date")})
public class Wages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "wage")
    private Integer wage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "teacherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users teacherID;

    public Wages() {
    }

    public Wages(Integer id) {
        this.id = id;
    }

    public Wages(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Users teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wages)) {
            return false;
        }
        Wages other = (Wages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Wages[ id=" + id + " ]";
    }

    
}
