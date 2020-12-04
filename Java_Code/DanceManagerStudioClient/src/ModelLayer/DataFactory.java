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
    
    private CustomDataType buildUser(Data data){
        ///TODO: pull data from database into a Data(); Then build users object with recived values.
        CustomDataType build;
        
        if(data.getDataName().equals("Manager")){
            
            build = new Manager(); 
            //TODO: insert Data elements
        }
        else if(data.getDataName().equals("Teacher")){

            build = new Teacher();
            //TODO: insert Data elements
        }
        else {
            //temp return 
            build = new Users();
            //TODO: insert Data elements
        }
        
        return build;  
    }
    
    private DanceClass danceClassFactory(String className){
        ///TODO: pull data from database and build into a DanceClass() data object.
        DanceClass build = new DanceClass();
        ///TODO: use data from database to build Teacher object 
        Teacher classTeacher = new Teacher(); /// buildUser(data);
        
        
        build.setTeacher(classTeacher);
        
        /// temp return
        return build;
    }
    
    private void allClassesFactory(){
        /// for
        ///     add danceClassFactory(".....")
        /// will need to know names of all classes?
        /// more thought needed for this method.
    }
}
