/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;
import ModelLayer.ApplicationModel;
import ModelLayer.CurrentUserSingleton;

/**
 *
 * @author Jono
 */
public class ApplicationLogic {
    ApplicationModel model;

    public ApplicationLogic() {
        // pass in model? or build model here? build for now.
        model = new ApplicationModel();
    }   
    
    public void logIn(){
    // TODO: define input values.    
    // CurrentUserSingleton.getInstance(uType, uFName, uLName)
    }
    
    public void logOut(){
        CurrentUserSingleton.logOut();
    }
}