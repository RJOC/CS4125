/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.Teacher;
import ModelLayer.Users;

/**
 *
 * @author Jono
 */
public class ManagerLogic extends ApplicationLogic{
        
    /// register a student && remove student
    /// register a teacher && remove teacher
    /// should combine to register user && remove user
    
    
    ///TODO: define what inputs are necessary for creating a user; do we generate uID here, or is that done on the webservice?
    public void registerUser(String userName, String userType){
        
        Users newUser;
        
        /// Needs to be changed?
        if(userType.equals("Teacher")){
            //// int uID, String uName, int phoneNum
            newUser = new Teacher(-1,userName,-1);
            
            /// 
        }
    
    }
    
    public void removeUser (String userName, int userID) {
    
    }
    
    public void registerClass(String className){
        
    }
    public void removeClass(String className){
        
    }
    
}
