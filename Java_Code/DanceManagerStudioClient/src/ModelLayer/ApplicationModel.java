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
import ModelLayer.DataAccess.DBWriter_WEB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jono
 */
public class ApplicationModel {
    
    // private ArrayList<CustomDataType> dataModel;
    
    private ArrayList<DanceClass> danceClasses;
    private DBReadBroker dbReader;
    private DBWriteBroker dbWriter;
    private CustomDataFactory dataFactory;
    private CustomDataPacker dataPacker;

    public ApplicationModel() {
        this("Default");
    }
    
    public ApplicationModel(String dbReadWriteType) {
        /// TODO: function call to Change dbTypes.
        dbReadBrokerFactory(dbReadWriteType);
        dbWriteBrokerFactory(dbReadWriteType);
        dataPacker = new DataPacker();
        dataFactory = new DataFactory();
        danceClasses = new ArrayList<>();
    }
    
    public ArrayList<DanceClass> getDanceClasses() {
        return danceClasses;
    }
      
    public DanceClass viewClass(int index){
        if(danceClasses.size() > index){
            /// TODO: refactor to pass by value.
            return danceClasses.get(index);
        }
        return new DanceClass();
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
            dbWriter = new DBWriter_WEB();
        }
        else if(dbType.equals("CSV")){
            dbWriter = new DBWriter_CSV();
        }
    }
    
    public void dbWrite(String instruction, CustomDataType data){
        try {
            /// Pack data into a Data object, and Pass to DBBroker
            this.dbWriter.writeToDB(instruction, dataPacker.packData(data));
        } catch (IOException ex) {
            Logger.getLogger(ApplicationModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int dbRemove(String instruction){
        /// temp return for compile
        return 1;
    }
    
    public Data dbRead(String instruction, String keyWords){
        //Temp return
        return dbReader.readFromDB(instruction, keyWords);
    }
    
    public boolean CreateUser(String email, String fname, String sname, String pword, int perID, String uname) throws IOException{
        return ((DBWriter_WEB)dbWriter).CreateUser(email, fname, sname, pword, perID, uname);
    }
    
    public CustomDataType unpackData(Data data){
        return dataFactory.buildData(data);
    }
    
    public void readInClasses(){
        if(CurrentUserSingleton.getInstance() instanceof Manager){
            /// read in ALL classes and add to danceClasses
        }
        else{
            /// use CurrentUserSingleton.getInstance().getuName() to get classes associated with teacher.
        }
    }
}