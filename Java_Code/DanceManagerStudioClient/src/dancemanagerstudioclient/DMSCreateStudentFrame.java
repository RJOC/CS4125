/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;

import ApplicationLayer.ApplicationLogic;
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


public class DMSCreateStudentFrame extends JFrame implements ActionListener{
 
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3,unameLab, fnameLab, snameLab,pwordLab, emailLab;
    private JTextField usrname, fname, sname,email;
    private JPasswordField pword;
    private JButton back, submit;
    
    //Frame Related variables
    private DMSMenuFrame parent;
    private DMSCreateStudentFrame menuParent;
    private int ppid, success; 
    private String uName, fName, lName, pWord, maile;
    private ApplicationLogic appLogic;
   
    public DMSCreateStudentFrame(int pid, DMSMenuFrame dad ,ApplicationLogic appLogic ){
        this.appLogic = appLogic;
        //Frame configuration
        ppid = pid;
        parent = dad;
        menuParent = this;
        
                        //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                          ");
        fill2 = new JLabel(" ");
        fill3 = new JLabel(" ");
        
        //Settign up the JFrame
        setTitle("Create-Student");
        setSize(650,500);
        setLayout(new BorderLayout());
        
          //Section 1
        heading = new JLabel("Create a new student:");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
            
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(12,1));
        sec2.add(fill2);
    
        //Teachers Username
        unameLab = new JLabel("Student username: ");
        unameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(unameLab);
        usrname = new JTextField();
        usrname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        usrname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(usrname);
       
        //Teacher First name
        fnameLab = new JLabel("Student first name: ");
        fnameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(fnameLab);
        fname = new JTextField();
        fname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        fname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(fname);
       
        //Teacher second name
        snameLab = new JLabel("Student second name: ");
        snameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(snameLab);
        sname = new JTextField();
        sname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        sname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(sname);
        
        
        
        //Teacher Password
        pwordLab = new JLabel("Student password: ");
        pwordLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(pwordLab);
        pword = new JPasswordField();
        pword.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        pword.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(pword);
        
        
        //Teacher email
        emailLab = new JLabel("Student email: ");
        emailLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(emailLab);
        email = new JTextField();
        email.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        email.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(email);


        sec2.add(fill3);
        
        
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
        
        //JFRAME layout           
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
          
            uName = usrname.getText();
            fName =fname.getText();
            lName = sname.getText();
            pWord = pword.getText();
            maile = email.getText();
           try {
               success = appLogic.registerStudent(uName, fName, lName, pWord, maile);
           } catch (IOException ex) {
               Logger.getLogger(DMSCreateStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            if(success == 1){//it worked
                JOptionPane.showMessageDialog(null,"Student has been created!");
                parent.setVisible(true);
                dispose();
           }else{
                JOptionPane.showMessageDialog(null,"Student has not been created! There was an error!");
                parent.setVisible(true);
                dispose();
           }
       }
        
    }
    
    
}
