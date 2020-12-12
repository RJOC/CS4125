/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;

import ModelLayer.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Jono
 */
public class DBWriter_WEB implements DBWriteBroker{

    @Override
    public void writeToDB(String instruction, Data data) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(instruction.equals("RegisterUser")){
            //unpack here
            if(data.getDataName().equals("Manager")){
                /// email, firstName, LastName, password, perID, username
                registerUser("email", data.getData().get(0).get(2), data.getData().get(0).get(3), "pword", Integer.parseInt(data.getData().get(0).get(0)), data.getData().get(0).get(1));
            }else if(data.getDataName().equals("Teacher")){
                registerUser("email", "firstName", "lastName", "pword", Integer.parseInt(data.getData().get(0).get(0)), data.getData().get(0).get(1));
            }
            
        }else if(instruction.equals("RegisterClass")){
            /// TODO: implement method.
        }
    }
    
    //code below creates a user
    private static void registerUser(String email, String fname, String sname, String pword, int perID, String uname) throws IOException{
        final String POST_PARAMS = "{\"email\":\""+ email +"\",\"firstname\":\""+ fname +"\",\"lastname\":\""+ sname +"\",\"password\":\""+ pword +"\",\"permissionID\":{\"permID\":"+ perID +"},\"username\":\""+ uname +"\"}";
        System.out.println(POST_PARAMS);
        URL obj = new URL ("http://localhost:8080/DanceSchool/webresources/web.users?");
        HttpURLConnection postConn = (HttpURLConnection) obj.openConnection();
        postConn.setRequestMethod("POST");
        postConn.setRequestProperty("Content-Type", "application/json");
        
        postConn.setDoOutput(true);
        OutputStream os = postConn.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        
        int responseCode = postConn.getResponseCode();
        System.out.println("POST Response Code : " + responseCode);
        System.out.println("POST Response Message : " + postConn.getResponseMessage());
        
        if (responseCode == 204) {
            BufferedReader in = new BufferedReader(new InputStreamReader(postConn.getInputStream()));
            String inputline;
            StringBuffer response = new StringBuffer();
            
            while((inputline = in.readLine()) != null){
                response.append(inputline);
            }   in.close();
            
            System.out.println(response.toString());
        } else {
            System.out.println("POST NOT WORKED");
        }
    }
}
