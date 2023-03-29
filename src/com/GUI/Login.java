package com.GUI;

import com.GUI.AdminFrames.AdminFrame1;
import com.GUI.AdminFrames.AdminFrame2;
import com.Style.MyButtons;
import com.Style.MyFrame;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class Login extends MyFrame {

    public Login() {

        setTitle("Login");


        //Log in button
        MyButtons loginBtn = new MyButtons("Log in" , Color.BLUE , Color.WHITE , (int)(frameWidth/8)-60 , (int)(frameHeight*0.75) , 160 , 40) ;
        add(loginBtn);
        //Next frame if button is pressed and id + password correct
        if(true){
            loginBtn.addActionListener(e -> {
                dispose();
                AdminFrame1 frame = new AdminFrame1();
               // StudentFrame1 frame2 =new StudentFrame1() ;

            });
        }


        //Connectz-vous text


        JPanel connectez = new JPanel();
        //connectez.setOpaque(false);
        connectez.setBounds(0 , (int)frameHeight/3 , 350 , 70);
        JLabel connectezText = new JLabel();

        connectezText.setText("Connectez vous");
        connectezText.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD,  38));
        connectezText.setForeground(Color.red);
        connectez.setBackground(new Color(0,0,0,0));
        connectez.add(connectezText);
        connectezText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,  30));

        add(connectez);


        //user identifiant
        JPanel identifiant = new JPanel();
        JLabel identifiantText = new JLabel();
        identifiantText.setText("Entrer votre ID");
        identifiantText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,  17));
        identifiant.setBounds(40 , frameHeight/2 , 250 , 30);
        identifiant.setBackground(new Color(0,0,0,0));
        identifiant.add(identifiantText);
        add(identifiant);


        //identifiant text field
        JTextField identifiantField = new JTextField();
        identifiantField.setBounds(70 , frameHeight/2 + 35 , 180 , 30);
        add(identifiantField);



        //password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(new Color(0,0,0,0));
        JLabel passwordText = new JLabel();
        passwordText.setText("Entrer votre mot de passe");
        passwordText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,  17));
        passwordPanel.setBounds(40 , frameHeight/2 + 70 , 250 , 30);
        passwordPanel.add(passwordText);
        add(passwordPanel);


        //password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(70 , frameHeight/2 + 105 , 180 , 30);
        add(passwordField);



        //Tips section
        // Changes the label text every 3 seconds

        JLabel adviceLabel = new JLabel();
        adviceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        adviceLabel.setBounds(frameWidth / 8 , (int)(frameHeight*0.75)-70, 900 , 30);
        add(adviceLabel);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String[] messages = {"Bienvenue de nouveau!","Problemes de connection?" , "Contacter le departement."};
            int i = 0;

            @Override
            public void run() {
                adviceLabel.setForeground(Color.BLUE);

                // Change the label text
                adviceLabel.setText(messages[i]);
                i = (i + 1) % messages.length;
            }
        }, 0, 3000);

        setVisible(true);









        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(-10 , -58 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/1.png"));
        imageContainer.add(sideImage);
        add(imageContainer);


        setVisible(true);
    }
}
