/*
 * AplicationModel class: 
 * Holds data model for application
 * Uses the read/write classes that interact with the database web service.
 */
package dancemanagerstudioclient;
import java.util.ArrayList;
/**
 *
 * @author Jono
 */
public class ApplicationModel {
    
    private ArrayList<CustomDataType> dataModel;
    private Users currentUser;
    //private DBReader;
    //private DBWriter;

    public ApplicationModel() {
        this("Default");
    }
    
    public ApplicationModel(String dbType) {
        //// this should call a DBReader && DBWiter Factory with the type param.
        //// TODO:
    }
    
    private void dbReadFactory(String dbType){
        //// Build DBReader /// csv || web service (aka default)
       
    }
    
    private void userFactory(int uID) {
        ///TODO: pull data from database into a Data(); Then build users object with recived values.

        //// temp return for compile 
        this.currentUser = new Users();
    }
    
    private void danceClassFactory(String className){
        ///TODO: pull data from database and build into a DanceClass() data object.
        /// will probably need a return for this one
    }
    
    private void allClassesFactory(){
        /// for
        ///     add danceClassFactory(".....")
        /// will need to know names of all classes? 
    }
}
