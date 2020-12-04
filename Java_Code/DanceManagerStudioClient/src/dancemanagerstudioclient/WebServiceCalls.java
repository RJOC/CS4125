/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ttt.james.setver.TTTWebService;
        import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
public class WebServiceCalls {
 public static void main(String[] args) throws ClientProtocolException, IOException {
  HttpClient client = new DefaultHttpClient();
  HttpPost post = new HttpPost('http://localhost:8080/DanceSchool/webresources/web.users?');
  List nameValuePairs = new ArrayList(1);
  nameValuePairs.add(new BasicNameValuePair('name', 'value')); //you can as many name value pair as you want in the list.
  post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
  HttpResponse response = client.execute(post);
  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  String line = '';
  while ((line = rd.readLine()) != null) {
   System.out.println(line);
  }
 }
}

