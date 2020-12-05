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
        model = new ApplicationModel();
    }   
    
    public void logIn(String uType, int uID, String uName, String uFName, String uLName){ 
        CurrentUserSingleton.getInstance(uType, uID, uName, uFName, uLName);
    }
    
    public void logOut(){
        CurrentUserSingleton.logOut();
    }
}