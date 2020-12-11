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
  private int uID;
  private String uName;
 
    public Users(){
        this(-1,"empty");
    }
  
    public Users(int uID, String uName){
        this.uID = uID;
        this.uName = uName;
    }
  
    public int getuID() {
        return uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public String dataType() {
        return("Users");
    }
    
}
