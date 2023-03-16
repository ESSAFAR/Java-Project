package com.GUI;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class Login extends MyFrame {

    public Login() {
        setTitle("Login");

        //Log in button
        MyButtons loginBtn = new MyButtons("Log in" , Color.BLUE , Color.WHITE , 170 , 650 , 250 , 50) ;
        add(loginBtn);


        //Side image
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(700 , 0 , 790 , 770);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/sideImage.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);




        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(90 , 50 , 400 , 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase4resized.png"));
        logoContainer.setBackground(new Color(0,0,0,0));
        logoContainer.add(logo);
        add(logoContainer);


        //Connectz-vous text
        JPanel connectez = new JPanel();
        connectez.setBounds(120 , 300 , 350 , 70);
        JLabel connectezText = new JLabel();
        connectezText.setText("Connectez vous");
        connectezText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,  38));
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
        identifiant.setBounds(58 , 400 , 250 , 30);
        identifiant.setBackground(new Color(0,0,0,0));
        identifiant.add(identifiantText);
        add(identifiant);


        //identifiant text field
        JTextField identifiantField = new JTextField();
        identifiantField.setBounds(120 , 435 , 180 , 30);
        add(identifiantField);



        //password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(new Color(0,0,0,0));
        JLabel passwordText = new JLabel();
        passwordText.setText("Entrer votre mot de passe");
        passwordText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,  17));
        passwordPanel.setBounds(103 , 500 , 250 , 30);
        passwordPanel.add(passwordText);
        add(passwordPanel);


        //password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120 , 535 , 180 , 30);
        add(passwordField);













        setVisible(true);
    }
}
