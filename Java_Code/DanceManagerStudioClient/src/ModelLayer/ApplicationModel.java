/*
 * AplicationModel class: 
 * Holds data model for application
 * Uses the read/write classes that interact with the database // web service.
 */
package ModelLayer;

import ModelLayer.DataAccess.DBReadBroker;
import ModelLayer.DataAccess.DBWriteBroker;
import ModelLayer.DataAccess.DBWriter_CSV;
import ModelLayer.DataAccess.DBReader_WEB;
import java.util.ArrayList;
/**
 *
 * @author Jono
 */
public class ApplicationModel {
    
    private ArrayList<CustomDataType> dataModel;
    
    private ArrayList<DanceClass> danceClasses;
    
    // private Users currentUser;  is static singleton // could hold pointer here.
    private DBReadBroker dbReader;
    private DBWriteBroker dbWriter;
    private CustomDataFactory dataFactory;

    public ApplicationModel() {
        this("Default");
    }
    
    public ApplicationModel(String dbReadWriteType) {
        /// TODO: function call to Change dbTypes.
        dbReadBrokerFactory(dbReadWriteType);
        dbWriteBrokerFactory(dbReadWriteType);
        dataFactory = new DataFactory();
        danceClasses = new ArrayList<>();
    }
    
    public DanceClass getOwnClass(){
        DanceClass own = new DanceClass();
        if(!danceClasses.isEmpty()){
            own = danceClasses.get(0);
        }
        /// TODO: else if(){pass current user to database and read in class}    
        return own;
    }
    
    private void dbReadBrokerFactory(String dbType){
        
        if(dbType.equals("Default")){
            dbReader = new DBReader_WEB();
        }
        else if(dbType.equals("CSV")){
            // init new CSV_Reader
        }
    }
    
    private void dbWriteBrokerFactory(String dbType){

        if(dbType.equals("Default")){
            //dbWriter = new DBWriter_WEB();
        }
        else if(dbType.equals("CSV")){
            dbWriter = new DBWriter_CSV();
        }
    }
    
    public void dbWrite(String instruction, CustomDataType data){
        /// Pass to DBBroker
        this.dbWriter.writeToDB(instruction, data);
    }
    
    public CustomDataType dbRead(String instruction /* more arguments likely required */){
        //Temp return
        return new Data();
    }
}