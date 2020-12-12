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
import java.util.ArrayList;


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
        //call to database
        //return for singleton
        //CurrentUserSingleton.getInstance(uType, uID, uName, uFName, uLName);
        boolean testlog = DBReader_WEB.login(uName, pWord);
        if(testlog == true){
        return true;
        } else{
        return false;
        }
    }
    
    public void logOut(){
        CurrentUserSingleton.logOut();
    }
    
    public int registerStudent(String uName, String fName, String lName, String pWord, String email ){
        int permissionID = 1;
                
        Data data = new Data();
        data.setDataName("Student");
        data.getData().add(new ArrayList<>());
        data.getData().get(0).add(uName);
        
        /// additional instruction to add student to specific class?
        String instruction = "registerStudent";
        model.dbWrite(instruction, data);

        return 1;

    }
}