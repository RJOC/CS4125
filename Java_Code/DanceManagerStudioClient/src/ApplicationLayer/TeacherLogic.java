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
    
    public ArrayList<DanceClass> viewOwnClasses(){
        /// TODO: change this to return class(es)
        return super.model.getOwnClasses();
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