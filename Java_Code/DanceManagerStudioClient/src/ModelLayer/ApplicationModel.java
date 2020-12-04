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
        dbReadFactory(dbReadWriteType);
        dbWriteFactory(dbReadWriteType);
        // needs different constructors passing in.
        //this.currentUser = CurrentUserSingleton.getInstance();
    }
    
    private void dbReadFactory(String dbType){
        //// Build DBReader /// csv || web service (aka default)
        if(dbType.equals("Default")){
            dbReader = new DBReader_WEB();
        }
        else if(dbType.equals("CSV")){
            // init new CSV_Reader
        }
    }
    
    private void dbWriteFactory(String dbType){
        //// Build DBReader /// csv || web service (aka default)
        if(dbType.equals("Default")){
            //dbWriter = new DBWriter_WEB();
        }
        else if(dbType.equals("CSV")){
            dbWriter = new DBWriter_CSV();
        }
    }
    
    public void dbWrite(String instruction, CustomDataType data){
    
    }
    
    public CustomDataType dbRead(String instruction){
        //Temp return
        return new Data();
    }
}