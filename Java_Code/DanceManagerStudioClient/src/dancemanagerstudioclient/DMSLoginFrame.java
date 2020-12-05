/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancemanagerstudioclient;


//import ttt.james.server.TTTWebService;
//import ttt.james.server.TTTWebService_Service;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author oconn
 */
public class DMSLoginFrame extends JFrame implements ActionListener{
    private JLabel instruction, usernameLab, passwordLab;
    private JTextField username;
    private JPasswordField password;
    private JButton clear, submit,back;
     //Webserver initialisations
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    private DanceManagerStudioClient parent;
    
    public DMSLoginFrame(DanceManagerStudioClient dad /* , ApplicationLogic appLogic */){
        parent = dad;
        //ttt = new TTTWebService_Service();
        //proxy = ttt.getTTTWebServicePort();
        
         //Frame Setup
        setBounds(20,20,300,200);
        setLayout(new BorderLayout());
        setTitle("Log-In");
        
        
            
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(5,2));
        usernameLab = new JLabel("Username: ",JLabel.CENTER);
        usernameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        username = new JTextField();
        username.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,20 ));
        username.setHorizontalAlignment(JTextField.CENTER);

        sec2.add(usernameLab);
        sec2.add(username);
        passwordLab = new JLabel("Password: ",JLabel.CENTER);
        passwordLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        password = new JPasswordField();
        password.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        password.setPreferredSize(new Dimension(50,50));
        password.setHorizontalAlignment(JPasswordField.CENTER);
        sec2.add(passwordLab);
        sec2.add(password);
       
        //Section 3
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,3));
        back = new JButton("Back");
        clear = new JButton("Clear");
        submit = new JButton("Submit"); 
        sec3.add(back);
        sec3.add(clear);
        sec3.add(submit);
   
        back.addActionListener(this);
        submit.addActionListener(this);
        clear.addActionListener(this);
       
         //Frame Layout
        setVisible(true);
        setSize(650,500);
        //getContentPane().add(sec1,BorderLayout.NORTH);
        getContentPane().add(sec2,BorderLayout.CENTER);
        getContentPane().add(sec3,BorderLayout.SOUTH);
        
         WindowListener exitListener = new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                parent.setVisible(true);
                dispose();
            }
        };
        addWindowListener(exitListener);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == clear){
            username.setText("");
            password.setText("");
        }
        if(source  == submit){
            String uname = username.getText();
            String pword = password.getText();
            //int value = proxy.login(uname, pword);
            switch(1){ //value needs to be put in here
                case 0:
                    JOptionPane.showMessageDialog(null,"Error connecting to database! Its our end not yours!");
                    username.setText("");
                    password.setText("");
                    username.requestFocusInWindow();
                break;
                
                case -1:
                    JOptionPane.showMessageDialog(null,"Username or Password is incorrect");
                    username.setText("");
                    password.setText("");
                break;
                
                default:
                    username.setText("");
                    password.setText("");
                    username.requestFocusInWindow();
                    setVisible(false);
                    //int pid = value;
                    DMSMenuFrame menu = new DMSMenuFrame(1, parent, "Ryan");
            }
        }
        if(source == back){
            parent.setVisible(true);
            dispose();
        }
    
    }
    
}
