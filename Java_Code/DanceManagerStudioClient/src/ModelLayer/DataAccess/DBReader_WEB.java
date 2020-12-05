/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;
// import DMS.darragj.server.DMSWebService;
// import DMS.darragj.server.DMSWebService_Service;

import ModelLayer.Data;

/**
 *
 * @author Jono
 */
public class DBReader_WEB implements DBReadBroker{
    
    // private DMSWebservice proxy;

    @Override
    public Data readFromDB(String instruction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        //DMS = new DMSWebService_Service();
        //proxy = DMS.getDMSWebServicePort();
        //int value = proxy.login(uname, pword);
        
        
    }
}
