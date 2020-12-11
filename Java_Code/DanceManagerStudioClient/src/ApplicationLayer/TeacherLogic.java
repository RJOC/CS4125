/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.DanceClass;
import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class TeacherLogic extends ApplicationLogic{
    
    public ArrayList<DanceClass> getOwnClasses(){
        ArrayList<DanceClass> own = new ArrayList<>();
        
        if(!super.model.getDanceClasses().isEmpty()){
            own.addAll(super.model.getDanceClasses());
        }
        else{
            /// TODO: else if(){pass current user to database and read in class}
            /// use singleton userID as key.
            /// CurrentUserSingleton.getInstance().getuID();
        }
            
        return own;
    }
    
    public void reportIncident(){
        /// generate incedent report
    }
    
    public void cancelClass(){
        /// need notify method
    }
    
    public void viewWages(){
    
    }
}