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


//manager =3 
//teacher =2
//student =1
/**
 *
 * @author Jono
 */
public class ManagerLogic extends ApplicationLogic{
            
    /// uID is generated by web service.
    //needs to return an int
    public int registerUser(int userType, String uName,  String firstName, String lastName, String password, String email){
        
 //todo 
    //refactor classes to add email and password etc...
        Users newUser;
        
        if(userType == 2){
            //// int uID, String uName, int phoneNum
   //          newUser = new Teacher(2,uName);
            
            /// make call to database() through DataAcess in model layer 
   //         super.model.dbWrite("registerTeacher", newUser);
        return 1;
        }
        else if(userType == 3){
            /// int uID, String uName, String firstName, String lastName 
            newUser = new Manager(3,uName, firstName, lastName);
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
    
    public int registerClass(String className,  int teacherID, int skillID, String classDesc, int maxAttend){
        //problem, database created with no times or dates. Not sure if we can get it
         
//        DanceClass newClass = new DanceClass();
//        newClass.setStartTime(startTime);
//        newClass.setFinishTime(finishTime);
//        
//        Teacher classTeacher = new Teacher(); 
//        /// temp assignment; TODO: pull teacher from database and build here?
//        classTeacher.setuName(teacherName);
//        
//        newClass.setTeacher(classTeacher);
//        
//        ///TODO: define instruction
//        super.model.dbWrite("registerClass", newClass);
        
        return 1;// return 1 if successful
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
    
    //Need the code to pull all the teachers names (First names are fine)
    public String[] getAllTeachers(){
        String teacherList [] ={"Teacher1","Teacher2"};
 
        return teacherList;
    }
    
    public int getTeacherIDFromName(String tName){
        int teacherID =12;
        
        return teacherID;
    }
}


