/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dcod1
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
    , @NamedQuery(name = "Attendance.findByAttendID", query = "SELECT a FROM Attendance a WHERE a.attendID = :attendID")})
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attend_ID")
    private Integer attendID;
    @JoinColumn(name = "classID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Class classID;
    @JoinColumn(name = "Student_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users studentID;

    public Attendance() {
    }

    public Attendance(Integer attendID) {
        this.attendID = attendID;
    }

    public Integer getAttendID() {
        return attendID;
    }

    public void setAttendID(Integer attendID) {
        this.attendID = attendID;
    }

    public Class getClassID() {
        return classID;
    }

    public void setClassID(Class classID) {
        this.classID = classID;
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
        hash += (attendID != null ? attendID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendID == null && other.attendID != null) || (this.attendID != null && !this.attendID.equals(other.attendID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Attendance[ attendID=" + attendID + " ]";
    }
    
}
