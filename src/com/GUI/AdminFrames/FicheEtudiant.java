/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.Model.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import java.awt.*;

public class FicheEtudiant extends MyFrame {


    public FicheEtudiant(int matricule) {
        Etudiant etudiant;

        if(EtudiantDAO.MatriculeExiste(matricule)){
             etudiant = EtudiantDAO.getEtudiant(matricule);
        }
        else {
            etudiant = new Etudiant("","","","",matricule,"","","","","","","");
        }


        // Load and display student image
        JLabel imageLabel = new JLabel();
       // imageLabel.setIcon(new ImageIcon((Image de etudiant));
        imageLabel.setBounds(500, 50, 200, 200);
        add(imageLabel);

        // Create text fields to edit student information
        JTextField nomField = new JTextField(etudiant.getNom());
        JTextField prenomField = new JTextField(etudiant.getPrenom());
        JTextField emailField = new JTextField(etudiant.getEmailInstitutionnel());
        JTextField phoneField = new JTextField(etudiant.getTelephone());

        // Create labels for text fields
        JLabel nomLabel = new JLabel("Nom:");
        JLabel prenomLabel = new JLabel("Prenom:");
        JLabel emailLabel = new JLabel("mail:");
        JLabel phoneLabel = new JLabel("Numero de telephone:");

        // Set bounds for labels and text fields
        nomLabel.setBounds(50, 50, 100, 25);
        prenomLabel.setBounds(50, 100, 100, 25);
        emailLabel.setBounds(50, 150, 100, 25);
        phoneLabel.setBounds(50, 200, 150, 25);
        nomField.setBounds(200, 50, 200, 25);
        prenomField.setBounds(200, 100, 200, 25);
        emailField.setBounds(200, 150, 290, 25);
        phoneField.setBounds(200, 200, 200, 25);

        // Add labels and text fields to frame
        add(nomLabel);
        add(prenomLabel);
        add(emailLabel);
        add(phoneLabel);
        add(nomField);
        add(prenomField);
        add(emailField);
        add(phoneField);



        // Create "Enregistrer" button
        MyButtons enregistrerBtn = new MyButtons("Enregistrer", Color.blue, Color.white, 100, 400, 150, 50);
        add(enregistrerBtn);

        enregistrerBtn.addActionListener(e -> {
            etudiant.setNom(nomField.getText());
            etudiant.setPrenom(prenomField.getText());
            etudiant.setTelephone(phoneField.getText());

            System.out.println("Etudiant : " + matricule + " est Modifie");
            EtudiantDAO.modifierEtudiant(etudiant.getMatricule() , nomField.getText(), prenomField.getText(), etudiant.getMotDePasse() , etudiant.getCin() , etudiant.getGenre(), etudiant.getDateNaissance(), etudiant.getLieuNaissance(), etudiant.getNationalite(), etudiant.getTelephone(), etudiant.getAdresse(), etudiant.getCne()) ;
            dispose();
            GestionEtudiants frame = new GestionEtudiants();
        });




        //  "Retour" button
        MyButtons retourBtn = new MyButtons("Retour",Color.blue , Color.WHITE);
        retourBtn.addActionListener(e -> {
            dispose();
            GestionEtudiants gestionEtudiants = new GestionEtudiants();
        });
        add(retourBtn);


        // Create "supprimer" button
        MyButtons supprimer = new MyButtons("supprimer", Color.blue, Color.white, 500, 400, 150, 50);
        add(supprimer);

        supprimer.addActionListener(e -> {
            etudiant.setNom(nomField.getText());
            etudiant.setPrenom(prenomField.getText());
            etudiant.setTelephone(phoneField.getText());

            System.out.println("Etudiant : " + matricule + " est supprime");
            EtudiantDAO.delete(etudiant.getMatricule());
            GestionEtudiants gestionEtudiants = new GestionEtudiants();
            JOptionPane.showMessageDialog(null, "L'étudiant " + etudiant.getPrenom() + " a été supprimé avec succès", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);

        });

        setVisible(true);





    }
}