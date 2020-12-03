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
 
    public Users(){
        this(-1,"empty",-1);
    }
  
    public Users(int uID, String uName,int phoneNum){
        this.uID = uID;
        this.uName = uName;
        this.phoneNum = phoneNum;
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
