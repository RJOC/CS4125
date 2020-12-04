/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.DanceClass;

/**
 *
 * @author Jono
 */
public class TeacherLogic extends ApplicationLogic{
    
    public DanceClass viewOwnClass(){
        return super.model.getOwnClass();
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