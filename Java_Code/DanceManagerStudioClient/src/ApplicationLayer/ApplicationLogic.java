/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;
import ModelLayer.ApplicationModel;
import ModelLayer.CurrentUserSingleton;
import ModelLayer.Data;
import ModelLayer.DataAccess.DBReader_WEB;
import ModelLayer.DataAccess.DBWriter_WEB;
import java.io.IOException;


//Count funtions from db return strings
//we need to parse back to an int
//manager =3 
//teacher =2
//student =1
/**
 *
 * @author Jono
 */
public class ApplicationLogic {
    ApplicationModel model;

    public ApplicationLogic() {        
        model = new ApplicationModel();
    }   
    
    public boolean logIn(String uName, String pWord) throws IOException{ 
        boolean testlog = DBReader_WEB.login(uName, pWord);
        if(testlog == true){
            /// user exists so call database and get user details.
            Data curUser = model.dbRead("GetUser", uName);
            if(curUser.getData().size()>0){
                CurrentUserSingleton.getInstance(curUser.getDataName(), Integer.parseInt(curUser.getData().get(0).get(0)), uName, "uFName", "uLName");
            }else{          
                /// user exists but was not read in correctly, assign default.
                CurrentUserSingleton.getInstance();
            }
            return true;
        } else{
        return false;
        }
    }
    
    public void logOut(){
        CurrentUserSingleton.logOut();
    }
    
    public int registerStudent(String uName, String fName, String lName, String pWord, String email ) throws IOException{
   
        boolean success = DBWriter_WEB.CreateUser( email,  fName,  lName,  pWord,  1,  uName);
            if(success){
                return 1;
            }else{
                return 0;
            }

 

    }
}