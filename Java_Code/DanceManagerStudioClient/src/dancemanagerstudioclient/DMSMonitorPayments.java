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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DMSMonitorPayments extends JFrame implements ActionListener {
    //Frame variables
    private DMSMenuFrame parent;
    private DMSMonitorPayments menuParent;
    private int ppid; 
    
    //Variable declopations
    private JLabel heading, fill, fill1, fill2, fill3, choiceLab, person ;
    private JComboBox<String> choiceBox, teacherBox, studentBox;
    private JButton back, submit;
    private String choice;
    private String[] wageRpayment = { "Student Payments","Teacher Wages"};
    private String[] teachers = { "Teacher1","Teacher2"};
    private String[] students = { "students1","students2"};
    
    public DMSMonitorPayments(int pid, DMSMenuFrame dad/* ,ApplicationLogic appLogic */){
        //Frame variable
        ppid = pid;
        parent = dad;
        menuParent = this;
        
    //Frame development
        //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                          ");
        fill2 = new JLabel(" ");
        
        
        //Settign up the JFrame
        setTitle("View Report:");
        setSize(650,500);
        setLayout(new BorderLayout());
        
        //Section 1
        heading = new JLabel("Payments & Wages:");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
        
        
         //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(9,1));
        
        //TeaherInvolved
        choiceLab = new JLabel("Teacher wage or Student Payments? ");
        choiceLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(choiceLab);
        
        //Student Name combination box thing
        choiceBox = new JComboBox<String>(wageRpayment);
        sec2.add(choiceBox);
        choiceBox.addActionListener(this);
        
        //Person Choice
        person = new JLabel("Select person:");
        person.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(person);
        teacherBox = new JComboBox<String>(teachers);
        sec2.add(teacherBox);
        teacherBox.addActionListener(this);
        
        studentBox = new JComboBox<String>(students);
        sec2.add(studentBox);
        studentBox.addActionListener(this);
        
        
        
        //Section 3
        //bottom buttons
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,2));
        back = new JButton("Back");
        back.addActionListener(this);
        sec3.add(back);
        
        //Setting all the fields not visiable to clean page
        person.setVisible(false);
        teacherBox.setVisible(false);
        studentBox.setVisible(false);
        
        
        
        
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
       }else if(source == choiceBox){
            JComboBox cb = (JComboBox)e.getSource();
            choice = (String)cb.getSelectedItem();
            if(choice == "Student Payments"){
                studentOptions();
            }else if(choice == "Teacher Wages"){
                teacherOptions();
            }else{
                //An error has occured
            }
       }else if(source ==choiceBox2){
           
       }

    }
    
     protected void studentOptions() {
            person.setVisible(true);
            person.setText("Select a student:");
            
            teacherBox2.setVisible(true);
                    
        }
     
          protected void teacherOptions() {
            person.setVisible(true);
            person.setText("Select a teacher:");
            
            teacherBox.setVisible(true);   
        }
    
}
