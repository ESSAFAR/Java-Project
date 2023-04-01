package com.GUI;

import com.GUI.AdminFrames.AcceuilAdmin;
import com.GUI.StudentFrame.AcceuilEtudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.jdbc.DBConnection;
import com.jdbc.EtudiantDAO;
import com.mysql.cj.jdbc.PreparedStatementWrapper;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Login extends MyFrame {

    public Login() {
        setTitle("Login");


        //Side image
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(500, 0, 920, 780);
        imageContainer.setBackground(new Color(0, 0, 0, 0));
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/sideImage.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);


        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds((int) frameWidth / 15, 0, 400, 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase4resized.png"));
        logoContainer.setBackground(new Color(0, 0, 0, 0));
        logoContainer.add(logo);
        add(logoContainer);


        //Connectz-vous text
        JPanel connectez = new JPanel();
        connectez.setBounds(120, (int) frameHeight / 3, 350, 70);
        JLabel connectezText = new JLabel();
        connectezText.setText("Connectez vous");
        connectezText.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 38));
        connectezText.setForeground(Color.red);
        connectez.setBackground(new Color(0, 0, 0, 0));
        connectez.add(connectezText);
        connectezText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        add(connectez);


        //user identifiant
        JPanel identifiant = new JPanel();
        JLabel identifiantText = new JLabel();
        identifiantText.setText("Entrer votre ID");
        identifiantText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        identifiant.setBounds(58, frameHeight / 2, 250, 30);
        identifiant.setBackground(new Color(0, 0, 0, 0));
        identifiant.add(identifiantText);
        add(identifiant);


        //identifiant text field
        JTextField identifiantField = new JTextField();
        identifiantField.setBounds(120, frameHeight / 2 + 35, 180, 30);
        add(identifiantField);


        //password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(new Color(0, 0, 0, 0));
        JLabel passwordText = new JLabel();
        passwordText.setText("Entrer votre mot de passe");
        passwordText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        passwordPanel.setBounds(103, frameHeight / 2 + 70, 250, 30);
        passwordPanel.add(passwordText);
        add(passwordPanel);


        //password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, frameHeight / 2 + 105, 180, 30);
        add(passwordField);


        //Tips section
        // Changes the label text every 3 seconds

        JLabel adviceLabel = new JLabel();
        adviceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        adviceLabel.setBounds(frameWidth / 8, (int) (MyFrame.frameHeight * 0.75) + 70, 900, 30);
        add(adviceLabel);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            String[] messages = {"Bienvenue de nouveau!", "Problemes de connection?", "Contacter le departement."};
            int i = 0;

            @Override
            public void run() {
                adviceLabel.setForeground(Color.BLUE);

                // Change the label text
                adviceLabel.setText(messages[i]);
                i = (i + 1) % messages.length;
            }
        }, 0, 3000);


        //Log in button
        MyButtons loginBtn = new MyButtons("Log in", Color.BLUE, Color.WHITE, (int) (MyFrame.frameWidth / 8), (int) (MyFrame.frameHeight * 0.75), 250, 50);
        add(loginBtn);
        //Next frame if button is pressed and id + password correct
        loginBtn.addActionListener(e -> {
                    switch (DBConnection.authentificate(identifiantField.getText(), passwordField.getText())) {
                        case 0: {
                            JOptionPane.showMessageDialog(this, "Id ou mdp non valide.", "Erreur de connection", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        case 1: {
                            dispose();
                            AcceuilEtudiant acceuilEtudiant = new AcceuilEtudiant(identifiantText.getText());
                            break;
                        }
                        case 2: {
                            dispose();
                            AcceuilAdmin acceuilAdmin = new AcceuilAdmin();
                            break;
                        }
                    }
                }
        );
        setVisible(true);

        ;
    }
}