/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class DataFactory implements CustomDataFactory{

    @Override
    public CustomDataType buildData(Data data) {
        CustomDataType builtData = data;
         
        switch (data.getDataName()) {
        //  userFactory()
            case "Manager": builtData = buildUser(data);
                break;
            case "Teacher": builtData = buildUser(data);
                break;
            case "DanceClass": builtData = danceClassFactory(data); 
                break;
            default:
                break;
        }
        
        return builtData;
    }
    
    private CustomDataType buildUser(Data data){
        CustomDataType build;
        
        switch (data.getDataName()) {
            case "Manager":
                build = new Manager();
                //int uID, String uName, String firstName, String lastName
                ((Manager)build).setuID(Integer.parseInt(data.getData().get(0).get(0)));
                ((Manager)build).setuName(data.getData().get(0).get(1));
                ((Manager)build).setFirstName(data.getData().get(0).get(2));
                ((Manager)build).setLastName(data.getData().get(0).get(3));
                break;
            case "Teacher":
                build = new Teacher();
                ((Teacher)build).setuID(Integer.parseInt(data.getData().get(0).get(0)));
                ((Teacher)build).setuName(data.getData().get(0).get(1));
                break;
            case "UsersList":
                //// users list should not pass through this method
                //// error.
            default:
                //temp return
                build = new Users();
                break;
        }
        
        return build;  
    }
    
    private DanceClass danceClassFactory(Data data){
        DanceClass build = new DanceClass();
        
        /// Treat first part of data as teacher object and construct teacher
        data.setDataName("Teacher");
        /// Cast return to teacher and insert into DanceClass
        Teacher classTeacher = (Teacher)buildUser(data);        
        build.setTeacher(classTeacher);
        /// Set start and finish times.
        build.setStartTime(data.getData().get(1).get(0));
        build.setFinishTime(data.getData().get(1).get(1));
        
        // Loop over student list // position 0 and 1 taken by teacher and times
        for(int i=2;i<data.getData().size();i++){
            build.addStudent(buildStudent(data.getData().get(i)));
        }
        
        return build;
    }
    
    private Student buildStudent(ArrayList<String> raw){
        ///TODO: refactor to add more detail to the student class.
        Student student = new Student(raw.get(0));
        return student;
    }
}
