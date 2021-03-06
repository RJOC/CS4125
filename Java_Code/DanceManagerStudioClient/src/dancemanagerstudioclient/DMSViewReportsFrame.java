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
import javax.swing.JFrame;
import javax.swing.*;
    

public class DMSViewReportsFrame extends JFrame implements ActionListener {
//Frame variables
    private DMSMenuFrame parent;
    private DMSViewReportsFrame menuParent;
    private int ppid; 
    
    
    //Other variable 
    private JLabel heading, fill, fill1, fill2, fill3,tnameLab,tname,snameLab,sname,descLab,desc;
    private JLabel teachLab;
    private String delLabel, studentName, updatedTname, updatedSname, updatesDesc;
    private JButton back, submit;
    private String[] studentList, updateLabels;
    private JComboBox<String> reportBox;
    private ManagerLogic manLogic;
    
    

    public DMSViewReportsFrame(int pid, DMSMenuFrame dad ,ManagerLogic manLogic ){
        this.manLogic = manLogic;
        //Frame variable
        ppid = pid;
        parent = dad;
        menuParent = this;
    
    //Frame development
        //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                           ");
        fill2 = new JLabel(" ");

         
        //Settign up the JFrame
        setTitle("View Report:");
        setSize(650,500);
        setLayout(new BorderLayout());

         //Section 1
        heading = new JLabel("Select report From list:");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
        
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(9,1));

        //Teacher name, Teaching the class
        teachLab = new JLabel(delLabel);
        teachLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(teachLab);
        
        studentList = manLogic.returnStudentsInReports();
        //Student Name combination box thing
        reportBox = new JComboBox<String>(studentList);
        sec2.add(reportBox);
        reportBox.addActionListener(this);
         
        //TeaherInvolved
        tnameLab = new JLabel("Reporting teacher: ");
        tnameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(tnameLab);
        tname = new JLabel("temp");
        tname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        tname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(tname);
        
        //StudentInvolved
        snameLab = new JLabel("Student involved: ");
        snameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(snameLab);
        sname = new JLabel("temp");
        sname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        sname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(sname);
        //Description of report
        descLab = new JLabel("Description of report: ");
        descLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        sec2.add(descLab);
        desc = new JLabel("temp");
        desc.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        desc.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(desc);
        
        
        
        //Section 3
        //bottom buttons
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,2));
        back = new JButton("Back");
        back.addActionListener(this);
        sec3.add(back);

       
        //Setting all the fields not visiable to clean page
        tnameLab.setVisible(false);
        tname.setVisible(false);
        snameLab.setVisible(false);
        sname.setVisible(false);
        descLab.setVisible(false);
        desc.setVisible(false);
        
        
                 
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
        if(source == reportBox){
            JComboBox cb = (JComboBox)e.getSource();
            studentName = (String)cb.getSelectedItem();
            updateLabels(studentName);
            tnameLab.setVisible(true);
            tname.setVisible(true);
            snameLab.setVisible(true);
            sname.setVisible(true);
            descLab.setVisible(true);
            desc.setVisible(true);
            //       tnameLab,tname,snameLab,sname,descLab,desc
            
            
        }else if(source == back){
           parent.setVisible(true);
           dispose();
       }
//       else if(source == submit){
//           //Create the class call here
//           JOptionPane.showMessageDialog(null,deletedVar + " has been deleted!");
//           parent.setVisible(true);
//           dispose();
//       }
        
    }
    
        protected void updateLabels(String name) {
            updateLabels = manLogic.caseData(studentName);
            updatedTname = updateLabels[0];
            updatedSname = updateLabels[1];
            updatesDesc = updateLabels[2];
            
            tname.setText(updatedTname);
            sname.setText(updatedSname);
            desc.setText(updatesDesc);
                    
        }
}
