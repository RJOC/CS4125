/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dance_entity;

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
@Table(name = "payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p")
    , @NamedQuery(name = "Payments.findByPayID", query = "SELECT p FROM Payments p WHERE p.payID = :payID")
    , @NamedQuery(name = "Payments.findByPayment", query = "SELECT p FROM Payments p WHERE p.payment = :payment")
    , @NamedQuery(name = "Payments.findByDate", query = "SELECT p FROM Payments p WHERE p.date = :date")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pay_ID")
    private Integer payID;
    @Column(name = "payment")
    private Integer payment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "studentID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users studentID;

    public Payments() {
    }

    public Payments(Integer payID) {
        this.payID = payID;
    }

    public Payments(Integer payID, Date date) {
        this.payID = payID;
        this.date = date;
    }

    public Integer getPayID() {
        return payID;
    }

    public void setPayID(Integer payID) {
        this.payID = payID;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getStudentID() {
        return studentID;
    }

    public void setStudentID(Users studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payID != null ? payID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.payID == null && other.payID != null) || (this.payID != null && !this.payID.equals(other.payID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dance_entity.Payments[ payID=" + payID + " ]";
    }
    
}
