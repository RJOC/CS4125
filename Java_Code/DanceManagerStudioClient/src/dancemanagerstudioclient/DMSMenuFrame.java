/*
 * Project name: Dance Manager studio
 * File Created by: Ryan O'Connor
 * Description: Main menu page that is access after inital login
 */
package dancemanagerstudioclient;


//import ttt.james.server.TTTWebService;
//import ttt.james.server.TTTWebService_Service;
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

public class DMSMenuFrame extends JFrame implements ActionListener {
        //Webserver initialisations  & other frame calls
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    
    //Variables related to the frame
    private DanceManagerStudioClient parent;
    private DMSMenuFrame menuParent;
    private int ppid; 
    private String uname;
    
    //Initialisations of variables needed for inside the frame
    private JLabel heading, fill, fill1, fill2, fill3;
    private JButton createClass, createStud, createTch, viewRpt, delClass, delStud, delTch, MonPymt, logout;
    private ManagerLogic manLogic;
    
    
    public DMSMenuFrame( DanceManagerStudioClient dad, String username ,ManagerLogic manLogic){
        this.manLogic = manLogic;
//setting up the frame variables

        uname = username;
        parent = dad;
        menuParent = this;
        
//Proxy for webservice
        //ttt = new TTTWebService_Service();
        //proxy = ttt.getTTTWebServicePort();
        
        //JFrame Setup
        setTitle("Main-Menu");
        setSize(650,500);
        setLayout(new BorderLayout());
        
        //Fill variables
        fill = new JLabel("                           ");
        fill1 = new JLabel("                           ");
        fill2 = new JLabel(" ");
        fill3 = new JLabel(" ");
        
        
        //Section 1
        heading = new JLabel("Welcome "+ username);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        add(heading,BorderLayout.NORTH);
        add(fill, BorderLayout.WEST);
        add(fill1, BorderLayout.EAST);
        
        //Section 2
        JPanel sec2 = new JPanel();
        sec2.setLayout(new GridLayout(6,2));
        sec2.add(fill2);
        sec2.add(fill3);
        
        //create Class
        createClass = new JButton("Create Class");
        createClass.addActionListener(this);
        sec2.add(createClass);
        
        //Create Student
        createStud = new JButton("Create Student");
        createStud.addActionListener(this);
        sec2.add(createStud);
        
        //Create Teacher
        createTch = new JButton("Create Teacher");
        createTch.addActionListener(this);
        sec2.add(createTch);
        
        //View Reports 
        viewRpt = new JButton("View Reports");
        viewRpt.addActionListener(this);
        sec2.add(viewRpt);
        
        //Delete Class
        delClass = new JButton("Delete Class");
        delClass.addActionListener(this);
        sec2.add(delClass);
        
        //Delete student
        delStud = new JButton("Delete Student");
        delStud.addActionListener(this);
        sec2.add(delStud);
        
        //Delete Teacher
        delTch = new JButton("Delete Teacher");
        delTch.addActionListener(this);
        sec2.add(delTch);
        
        //Monitor Payments
        MonPymt = new JButton("Monitor Payments");
        MonPymt.addActionListener(this);
        sec2.add(MonPymt);
        
        
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
      
       
       if(source == createClass){
           setVisible(false);
           DMSCreateClassFrame crtClass = new DMSCreateClassFrame(1, menuParent, manLogic);
       }
       else if(source == createStud){
           setVisible(false);
           DMSCreateStudentFrame crtStudent = new DMSCreateStudentFrame(1, menuParent, manLogic);

       }
       else if(source == createTch){
           setVisible(false);
           DMSCreateTeacherFrame crtTeach = new DMSCreateTeacherFrame(1, menuParent, manLogic);

       }
       else if(source == viewRpt){
           setVisible(false);
           DMSViewReportsFrame viewReports = new DMSViewReportsFrame(1,menuParent, manLogic);
       }
       else if(source == delClass){
           setVisible(false);
           DMSDeleteFrames delClass = new DMSDeleteFrames(1,"class", menuParent, manLogic);
       }
       else if(source == delStud){
           setVisible(false);
           DMSDeleteFrames delStudent = new DMSDeleteFrames(1,"student", menuParent, manLogic);

       }
       else if(source == delTch){
           setVisible(false);
           DMSDeleteFrames delTeacher = new DMSDeleteFrames(1,"teacher", menuParent, manLogic);
       }
       else if(source == MonPymt){
           setVisible(false);
           DMSMonitorPayments viewPayments = new DMSMonitorPayments(1,menuParent, manLogic);
       }
       else if(source == logout){
            manLogic.logOut();
            parent.setVisible(true);
            dispose();
        }
       else{
           JOptionPane.showMessageDialog(null, "Program not responding! Bringing you to login screen");
           parent.setVisible(true);
           dispose();
       }
    }
}
