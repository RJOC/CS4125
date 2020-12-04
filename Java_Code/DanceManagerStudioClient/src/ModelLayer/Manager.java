/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author oconn
 */
public class Manager extends Users {
    private String firstName;
    private String lastName;
    private int permissions;
    
    public Manager(){
        this(-1,"Default",-1,"Unknown","Unknown");
    }
    
    public Manager(int uID, String uName, int phoneNum, String firstName, String lastName ){
        
        super(uID, uName, phoneNum);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }
    
}
