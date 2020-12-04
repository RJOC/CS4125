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
    
    public ApplicationModel(String dbReadWriteType) {
        /// could overload once more to split write and read.
        this.currentUser = CurrentUserSingleton.getInstance();
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