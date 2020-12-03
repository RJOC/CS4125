/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;
import java.lang.StringBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jono
 */
public class DBWriter_CSV implements DBWrite{
    ArrayList<String> slist;

    @Override
    public void writeToDB(String instruction, CustomDataType data) {
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
                    	//sb.append(slist.get(i) + System.getProperty("line.separator"));
                            sb.append(slist.get(i) + "\r\n");
                	}
                    out.write(sb.toString().getBytes("utf-8"));
                    out.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    /// Temp public, for testing 
    public ArrayList<String> packData(CustomDataType data){
        
        ArrayList<String> packed = new ArrayList<String>();
        
        /// this is messy :/
        if(data instanceof Data){
           String contents = "";
           ArrayList<ArrayList<String>> raw = (((Data) data).getData());
           
            for(int i=0;i<raw.size();i++){
                for(int j=0;j<raw.get(i).size();j++){
                contents = contents + raw.get(i).get(j) + ",";
                }
            }
        }
        return packed;
    }
    
}
