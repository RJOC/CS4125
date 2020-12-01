/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Jono
 */
public class Users implements CustomDataType{
  public int uID;
  public String uName;
  public int phoneNum;
 
  Users () {
    uID = -1;
    uName = "empty";
    phoneNum = -1;

  }
  
    Users(int uID, String uName,int phoneNum){
    uID = -1;
    uName = "empty";
    phoneNum = -1;

  }
  
    public int getuID() {
        return uID;
    }

    public String getuName() {
        return uName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }   

    @Override
    public String dataType() {
        return("Users");
    }
    
}
