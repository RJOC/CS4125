/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;
import ModelLayer.ApplicationModel;
import ModelLayer.CurrentUserSingleton;
import ModelLayer.Data;
import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class ApplicationLogic {
    ApplicationModel model;

    public ApplicationLogic() {        
        model = new ApplicationModel();
    }   
    
    public boolean logIn(String uName, String pWord){ 
        //call to database
        //return for singleton
        //CurrentUserSingleton.getInstance(uType, uID, uName, uFName, uLName);
        
        return true;
    }
    
    public void logOut(){
        CurrentUserSingleton.logOut();
    }
    
    public int registerStudent(String uName /*,  String firstName, String lastName*/ ){
        Data data = new Data();
        data.setDataName("Student");
        data.getData().add(new ArrayList<>());
        data.getData().get(0).add(uName);
        
        String instruction = "";
        model.dbWrite(instruction, data);

        return 1;

    }
}