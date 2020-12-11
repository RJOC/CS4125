/*
 * Project name: Dance Manager studio
 * File Created by: Ryan O'Connor
 * Description: Registration page to create a new user
 */
package dancemanagerstudioclient;

//import ttt.james.server.TTTWebService;
//import ttt.james.server.TTTWebService_Service;
import ApplicationLayer.ApplicationLogic;
import ApplicationLayer.ManagerLogic;


import java.awt.BorderLayout;
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
import javax.swing.JTextField;

public class DMSRegFrame extends JFrame implements ActionListener {
    //Webserver initialisations
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    //To call the last frame
    private DanceManagerStudioClient parent;
    private JTextField name, surname, username, email, password;
    private JLabel heading, nameLab, surnameLab,unameLab, emailLab, passLab;
    private JButton back, submit, clear;
    private DanceManagerStudioClient menu;
    ManagerLogic manLogic;

    public DMSRegFrame(DanceManagerStudioClient dad,  ManagerLogic manLogic ){
        this.manLogic = manLogic;
        
        parent = dad;
        //ttt = new TTTWebService_Service();
        //proxy = ttt.getTTTWebServicePort();
        
        //Frame Setup
        setTitle("Registration");
        setLayout(new BorderLayout());
        
        
        //Section 2 setting up
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(11,1));
        
        //First name data
        nameLab = new JLabel("Firstname: ",JLabel.CENTER);
        nameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        name = new JTextField();
        name.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        name.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(nameLab);
        sec2.add(name);
        
        //Surname data
        surnameLab = new JLabel("Surname: ",JLabel.CENTER);
        surnameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        surname = new JTextField();
        surname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        surname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(surnameLab);
        sec2.add(surname);
        
        //username data
        unameLab = new JLabel("Username: ",JLabel.CENTER);
        unameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        username = new JTextField();
        username.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        username.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(unameLab);
        sec2.add(username);
        
        //email data
        emailLab = new JLabel("Email: ",JLabel.CENTER);
        emailLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        email = new JTextField();
        email.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        email.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(emailLab);
        sec2.add(email);
        
        //password data
        passLab = new JLabel("Password: ",JLabel.CENTER);
        passLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        password = new JTextField();
        password.setHorizontalAlignment(JTextField.CENTER);
        password.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        sec2.add(passLab);
        sec2.add(password);
        
        
        //Section 3
        JPanel sec3 = new JPanel();
        sec3.setLayout(new GridLayout(1,3));
        back = new JButton("Back");
        back.addActionListener(this);
        sec3.add(back);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        sec3.add(clear);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        sec3.add(submit);
        
         //JFRAME LAYOUT
        getContentPane().add(sec2,BorderLayout.CENTER);
        getContentPane().add(sec3,BorderLayout.SOUTH);
        setSize(650,500);
        setVisible(true);
        
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        WindowListener exitListener = new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                parent.setVisible(true);
                dispose();
            }
            
        };
        addWindowListener(exitListener);
        
    }
    
    //Check if any of the buttons have been pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //If the back button is pressed
        if(source == back){
            parent.setVisible(true);
            dispose();
        }
        //if the clear button is pressed
        if(source == clear){
            name.setText("");
            surname.setText("");
            username.setText("");
            email.setText("");
            password.setText("");

        }
        //if the submit button is pressed
        if(source == submit){
            String nam = name.getText();
            String sur = surname.getText();
            String uname = username.getText();
            String emai = email.getText();
            String pass = password.getText();
            //Check to see if there is data in each of the fields
            if(nam.equals("")){
                JOptionPane.showMessageDialog(null, "No Name Entered");
            } else if (sur.equals("")) {
                JOptionPane.showMessageDialog(null, "No Surname Entered");
            } else if(uname.equals("")){
                JOptionPane.showMessageDialog(null, "No Username Entered");
            }else if(emai.equals("")) {
                JOptionPane.showMessageDialog(null, "No email Entered");
            } else if(!(emai.contains("@")&& emai.contains("."))) {
                JOptionPane.showMessageDialog(null, "Email entered not valid");
            } else if(pass.equals("")) {
                JOptionPane.showMessageDialog(null, "No password Entered");
            } else {
/*
*
*   Register data base call needs to go here and return a value. The values can be entered below once updated
*
*               
 */  
//This is the old call 
                int value = manLogic.registerUser("Manager", uname, nam, sur, pass, emai );
                
                switch(value){ //The variable "Value" needs to be put here

                case 0:
                    JOptionPane.showMessageDialog(null, "There was an error!");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    break;
                    
                default:
                    name.setText("");
                    surname.setText("");
                    username.setText("");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    setVisible(false);
                    DMSMenuFrame menu = new DMSMenuFrame(parent, nam,  );
                    
/*
*
*   We need a call to go to the login screen here
*
*
 */  
                    //Here we need to state to go to a new
                    //int pid = Integer.parseInt(value);
                    //DMSMenuFrame menu = new DMSMenuFrame(pid, parent, usr);

                }
            }
            
            
            
        }
    }
    
}
