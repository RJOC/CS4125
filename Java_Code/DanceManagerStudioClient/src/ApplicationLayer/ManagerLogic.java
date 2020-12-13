/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.CustomDataType;
import ModelLayer.DanceClass;
import ModelLayer.Data;
import ModelLayer.DataAccess.DBWriter_WEB;
import ModelLayer.Teacher;
import ModelLayer.Users;
import java.io.IOException;
import java.util.ArrayList;


//manager =3 
//teacher =2
//student =1
/**
 *
 * @author Jono
 */
public class ManagerLogic extends ApplicationLogic{
            

    public int registerUser(int userType, String uName,  String firstName, String lastName, String password, String email) throws IOException{
        Users newUser = null;
        
        if(userType == 2){  //Create teacher
            
            boolean success = super.model.CreateUser( email,  firstName,  lastName,  password,  2,  uName);
            if(success){
                return 1;
            }else{
                return 0;
            }

            //Hard code a wage for display purposes
            //Say 300$ on creation
            
            //// int uID, String uName
           // newUser = new Teacher(2,uName);
        }
        else if(userType == 1){
            
            boolean success = DBWriter_WEB.CreateUser( email,  firstName,  lastName,  password,  1,  uName);
            if(success){
                return 1;
            }else{
                return 0;
            }
            /// int uID, String uName, String firstName, String lastName 
            //newUser = new Manager(3,uName, firstName, lastName);
        }else{
            return 0;
        }
        
//        if(newUser != null){
//            super.model.dbWrite("RegisterUser", newUser);
//        }
        
        //If successful 
        
    }
    
    public int removeUser (String userName, int userID) {
        ///TODO: Define instruction
        String instruction = "";
        
        ///TODO: implement function
        super.model.dbRemove(instruction);
        /// temp return
        return 1;
    }
    
    public int registerClass(String className,  int teacherID, int skillID, String classDesc, int maxAttend) throws IOException{
        //problem, database created with no times or dates. Not sure if we can get it
         //CreateClass(String className,  int teacherID, int skillID, String classDesc, int maxAttend) throws IOException
        DBWriter_WEB.CreateClass(className,teacherID, skillID, classDesc,maxAttend  );
//        DanceClass newClass = new DanceClass();
//     
////        newClass.setStartTime(startTime);
////        newClass.setFinishTime(finishTime);
////        
//        Teacher classTeacher = new Teacher(); 
//        /// temp assignment; TODO: pull teacher from database and build here?
////        classTeacher.setuName(teacherName);
////        
//        newClass.setTeacher(classTeacher);
////        
////        ///TODO: define instruction
//        super.model.dbWrite("RegisterClass", newClass);
        
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
        
        Data teachers = super.model.dbRead("GetTeachers", "");
        String teacherList [] = new String[teachers.getData().size()];
        
        for(int i=0;i<teacherList.length;i++){
            teacherList[i] = teachers.getData().get(i).get(1);
        }
        return teacherList;
    }
    
    public int getTeacherIDFromName(String tName){
        
        CustomDataType teacher;
        teacher = super.model.unpackData(super.model.dbRead("GetUser", tName));
        int teacherID = -1;
        
        if(teacher instanceof Teacher){
            teacherID = ((Teacher)teacher).getuID();
        }    
        return teacherID;
               
    }
    
    public String[] getStudentList(){
        String studentList [] ={"Steve The Pirate","ryan"};
       
        return studentList;
    }
    
    public String[] getAllClasses(){
        /// call local function
        ArrayList<DanceClass> allClasses = viewClasses();
        String classList [] =  new String[allClasses.size()];
        
        /// fill array with class names
        for(int i=0; i< classList.length; i++){
            classList[i] = allClasses.get(i).getClassName();
        }
        
        return classList;
    }
    
    //To delete a student a teacher or a class
    public int deleteSTC( String delValue) throws IOException{ //delVar is the type and value is the value
        //delVar can be
            //"student" "teacher" "class"
            DBWriter_WEB.deleteUser(delValue);
            
            return 1;
    }
    
    //This data is related to the Reports Frame or functions
    public String[] returnStudentsInReports(){
        //I need a list of all the students inside the reports list in db
        String[] reportStudents = {"Student1","Student2"};
        
        return reportStudents;
    }
    
    public String[] caseData(String studentName){ //needs to return information related to a case based on a student name
        String [] caseData = {"Ryan the Teacher", "Dar the student","He was a bold boy"};
   
    return caseData;
    }
    
    
    
}


