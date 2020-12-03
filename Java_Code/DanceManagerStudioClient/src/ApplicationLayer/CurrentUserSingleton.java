/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.Users;

/**
 *
 * @author Jono
 */
public class CurrentUserSingleton {
    private static Users currentUser = null;
    
    private CurrentUserSingleton(){
        ///private constructor ///There can be ONLY ONE
    }
    
    public static Users getInstance(){
        
        //lazy initialization
        if(currentUser == null){
            currentUser = new Users();
        }            
        return currentUser;
    }
    
}
