/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;
import ModelLayer.ApplicationModel;

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
    
    /// register a student && remove student
    /// register a teacher && remove teacher
    /// should combine to register user && remove user
    
    
    ///TODO: define what inputs are necessary for creating a user; do we generate uID here, or is that done on the webservice?
    public void registerUser(String userName, String userType){
        
    
    }
    
    public void removeUser (String userName, int userID) {
    
    }
    
}



