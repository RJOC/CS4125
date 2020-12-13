/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;
// import DMS.darragj.server.DMSWebService;
// import DMS.darragj.server.DMSWebService_Service;

import ModelLayer.Data;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;

/**
 *
 * @author Jono, oconn
 */
public class DBReader_WEB implements DBReadBroker {

    @Override
    public Data readFromDB(String instruction, String keyWords) {
        Data data = new Data();

        if (instruction.equals("GetUser")) {
            try {
                data = getUser(keyWords);
            } catch (IOException ex) {
                Logger.getLogger(DBReader_WEB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return data;

    }

    public static boolean login(String username, String password) throws IOException {
        System.out.println("http://localhost:8080/DanceSchool/webresources/web.users/login/" + username + "/" + password + "?");
        URL URLgetRequest = new URL("http://localhost:8080/DanceSchool/webresources/web.users/login/" + username + "/" + password + "?");
        String readLine = null;
        HttpURLConnection getConn = (HttpURLConnection) URLgetRequest.openConnection();
        getConn.setRequestMethod("GET");
        getConn.setRequestProperty("Content-Type", "application/json");
        int responseCode = getConn.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(getConn.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            String result = response.toString();

            System.out.println("JSON String Result " + response);
            return true;
        } else {
            System.out.println("GET failed");
            return false;
        }
    }
    
    /// "http://localhost:8080/DanceSchool/webresources/web.users/finduser/" + username + "") getting all classes... getting all teachers 
    
    /// getting all classes
    
    /// getting all teachers == "http://localhost:9699/DanceSchool/webresources/web.users/findTeachers?" 

    private static Data getUser(String username) throws IOException {
        URL URLgetRequest = new URL("http://localhost:8080/DanceSchool/webresources/web.users/finduser/" + username + "");
        Data data = new Data();
        String readLine = null;
        HttpURLConnection getConn = (HttpURLConnection) URLgetRequest.openConnection();
        getConn.setRequestMethod("GET");
        getConn.setRequestProperty("Content-Type", "application/json");
        int responseCode = getConn.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == 200) {

            try {               
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(new URL(URLgetRequest.toString()).openStream());
                doc.getDocumentElement().normalize();
                
                NodeList nList = doc.getElementsByTagName("users");
                
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        data.getData().add(new ArrayList<>());
                        Element eElement = (Element) nNode;
                        
                        /// int uID, String uName, String firstName, String lastName
                        data.getData().get(temp).add(eElement.getElementsByTagName("id").item(0).getTextContent());
                        data.getData().get(temp).add(eElement.getElementsByTagName("username").item(0).getTextContent());
                        data.getData().get(temp).add(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        data.getData().get(temp).add(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        data.getData().get(temp).add(eElement.getElementsByTagName("permID").item(0).getTextContent());
                        
                    }
                }
                
                if(data.getData().size()==1){
                    if(data.getData().get(0).get(4).equals("3")){
                        data.setDataName("Manager");
                    }else if (data.getData().get(0).get(4).equals("2")){
                        data.setDataName("Teacher");
                    }
                }else if(data.getData().size()>1){
                    data.setDataName("UsersList");
                }else{
                    data.setDataName("Student");
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("GET failed");
        }
        
        return data;
    }
}
