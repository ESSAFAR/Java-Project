/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class FicheEtudiant extends MyFrame {


    public FicheEtudiant(String matricule) {
        // Retrieve student information using matricule parameter

        // Create text fields to edit student information
        JTextField nomField = new JTextField("Essafar");
        JTextField prenomField = new JTextField("Anwar");
        JTextField gmailField = new JTextField("anwar.essafar@gmail.com");
        JTextField phoneField = new JTextField("0632085180");

        // Create labels for text fields
        JLabel nomLabel = new JLabel("Nom:");
        JLabel prenomLabel = new JLabel("Prenom:");
        JLabel gmailLabel = new JLabel("Gmail:");
        JLabel phoneLabel = new JLabel("Numero de telephone:");

        // Set bounds for labels and text fields
        nomLabel.setBounds(50, 50, 100, 25);
        prenomLabel.setBounds(50, 100, 100, 25);
        gmailLabel.setBounds(50, 150, 100, 25);
        phoneLabel.setBounds(50, 200, 150, 25);
        nomField.setBounds(200, 50, 200, 25);
        prenomField.setBounds(200, 100, 200, 25);
        gmailField.setBounds(200, 150, 200, 25);
        phoneField.setBounds(200, 200, 200, 25);

        // Add labels and text fields to frame
        add(nomLabel);
        add(prenomLabel);
        add(gmailLabel);
        add(phoneLabel);
        add(nomField);
        add(prenomField);
        add(gmailField);
        add(phoneField);

        // Load and display student image
        ImageIcon icon = new ImageIcon();
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBackground(Color.cyan);
        imageLabel.setBounds(500, 50, 200, 200);
        add(imageLabel);

        // Create "Enregistrer" button
        MyButtons enregistrerBtn = new MyButtons("Enregistrer", Color.blue, Color.white, 100, 400, 150, 50);
        add(enregistrerBtn);

        //  enregistrerBtn.addActionListener(e -> {
            // Update student information with values from text fields
          /*  student.setNom(nomField.getText());
            student.setPrenom(prenomField.getText());
            student.setGmail(gmailField.getText());
            student.setPhone(phoneField.getText()); */

            // Save changes to database or file
            // ...



        // Create "Retour" button
        MyButtons retourBtn = new MyButtons("Retour", Color.blue, Color.white, 300, 400, 150, 50);
       /* retourBtn.addActionListener(e -> {
            // Close current frame and open previous frame
            dispose();
            AdminFrame2 frame = new AdminFrame2();
        });
        add(retourBtn);*/
        setVisible(true);


    }
}