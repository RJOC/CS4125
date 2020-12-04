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
    private ArrayList<Student> studentList;
    private String startTime;
    private String finishTime;
    private Teacher teacher;

    public DanceClass() {
        studentList = new ArrayList<Student>();
    }
    
    public void addStudent(Student student){
        studentList.add(student);
        ///TODO: implement student compareTo() and sort()
    }
    
    public void removeStudent(String studentName){
        /// TODO: implement remove method
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String dataType() {
        return "DanceClass";
    }
    
}
