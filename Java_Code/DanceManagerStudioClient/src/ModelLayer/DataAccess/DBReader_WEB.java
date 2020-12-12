/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;
// import DMS.darragj.server.DMSWebService;
// import DMS.darragj.server.DMSWebService_Service;

import ModelLayer.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jono, oconn
 */
public class DBReader_WEB implements DBReadBroker{
    
    // private DMSWebservice proxy;

    @Override
    public Data readFromDB(String instruction, String keyWords) {
        Data data = new Data();
        
        //DMS = new DMSWebService_Service();
        //proxy = DMS.getDMSWebServicePort();
        //int value = proxy.login(uname, pword);
        
        if(instruction.equals("GetUser")){
            try {
                
                ///TODO: implement return value from getUser() func
                
                getUser(keyWords);
            } catch (IOException ex) {
                Logger.getLogger(DBReader_WEB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return data;
        
    }
        
        public static boolean login(String username, String password) throws IOException{
        System.out.println("http://localhost:8080/DanceSchool/webresources/web.users/login/"+username+"/"+password+"?");
        URL URLgetRequest = new URL ("http://localhost:8080/DanceSchool/webresources/web.users/login/"+username+"/"+password+"?");
        String readLine = null;
        HttpURLConnection getConn = (HttpURLConnection) URLgetRequest.openConnection();
        getConn.setRequestMethod("GET");
        getConn.setRequestProperty("Content-Type", "application/json");
        int responseCode = getConn.getResponseCode();
        System.out.println(responseCode);
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(getConn.getInputStream()));
            StringBuffer response = new StringBuffer();
            while((readLine = in.readLine()) !=null){
                response.append(readLine);
            } in.close();
            String result = response.toString();

            System.out.println("JSON String Result " + response);
            return true;
        } else {
            System.out.println("GET failed");
            return false;
        }
    }
        
    private static void getUser(String username) throws IOException{
        URL URLgetRequest = new URL ("http://localhost:8080/DanceSchool/webresources/web.users/finduser/" + username + "");
        String readLine = null;
        HttpURLConnection getConn = (HttpURLConnection) URLgetRequest.openConnection();
        getConn.setRequestMethod("GET");
        getConn.setRequestProperty("Content-Type", "application/json");
        int responseCode = getConn.getResponseCode();
        System.out.println(responseCode);
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(getConn.getInputStream()));
            StringBuffer response = new StringBuffer();
            while((readLine = in.readLine()) !=null){
                response.append(readLine);
            } in.close();
            String result = response.toString();

            System.out.println("JSON String Result " + result);
            
        } else {
            System.out.println("GET failed");
        }
    }
}
