/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

/**
 *
 * @author Jono
 */
public class Student {
    String uName;
    //TODO: add medical details
    //TODO: add emergency contact details
    
    public Student(){
        this("Default Student");
    }

    public Student(String uName) {
        this.uName = uName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
