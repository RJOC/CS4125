/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;
import java.util.ArrayList;
/**
 *
 * @author Jono
 */
public class DanceClass implements CustomDataType {
    private ArrayList<ArrayList<String>> studentList;
    private String startTime;
    private String finishTime;
    private String teacherName;
    private int teacherID;
    ///TODO: add rest of relevant fields and Gen get/set

    @Override
    public String dataType() {
        return "DanceClass";
    }
    
}
