/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Jono
 */
public class DataFactory implements CustomDataFactory{

    @Override
    public CustomDataType buildData(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /// if(//data in data is userType){
        //  userFactory()
        // }
    }
    
    private void buildUser(Data data){
        ///TODO: pull data from database into a Data(); Then build users object with recived values.
        /*
        if(manager){
            // build and return new manager()
        }
        else if(receptionist){
        
        }
        else if(Teacher){

        }
        else if(Student) {
            
        }
        */
    }
    
    private void danceClassFactory(String className){
        ///TODO: pull data from database and build into a DanceClass() data object.
        /// will probably need a return for this one
    }
    
    private void allClassesFactory(){
        /// for
        ///     add danceClassFactory(".....")
        /// will need to know names of all classes?
        /// more thought needed for this method.
    }
}