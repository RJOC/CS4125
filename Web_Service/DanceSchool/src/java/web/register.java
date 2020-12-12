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
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 *
 * @author dcod1
 */
public class register {

    private static void parseXML(StringBuffer response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String username;
    String userID;
    String permID;
    
    public static void main(String[] args) throws IOException{
       //register.postTest(); 
       register.login("testdLogin", "test");
       //register.deleteTest();
    }
    //code below creates a manager user
    private static void postTest() throws IOException{
        final String POST_PARAMS = "{\"email\":\"testers@test.com\",\"firstname\":\"testjava\",\"lastname\":\"bean\",\"password\":\"test\",\"permissionID\":{\"permID\":2},\"username\":\"testdLogin\"}";
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

    public static boolean login(String username, String password) throws IOException{
        System.out.println("http://localhost:9699/DanceSchool/webresources/web.users/login/"+username+"/"+password+"?");
        URL URLgetRequest = new URL ("http://localhost:9699/DanceSchool/webresources/web.users?");
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
            String test = response.toString();
            
         try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(new URL(URLgetRequest.toString()).openStream());;
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("users");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Username : " 
                  + eElement
                  .getElementsByTagName("username")
                  .item(0)
                  .getTextContent());
               System.out.println("ID : " 
                  + eElement
                  .getElementsByTagName("id")
                  .item(0)
                  .getTextContent());
               System.out.println("permID : " 
                  + eElement
                  .getElementsByTagName("permID")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
            

            System.out.println("JSON String Result " + response);
            return true;
        } else {
            System.out.println("GET failed");
            return false;
        }
    }
    
        private static void deleteTest() throws IOException{
        final String POST_PARAMS = "{\"username\":\"testerjava\"}";
        System.out.println(POST_PARAMS);
        URL obj = new URL ("http://localhost:9699/DanceSchool/webresources/web.users/users/delete/testdelete");
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
}
