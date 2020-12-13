
package dancemanagerstudioclient;

import ApplicationLayer.TeacherLogic;
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

public class DMSMenuFrameTeach extends JFrame implements ActionListener {
        //Webserver initialisations  & other frame calls
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    
    //Variables related to the frame
    private DanceManagerStudioClient parent;
    private DMSMenuFrameTeach menuParent;
    private int ppid; 
    private String uname;
    
    //Initialisations of variables needed for inside the frame
    private JLabel heading, fill, fill1, fill2, fill3;
    private JButton viewClass, cancelClass, viewWage, GenReport, logout;
    private TeacherLogic techLogic;
    
    
    public DMSMenuFrameTeach( DanceManagerStudioClient dad, String username ,TeacherLogic techLogic){
        
        
        this.techLogic = techLogic;
//setting up the frame variables

        uname = username;
        parent = dad;
        menuParent = this;
        
        
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
        sec2.setLayout(new GridLayout(6,1));
        sec2.add(fill2);
 
        
        //View Class
        viewClass = new JButton("View Classes");
        viewClass.addActionListener(this);
        sec2.add(viewClass);
        
        //Cancel Class
        cancelClass = new JButton("Cancel Class");
        cancelClass.addActionListener(this);
        sec2.add(cancelClass);
        
        //View Wage Data
        viewWage = new JButton("View Wage Data");
        viewWage.addActionListener(this);
        sec2.add(viewWage);
        
        //Generate Report
        GenReport = new JButton("Generate Report");
        GenReport.addActionListener(this);
        sec2.add(GenReport);

        
        
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
      
       
       if(source == viewClass){
           setVisible(false);
           DMSViewClasses viewClass = new DMSViewClasses();
       }
       else if(source == cancelClass){
           setVisible(false);
           DMSCancelClass cancelClass = new DMSCancelClass();
       }
       else if(source == viewWage){
           setVisible(false);
           DMSViewWage viewWage = new DMSViewWage();
       }
       else if(source == GenReport){
           setVisible(false);
           DMSGenReport generateReport = new DMSGenReport();
       }else if(source == logout){
           techLogic.logOut();
           setVisible(false);
           parent.setVisible(true);
           dispose();
           //DMSViewReportsFrame viewReports = new DMSViewReportsFrame(1,menuParent, manLogic);
       }else{
           JOptionPane.showMessageDialog(null, "Program not responding! Bringing you to login screen");
           parent.setVisible(true);
           dispose();
       }
    }
}
