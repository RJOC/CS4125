/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 *
 * @author oconn
 */
public class DMSMenuFrame extends JFrame implements ActionListener {
        //Webserver initialisations  & other frame calls
    //private TTTWebService proxy;
    //private TTTWebService_Service ttt;
    

    private DanceManagerStudioClient parent;
    private DMSMenuFrame menuParent;
    
    //Initialisations of variables needed
    private JLabel heading, fill, fill1, fill2, fill3;
    private JButton createBttn, joinBttn, userStats, leaderBttn, logout;
    private int ppid; 
    private String uname;
    
    
    
    public DMSMenuFrame(int pid, DanceManagerStudioClient dad, String username){
        ppid = pid;
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
        sec2.setLayout(new GridLayout(9,1));
        sec2.add(fill2);
        sec2.add(fill3);
        //create game
        createBttn = new JButton("Create Game");
        createBttn.addActionListener(this);
        sec2.add(createBttn);
        //join game
        joinBttn = new JButton("Join Game");
        joinBttn.addActionListener(this);
        sec2.add(joinBttn);
        //userStats
        userStats = new JButton("My Stats");
        userStats.addActionListener(this);
        sec2.add(userStats);
        //leaderboard 
        leaderBttn = new JButton("Show LeaderBoard");
        leaderBttn.addActionListener(this);
        sec2.add(leaderBttn);
        
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
       
       if(source == createBttn){
           setVisible(false);
           //try {
               //TTTNewGame ngame = new TTTNewGame(ppid,menuParent,uname);
           //} catch (IOException ex) {
               //Logger.getLogger(TTTMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
           //}
       }
       if(source == joinBttn){
           setVisible(false);
           //TTTJoinGame stats = new TTTJoinGame(ppid, menuParent, uname);
       }
       if(source == userStats){
           setVisible(false);
           //TTTUserStats stats = new TTTUserStats(ppid, menuParent, uname);
       }
       if(source == leaderBttn){
           setVisible(false);
           //TTTLeaderboardFrame leader = new TTTLeaderboardFrame(ppid, menuParent);
       }
       if(source == logout){
            parent.setVisible(true);
            dispose();
        }
    }
}
