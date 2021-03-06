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
    
    public static Users getInstance(){
        if(currentUser == null){
            currentUser = new Users();
        }
        return currentUser;
    }
    
    public static Users getInstance(String uType, int uID, String uName, String uFName, String uLName){
        
        //lazy initialization #GangOfFour
        if(currentUser == null){
            switch (uType) {
                case "Manager":
                    currentUser = new Manager(uID, uName, uFName, uLName);
                    break;
                case "Teacher":
                    currentUser = new Teacher(uID, uName);
                    break;
                default:
                    currentUser = new Users();
                    break;
            }
        }            
        return currentUser;
    }
    
    public static void logOut(){
        currentUser = null;       
    }
}
