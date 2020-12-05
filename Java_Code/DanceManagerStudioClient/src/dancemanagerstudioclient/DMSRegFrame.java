/*
 * This is the registration screen to create a new account
 */
package dancemanagerstudioclient;

//import ttt.james.server.TTTWebService;
//import ttt.james.server.TTTWebService_Service;
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

/**
 *
 * @author RJ
 */
public class DMSRegFrame extends JFrame implements ActionListener {
    //Webserver initialisations
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    //To call the last frame
    private DanceManagerStudioClient parent;
    private JTextField name, surname, email, password;
    private JLabel heading,nameLab, surnameLab, emailLab, passLab;
    private JButton back, submit, clear;
    private DanceManagerStudioClient menu;
    

    public DMSRegFrame(DanceManagerStudioClient dad /* ManagerLogic appLogic */){
        parent = dad;
        //ttt = new TTTWebService_Service();
        //proxy = ttt.getTTTWebServicePort();
        
        //Frame Setup
        setTitle("Registration");
        setLayout(new BorderLayout());
        
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(9,1));
        nameLab = new JLabel("Firstname: ",JLabel.CENTER);
        nameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        name = new JTextField();
        name.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        name.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(nameLab);
        sec2.add(name);
        surnameLab = new JLabel("Surname: ",JLabel.CENTER);
        surnameLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        surname = new JTextField();
        surname.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        surname.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(surnameLab);
        sec2.add(surname);
        emailLab = new JLabel("Email: ",JLabel.CENTER);
        emailLab.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        email = new JTextField();
        email.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        email.setHorizontalAlignment(JTextField.CENTER);
        sec2.add(emailLab);
        sec2.add(email);
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == back){
            parent.setVisible(true);
            dispose();
        }
        if(source == clear){
            email.setText("");
            password.setText("");
        }
        if(source == submit){
            String nam = name.getText();
            String sur = surname.getText();
            String usr = email.getText();
            String pas = password.getText();
            
            if(nam.equals("")){
                JOptionPane.showMessageDialog(null, "No Name Entered");
            } else if (sur.equals("")) {
                JOptionPane.showMessageDialog(null, "No Surname Entered");
            } else if(usr.equals("")) {
                JOptionPane.showMessageDialog(null, "No email Entered");
            } else if(pas.equals("")) {
                JOptionPane.showMessageDialog(null, "No password Entered");
            } else {
                //String value = proxy.register(usr, pas, nam, sur); Fix this when the proxy is setup
                
                switch(""){ //The variable "Value" needs to be put here
                case "ERROR-REPEAT":
                    JOptionPane.showMessageDialog(null, "The email already exists");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    break;
                    
                case "ERROR-INSERT":
                    JOptionPane.showMessageDialog(null, "Could not add data to user table!");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    break;
                    
                case "ERROR-RETRIEVE":
                    JOptionPane.showMessageDialog(null, "Could not retrieve the newly inserted data from the users table!");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    break;
                    
                case "ERROR-DB":
                    JOptionPane.showMessageDialog(null, "Could not find the data base!");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    break;
                    
                default:
                    name.setText("");
                    surname.setText("");
                    email.setText("");
                    password.setText("");
                    email.requestFocusInWindow();
                    setVisible(false);
                    //Here we need to state to go to a new
                    //int pid = Integer.parseInt(value);
                    //DMSMenuFrame menu = new DMSMenuFrame(pid, parent, usr);

                }
            }
            
            
            
        }
    }
    
}
