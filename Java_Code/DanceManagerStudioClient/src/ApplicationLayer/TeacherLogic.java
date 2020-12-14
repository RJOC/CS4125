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
            /// TODO: pass current user to database and read in associated class
        }            
        return own;
    }
    
    public void reportIncident(){
        ///TODO: generate incedent report
    }
    
    public void cancelClass(){
        ///TODO: implement method
    }
    
    public void viewWages(){
        ///TODO: implement method
    }
}