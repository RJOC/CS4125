/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class DMSCreateStudentFrame extends JFrame implements ActionListener{
 
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3,unameLab, fnameLab, snameLab,pwordLab, emailLab;
    private JTextField usrname, fname, sname,email;
    private JPasswordField pword;
    private JButton back, submit;
    
    //Frame Related variables
    private DMSMenuFrame parent;
    private DMSCreateTeacherFrame menuParent;
    private int ppid; 
    private String uname;
   
    public DMSCreateTeacherFrame(int pid, DMSMenuFrame dad/* ,ApplicationLogic appLogic */){
        ppid = pid;
        parent = dad;
        menuParent = this;
        
        
        
        
    }
    
    
    
    
}
