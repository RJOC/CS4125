/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.DanceClass;
import ModelLayer.Manager;
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
    
    
    ///TODO: define what inputs are necessary for creating a user; do we generate uID here, or is that done on the webservice? (answer: is generated)
    public void registerUser(String userType, String uName,  String firstName, String lastName){
        
        Users newUser;
        
        if(userType.equals("Teacher")){
            //// int uID, String uName, int phoneNum
            newUser = new Teacher(-1,uName,-1);
            
            /// make call to database()  through model layer 
            ///TODO: define instruction
            super.model.dbWrite("instruction", newUser);
        }
        else if(userType.equals("Manager")){
            /// int uID, String uName, int phoneNum, String firstName, String lastName 
            newUser = new Manager(-1,uName,-1, firstName, lastName);
            ///TODO: define instruction
            super.model.dbWrite("instruction", newUser);
        }
        
    }
    
    public void removeUser (String userName, int userID) {
    
    }
    
    public void registerClass(String className, String teacherName){
        DanceClass newClass = new DanceClass();
        Teacher classTeacher = new Teacher(); 
        /// temp assignment; TODO: pull teacher from database and build here
        classTeacher.setuName(teacherName);
        
        newClass.setTeacher(classTeacher);
        
        ///TODO: define instruction
        super.model.dbWrite("instruction", newClass);
    }
    public void removeClass(String className){
        
    }
    
}
