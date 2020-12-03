/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dance_entity;

import java.io.IOException;
import java.io.BufferedReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author dcod1
 */
public class testRequestUser {
    public static void main(String [] args) throws IOException {
    testRequestUser.getRequest();
    testRequestUser.postRequest();
    }

    private static void getRequest() throws IOException{
        URL urlForGetRequest = new URL("http://localhost:9699/DanceManager/webresources/com.dance_entity.users?fields=username");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("accept", "application/json");
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in .readLine()) !=null){
                response.append(readLine);
                } in.close();
                System.out.println("JSON result:"+ response.toString());
            }
    }

    private static void postRequest()throws IOException{
        
    }
}
