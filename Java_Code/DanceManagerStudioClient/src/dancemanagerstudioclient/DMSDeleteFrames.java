/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;

import ApplicationLayer.ManagerLogic;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
/**
 *
 * @author oconn
 */
public class DMSDeleteFrames extends JFrame implements ActionListener{
    
    private DMSMenuFrame parent;
    private DMSDeleteFrames menuParent;
    private int ppid; 
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3;
    private JButton back, submit;
    private JLabel teachLab;
    private String delLabel, deletedVar,valueSelected, message;
    private String[] delChoices;
    private ManagerLogic manLogic;
    private int success;
    private final JComboBox<String> teachBox;
    
     public DMSDeleteFrames(int pid, String delVar, DMSMenuFrame dad , ManagerLogic manLogic ){
        this.manLogic = manLogic;
         
         
        //Setting up the frame variables
        ppid = pid;
        parent = dad;
        menuParent = this;
       
        //Variable assigned for last joptionpane
        deletedVar = delVar;
         //This is to sort out where the call has came from!
         //It sets variables appropiately
        if(delVar == "student"){
            delLabel = "Select a student to delete:";
            delChoices = manLogic.getStudentList();
            //delChoices = { "Magic Mat","BigDongDar", "RYANSMALLPP","JONO","CHOICE 5","CHOICE 6"};
        }else if(delVar == "teacher"){
            delLabel = "Select a teacher to delete:";
            delChoices = manLogic.getAllTeachers();
        }else if(delVar == "class"){
            delLabel = "Select a class to delete";
            delChoices = manLogic.getAllClasses();
        }else{
            //There has been an error
        }
        
        
        
    //Frame development
        //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                          ");
        fill2 = new JLabel(" ");
        fill3 = new JLabel(" ");
         
        //Settign up the JFrame
        setTitle("Create-Teacher");
        setSize(650,500);
        setLayout(new BorderLayout());

         //Section 1
        heading = new JLabel("Delete "+delVar+" from system:");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
        
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(5,1));
        sec2.add(fill2);
        
        //Teacher name, Teaching the class
        teachLab = new JLabel(delLabel);
        teachLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(teachLab);
  
        teachBox = new JComboBox<String>(delChoices);
        sec2.add(teachBox);
        
        
        
        
        //Section 3
        //bottom buttons
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,2));
        back = new JButton("Back");
        back.addActionListener(this);
        sec3.add(back);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        sec3.add(submit);
       
        
        
        
                 
        setVisible(true);
        getContentPane().add(sec2,BorderLayout.CENTER);
        getContentPane().add(sec3,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
 
  
            WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setVisible(true);
                dispose();
            }
        };
        addWindowListener(exitListener);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       
       if(source == back){
           parent.setVisible(true);
           dispose();
       }else if(source == submit){
           valueSelected = teachBox.getSelectedItem().toString();
           try {
               success = manLogic.deleteSTC(valueSelected);
           } catch (IOException ex) {
               Logger.getLogger(DMSDeleteFrames.class.getName()).log(Level.SEVERE, null, ex);
           }
            if(success == 1){//it worked
                message = valueSelected + " has been deleted!";
                JOptionPane.showMessageDialog(null,message);
                parent.setVisible(true);
                dispose();
           }else{
                message = deletedVar + " has not been created! There was an error!";
                JOptionPane.showMessageDialog(null,message);
                parent.setVisible(true);
                dispose();
           }
           

       }
        
    }
    
}
