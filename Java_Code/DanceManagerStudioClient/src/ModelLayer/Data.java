/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;
import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author Jono
 */
public class Data implements CustomDataType {
    private ArrayList<ArrayList<String>> data;
    private String dataName;

    public Data() {
        this.dataName = "EmptyDataObject";
        this.data = new ArrayList<ArrayList<String>>();
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
    
    @Override
    public String dataType() {
        return "Data";
    }
}
