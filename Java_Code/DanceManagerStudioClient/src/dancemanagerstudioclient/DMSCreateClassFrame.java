/*
 * Project name: Dance Manager studio
 * File Created by: Ryan O'Connor
 * Description: This is the frame to create a new class
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DMSCreateClassFrame extends JFrame implements ActionListener {
    //Webserver initialisations  & other frame calls
    
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3, cnameLab, teachLab, skillLab, descLab, attdLab ;
    private JTextField cname, descr, attnd;

    private JButton back, submit;
    //Frame Related variables
    private DMSMenuFrame parent;
    private DMSCreateClassFrame menuParent;
    private int ppid, maxAttend, skillID, teacherID, success;  
    private String className,  classDes, teacherName, skillValue;
    private String[] teacherChoices;
    final JComboBox<String> teachBox;
    final JComboBox<String> skillBox;
    
    private ManagerLogic manLogic;
    
    public DMSCreateClassFrame(int pid, DMSMenuFrame dad  ,ManagerLogic manLogic ){
        this.manLogic = manLogic;
        //Setting up the frame variables
        ppid = pid;

        parent = dad;
        menuParent = this;
        
                //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                          ");
        fill2 = new JLabel(" ");
        fill3 = new JLabel(" ");
        
        //Settign up the JFrame
        setTitle("Create-Class");
        setSize(650,500);
        setLayout(new BorderLayout());
        
        //Section 1
        heading = new JLabel("Create a new class:");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
            
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(12,1));
        sec2.add(fill2);
    
        
        
       
        //Class name
        cnameLab = new JLabel("Class name: ");
        cnameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(cnameLab);
        cname = new JTextField();
        cname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        cname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(cname);
       
        //Teacher name, Teaching the class
        teachLab = new JLabel("Teacher name: ");
        teachLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(teachLab);
        

        teacherChoices = manLogic.getAllTeachers();
        teachBox = new JComboBox<String>(teacherChoices);
        sec2.add(teachBox);
        
        //How to get value from the JComboBox
        //JOptionPane.showMessageDialog(null,teachBox.getSelectedItem().toString());
        
        //Skill level
            //beginner, intermediate, advanced
        skillLab = new JLabel("Skill Level: ");
        skillLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(skillLab);
        
        String[] skillChoices = { "Beginner","Intermediate", "Hard"};
        skillBox = new JComboBox<String>(skillChoices);
        sec2.add(skillBox);
        
        //JOptionPane.showMessageDialog(null,teachBox.getSelectedItem().toString());
        
        //Description of the class
        descLab = new JLabel("Description of class: ");
        descLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(descLab);
        descr = new JTextField();
        descr.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        descr.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(descr);
                
        //Max number that can attend the class
        attdLab = new JLabel("Max attendance number: ");
        attdLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(attdLab);
        attnd = new JTextField();
        attnd.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        attnd.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(attnd);

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
           
           skillValue = skillBox.getSelectedItem().toString();
           if(skillValue.equals("Beginner")){
               skillID = 1;
           }else if(skillValue.equals("Intermediate")){
               skillID = 2;
           }else{
               skillID = 3;
           }
   
            className = cname.getText();
            teacherName = teachBox.getSelectedItem().toString();
            teacherID = manLogic.getTeacherIDFromName(teacherName);
            classDes =  descr.getText();
            maxAttend = Integer.parseInt(attnd.getText());
           
           try {
               //Create the class call here maxAttend, skillID, teacherID, className
               success = manLogic.registerClass(className, teacherID, skillID, classDes, maxAttend);
           } catch (IOException ex) {
               Logger.getLogger(DMSCreateClassFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
           if(success == 1){//it worked
                JOptionPane.showMessageDialog(null,"Class has been created!");
                parent.setVisible(true);
                dispose();
           }else{
                JOptionPane.showMessageDialog(null,"Class has not been created! There was an error!");
                parent.setVisible(true);
                dispose();
           }
                
           
       }
        
    }
}
