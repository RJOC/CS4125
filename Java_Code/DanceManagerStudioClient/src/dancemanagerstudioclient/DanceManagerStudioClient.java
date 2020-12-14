/*
 * Project name: Dance Manager studio
 * File Created by: Ryan O'Connor
 * Description: This file is the frame for the main page of the application
 */
package dancemanagerstudioclient;


import ApplicationLayer.ApplicationLogic;
import ApplicationLayer.ManagerLogic;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.*;


/**
 * Start Date: 09/11/2019
 * @author Ryan O'Connor
 */
public class DanceManagerStudioClient extends JFrame implements ActionListener{
        //Webserver initialisations
    //JButton initialisations because they are referenced in this whole class
    private JButton regBttn , loginBttn;
   
    private ApplicationLogic appLogic;
    
    public DanceManagerStudioClient( ApplicationLogic appLogic ) throws IOException{
        
        this.appLogic = appLogic;

        
        //Frame Setup
        setTitle("The Ani Mje  Special");
        setLayout(new BorderLayout());
        
        
        //Section 1
            JPanel sec1 = new JPanel();
            sec1.setLayout(new BorderLayout());
            JLabel heading = new JLabel("Dance Manager Studio",JLabel.CENTER);
            JLabel des = new JLabel("This software is brought to you by The Ani Mje Special!", JLabel.CENTER);
            heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
            des.setVerticalAlignment(JLabel.TOP);
            des.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            sec1.add(heading, BorderLayout.NORTH);
            sec1.add(des,BorderLayout.CENTER);
            
        //Section 2
            JPanel sec2 = new JPanel();
            BufferedImage Pic = ImageIO.read(this.getClass().getResource("dance.png"));
            JLabel Icon = new JLabel(new ImageIcon(Pic));
            sec2.add(Icon);
            sec2.setSize(400,400);
            
        //Section 3
            JPanel sec3 = new JPanel();
            sec3.setLayout(new GridLayout(1,2));
            loginBttn = new JButton("Login");
            loginBttn.addActionListener(this);
//            regBttn = new JButton("Register Manager");
//            regBttn.addActionListener(this);
//            regBttn.setSize(50,50);
//            sec3.add(regBttn);
            sec3.add(loginBttn);

                
        //JFRAME LAYOUT
        getContentPane().add(sec1,BorderLayout.NORTH);
        getContentPane().add(sec2,BorderLayout.CENTER);
        getContentPane().add(sec3,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650,500);
        setVisible(true);
       
        
        //sec1.setBackground(Color.getHSBColor(181, 18, 100));
    }

    
    /**
     * @param args the command line arguments
     * Main method:
     *      Displays the welcome screen of the game
     *      Allows you to select if you want to login or register.
     *
    public static void main(String[] args) throws IOException {

        DanceManagerStudioClient myInstance = new DanceManagerStudioClient();
    }
    */


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Object source = e.getSource();
            if(source == loginBttn){
                setVisible(false);
                //TTTLoginFrame login = new TTTLoginFrame(this);
                DMSLoginFrame login = new DMSLoginFrame(this, appLogic);
            }
//            if(source == regBttn){
//                setVisible(false);
//                DMSRegFrame login = new DMSRegFrame(this, new ManagerLogic() );
//            }
        }catch(Exception ee){
            System.err.print(ee.getMessage());
        }
    }

    
}

