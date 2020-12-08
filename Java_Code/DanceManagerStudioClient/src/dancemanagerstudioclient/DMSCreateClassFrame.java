/*
 * Project name: Dance Manager studio
 * File Created by: Ryan O'Connor
 * Description: This is the frame to create a new class
 */
package dancemanagerstudioclient;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DMSCreateClassFrame extends JFrame implements ActionListener {
    //Webserver initialisations  & other frame calls
    
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3;
    private JButton createClass, createStud, createTch, viewRpt, delClass, delStud, delTch, MonPymt, logout;
    
    //Frame Related variables
    private DanceManagerStudioClient parent;
    private DMSCreateClassFrame menuParent;
    private int ppid; 
    private String uname;
    
    
  
    
    public DMSCreateClassFrame(int pid, DanceManagerStudioClient dad, String username /* ,ApplicationLogic appLogic */){
        //Setting up the frame variables
        ppid = pid;
        uname = username;
        parent = dad;
        menuParent = this;
        
        
        //Settign up the JFrame
        setTitle("Create-Class");
        setSize(650,500);
        setLayout(new BorderLayout());
        
        //Section 1
        heading = new JLabel("Create a new class!");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
        
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(6,1));

        //Name of the class 
        nameLab = new JLabel("Firstname: ",JLabel.CENTER);
        nameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        name = new JTextField();
        name.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        name.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(nameLab);
        sec2.add(name);
        
        
        //bottom buttons
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,1));
        logout = new JButton("Logout");
        logout.addActionListener(this);
        sec3.add(logout);
        
        //JFRAME layout           
        setVisible(true);
        getContentPane().add(sec2,BorderLayout.CENTER);
        getContentPane().add(sec3,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
