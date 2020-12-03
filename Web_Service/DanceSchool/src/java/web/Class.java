/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dcod1
 */
@Entity
@Table(name = "class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c")
    , @NamedQuery(name = "Class.findById", query = "SELECT c FROM Class c WHERE c.id = :id")
    , @NamedQuery(name = "Class.findByName", query = "SELECT c FROM Class c WHERE c.name = :name")
    , @NamedQuery(name = "Class.findByClassDesc", query = "SELECT c FROM Class c WHERE c.classDesc = :classDesc")
    , @NamedQuery(name = "Class.findByMaxAttend", query = "SELECT c FROM Class c WHERE c.maxAttend = :maxAttend")})
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "class_desc")
    private String classDesc;
    @Column(name = "maxAttend")
    private Integer maxAttend;
    @JoinColumn(name = "teacherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users teacherID;
    @JoinColumn(name = "skill_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Skill skillID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classID")
    private Collection<Attendance> attendanceCollection;

    public Class() {
    }

    public Class(Integer id) {
        this.id = id;
    }

    public Class(Integer id, String name, String classDesc) {
        this.id = id;
        this.name = name;
        this.classDesc = classDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public Integer getMaxAttend() {
        return maxAttend;
    }

    public void setMaxAttend(Integer maxAttend) {
        this.maxAttend = maxAttend;
    }

    public Users getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Users teacherID) {
        this.teacherID = teacherID;
    }

    public Skill getSkillID() {
        return skillID;
    }

    public void setSkillID(Skill skillID) {
        this.skillID = skillID;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
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
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Class[ id=" + id + " ]";
    }
    
}
