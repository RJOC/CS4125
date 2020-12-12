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
import javax.persistence.Id;
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
@Table(name = "permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p")
    , @NamedQuery(name = "Permissions.findByPermID", query = "SELECT p FROM Permissions p WHERE p.permID = :permID")
    , @NamedQuery(name = "Permissions.findUserTeacher", query = "select u from Permissions p Join p.usersCollection u where p.permID = 2")
    , @NamedQuery(name = "Permissions.findUserStudent", query = "select u from Permissions p Join p.usersCollection u where p.permID = 1")
    , @NamedQuery(name = "Permissions.findByuserID", query = "select p from Permissions p Join p.usersCollection u where u.id = :userID")
    , @NamedQuery(name = "Permissions.findByPermDesc", query = "SELECT p FROM Permissions p WHERE p.permDesc = :permDesc")})
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "perm_ID")
    private Integer permID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perm_desc")
    private String permDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionID")
    private Collection<Users> usersCollection;

    public Permissions() {
    }

    public Permissions(Integer permID) {
        this.permID = permID;
    }

    public Permissions(Integer permID, String permDesc) {
        this.permID = permID;
        this.permDesc = permDesc;
    }

    public Integer getPermID() {
        return permID;
    }

    public void setPermID(Integer permID) {
        this.permID = permID;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permID != null ? permID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissions)) {
            return false;
        }
        Permissions other = (Permissions) object;
        if ((this.permID == null && other.permID != null) || (this.permID != null && !this.permID.equals(other.permID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Permissions[ permID=" + permID + " ]";
    }
    
}
