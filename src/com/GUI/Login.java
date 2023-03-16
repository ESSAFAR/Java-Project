package com.GUI;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class Login extends MyFrame {

    public Login() {
        setTitle("Login");

        //Log in button
        MyButtons loginBtn = new MyButtons("Log in" , Color.BLUE , Color.WHITE , 150 , 600 , 250 , 50) ;
        add(loginBtn);


        //Side image
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(700 , 40 , 750 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/sideImage.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);




        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(120 , 90 , 350 , 70);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase3.png"));
        logoContainer.setBackground(Color.red);
        logoContainer.add(logo);
        add(logoContainer);


        //Connectz-vous text
        JPanel connectez = new JPanel();
        connectez.setBounds(120 , 300 , 350 , 70);
        JLabel connectezText = new JLabel();
        connectezText.setText("Connectz vous");
        connectez.setBackground(Color.yellow);
        connectez.add(connectezText);
        add(connectez);


        //user identifiant
        JPanel identifiant = new JPanel();
        identifiant.setBackground(Color.cyan);
        JLabel identifiantText = new JLabel();
        identifiantText.setText("Entrer votre ID");
        identifiant.setBounds(120 , 400 , 180 , 30);
        identifiant.add(identifiantText);
        add(identifiant);



        //password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.cyan);
        JLabel passwordText = new JLabel();
        passwordText.setText("Entrer votre mot de passe");
        passwordPanel.setBounds(120 , 530 , 180 , 30);
        passwordPanel.add(passwordText);
        add(passwordPanel);













        setVisible(true);
    }
}
