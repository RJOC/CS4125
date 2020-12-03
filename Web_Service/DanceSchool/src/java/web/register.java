/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import static javax.ws.rs.client.Entity.json;

/**
 *
 * @author dcod1
 */
public class register {
    
    public static void main(String[] args) throws IOException{
       //register.postTest(); 
       register.getTest("tester");
    }
    //code below creates a manager user
    private static void postTest() throws IOException{
        final String POST_PARAMS = "{\"email\":\"testers@test.com\",\"firstname\":\"testjava\",\"lastname\":\"bean\",\"password\":\"test\",\"permissionID\":{\"permID\":3},\"username\":\"testerjava\"}";
        System.out.println(POST_PARAMS);
        URL obj = new URL ("http://localhost:9699/DanceSchool/webresources/web.users?");
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

    private static void getTest(String username) throws IOException{
        URL URLgetRequest = new URL ("http://localhost:9699/DanceSchool/webresources/web.users/finduser/" + username + "");
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
