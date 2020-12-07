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
        
        }
        
        /// Default return == unrecognised or not yet implemented type.
        return new Data();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Data packUsers(CustomDataType data) {
        Data packedUser = new Data();
        
        /// initialize the arraylist with empty strings
        packedUser.getData().add(new ArrayList<String>());
        //for (int i = 0; i < 5; i++) {
            //packedUser.getData().get(0).add("");
        //}
        
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
    
}
