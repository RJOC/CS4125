/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;
import ModelLayer.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class DBWriter_CSV implements DBWriteBroker{
    ArrayList<String> slist;

    @Override
    public void writeToDB(String instruction, Data data) {
        String fileName = "forTest.txt";       
        //String filePath = "data" + System.getProperty("file.separator");;
        //File file=new File(filePath + fileName);
        
        if(instruction.equals("forTest")){
            // fill slist with data from input      
            slist = packData(data);        
            try {
                File file=new File(fileName);
                if(!file.exists())
                    file.createNewFile();
                    FileOutputStream out = new FileOutputStream(file);
                    StringBuffer sb = new StringBuffer();                   
                    for(int i=0; i<slist.size(); i++){
                            sb.append(slist.get(i) + "\r\n");
                	}
                    out.write(sb.toString().getBytes("utf-8"));
                    out.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    private ArrayList<String> packData(Data data){     
        ArrayList<String> packed = new ArrayList<>();      
        ArrayList<ArrayList<String>> raw = (((Data) data).getData());
        String contents;
        
        for(int i=0;i<raw.size();i++){
            contents = "";
            for(int j=0;j<raw.get(i).size();j++){
                contents = contents + raw.get(i).get(j) + ",";
            }
            packed.add(contents);
        }        
        return packed;
    }   
}
