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
import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class ManagerLogic extends ApplicationLogic{
            
    /// uID is generated by web service.
    //needs to return an int
    public int registerUser(String userType, String uName,  String firstName, String lastName, String password, String email){
        
 
        Users newUser;
        
        if(userType.equals("Teacher")){
            //// int uID, String uName, int phoneNum
            newUser = new Teacher(-1,uName);
            
            /// make call to database() through DataAcess in model layer 
            super.model.dbWrite("registerTeacher", newUser);
        }
        else if(userType.equals("Manager")){
            /// int uID, String uName, String firstName, String lastName 
            newUser = new Manager(-1,uName, firstName, lastName);
            super.model.dbWrite("registerManager", newUser);
        }
        
        
        //If successful 
        return 1;
    }
    
    public int removeUser (String userName, int userID) {
        ///TODO: Define instruction
        String instruction = "";
        
        ///TODO: implement function
        super.model.dbRemove(instruction);
        /// temp return
        return 1;
    }
    
    public void registerClass(String className, String teacherName, String startTime, String finishTime){
        DanceClass newClass = new DanceClass();
        newClass.setStartTime(startTime);
        newClass.setFinishTime(finishTime);
        
        Teacher classTeacher = new Teacher(); 
        /// temp assignment; TODO: pull teacher from database and build here?
        classTeacher.setuName(teacherName);
        
        newClass.setTeacher(classTeacher);
        
        ///TODO: define instruction
        super.model.dbWrite("registerClass", newClass);
    }
    public int removeClass(String className){
        ///TODO: Define instruction
        String instruction = "";
        
        ///TODO: implement function
        super.model.dbRemove(instruction);
        
        /// temp return
        return 1;
    }
    
    public DanceClass viewClass(int index){
        return super.model.viewClass(index);
    }
    
    public ArrayList<DanceClass> viewClasses(){
        ArrayList<DanceClass> classes = new ArrayList<>();
        
        if(!super.model.getDanceClasses().isEmpty()){
            classes.addAll(super.model.getDanceClasses());
        }
        else{
            /// TODO: else if(){read in all classes}
        }          
        return classes;
    }
}
