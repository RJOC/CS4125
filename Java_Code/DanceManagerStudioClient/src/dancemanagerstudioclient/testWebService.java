/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;
import java.io.*;
import java.net.*;

/**
 *
 * @author oconn
 */
public class testWebService {

    
    public static void main(String[] args) throws IOException{
       //testWebService.testWebService("donkey@gmail.com","Jono","pp","password",3,"jono123"); 
       //testWebService.getTest("Student1");
       getTest("jono123");
       //testWebService.deleteTest();
       
    }
        
        
    private static void deleteTest() throws IOException{
        final String POST_PARAMS = "{\"username\":\"jono123\"}";
        System.out.println(POST_PARAMS);
        URL obj = new URL ("http://localhost:8080/DanceSchool/webresources/web.users/users/delete/testerjava");
        HttpURLConnection postConn = (HttpURLConnection) obj.openConnection();
        postConn.setRequestMethod("DELETE");
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
            System.out.println("Delete NOT WORKED");
        }
    }
    
    
    
    
    
//code below creates a manager user
    private static void testWebService(String email, String fname, String sname, String pword, int perID, String uname) throws IOException{
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

    private static void getTest(String username) throws IOException{
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



   
