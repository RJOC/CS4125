/*
 * AplicationModel class: 
 * Holds data model for application
 * Uses the read/write classes that interact with the database // web service.
 */
package ModelLayer;

import java.util.ArrayList;
/**
 *
 * @author Jono
 */
public class ApplicationModel {
    
    private ArrayList<CustomDataType> dataModel;
    
    private ArrayList<DanceClass> danceClasses;
    
    private Users currentUser;
    private DBRead dbReader;
    private DBWrite dbWriter;

    public ApplicationModel() {
        this("Default");
    }
    
    public ApplicationModel(String dbType) {
        this(dbType, -1);
    }
    
    public ApplicationModel(String dbType, int uID) {
        /// could overload once more to split write and read.
        //userFactory(uID);
        //dbReadFactory(dbType);
        //dbWriteFactory(dbType);
    }
    
    private void dbReadFactory(String dbType){
        //// Build DBReader /// csv || web service (aka default)
    }
    
    private void dbWriteFactory(String dbType){
        //// Build DBReader /// csv || web service (aka default)    
    }
    
    public void dbWrite(String instruction, CustomDataType data){
    
    }
}