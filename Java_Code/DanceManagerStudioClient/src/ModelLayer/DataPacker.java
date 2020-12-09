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
public class DataPacker implements CustomDataPacker {

    @Override
    public Data packData(CustomDataType data) {
        
        if(data instanceof Users){
            return packUsers(data);
        }
        else if(data instanceof DanceClass){
            return packDanceClass((DanceClass)data);
        }       
        /// Default return == unrecognised or not yet implemented type.
        return new Data();
    }
    
    private Data packUsers(CustomDataType data) {
        Data packedUser = new Data();
        
        /// initialize the arraylist
        packedUser.getData().add(new ArrayList<>());
        
        if(data instanceof Manager){
            packedUser.setDataName("Manager");
            /// pack manager
            /// int uID, String uName, String firstName, String lastName
            packedUser.getData().get(0).add("" + ((Manager)(data)).getuID());
            packedUser.getData().get(0).add(((Manager)(data)).getuName());
            packedUser.getData().get(0).add(((Manager)(data)).getFirstName());
            packedUser.getData().get(0).add(((Manager)(data)).getLastName());          
        }
        else if(data instanceof Teacher){
            packedUser.setDataName("Teacher");
            
            packedUser.getData().get(0).add("" + ((Teacher)(data)).getuID());
            packedUser.getData().get(0).add(((Teacher)(data)).getuName());
        }
        else{
            /// Default User 
        }       
        return packedUser;
    }
    
    private Data packDanceClass(DanceClass data){
        
        Data packedDClass = new Data();
        packedDClass.setDataName("DanceClass");
        /// +2 arrays for: Teacher, times && name.  all other lines are students.      
        for (int i = 0; i < data.getStudentList().size() + 2; i++) {
            packedDClass.getData().add(new ArrayList<>());
        }
        /// Pack Teacher 
        packedDClass.getData().get(0).add("" + data.getTeacher().getuID());
        packedDClass.getData().get(0).add(data.getTeacher().getuName());
        
        /// Pack Times
        packedDClass.getData().get(1).add(data.getStartTime());
        packedDClass.getData().get(1).add(data.getFinishTime());
        
        /// Pack Students     
        for (int i = 0; i < data.getStudentList().size(); i++) {
            /// first two lines taken -> i + 2
            packedDClass.getData().get(i + 2).add(data.getStudentList().get(i).getuName());
        }
        
        return packedDClass;
    }  
}
