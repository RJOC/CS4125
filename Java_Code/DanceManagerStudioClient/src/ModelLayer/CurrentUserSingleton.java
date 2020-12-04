/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Jono
 */
public class CurrentUserSingleton {
    private static Users currentUser = null;
    
    private CurrentUserSingleton(){
        ///private constructor ///There can be ONLY ONE
    }
    
    public static Users getInstance(String uType, String uFName, String uLName){
        
        //lazy initialization
        if(currentUser == null){
            if(uType.equals("Manager")){
                ///TODO: refactor Manager constructor
                currentUser = new Manager();
            }
            else{
                ///TODO: refactor Users constructor
                currentUser = new Users();
            }
        }            
        return currentUser;
    }
    
    public static void logOut(){
        currentUser = null;       
    }
}
