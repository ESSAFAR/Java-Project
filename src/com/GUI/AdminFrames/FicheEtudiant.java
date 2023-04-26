/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.GUI.StudentFrame.AcceuilEtudiant;
import com.Model2.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import java.awt.*;

public class FicheEtudiant extends MyFrame {
    boolean auteurEstAdmin; //vrai si le frame ouvert par admin, faux si consulte par etudiant


    public FicheEtudiant(int matricule, boolean auteurEstAdmin) {
        Etudiant etudiant;
        boolean adding = false;  //true if user is adding a student, false if modyfing a student

        if(EtudiantDAO.matriculeExiste(matricule)){
             etudiant = EtudiantDAO.getEtudiant(matricule);
        }
        else {
            adding = true;
            etudiant = new Etudiant("new","","","",matricule,"","","","","","","","");
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
        JTextField cinField = new JTextField(etudiant.getCin());
        JTextField genreField = new JTextField(etudiant.getGenre());
        JTextField dateNaissanceField = new JTextField(etudiant.getDateNaissance());
        JTextField lieuNaissanceField = new JTextField(etudiant.getLieuNaissance());
        JTextField nationaliteField = new JTextField(etudiant.getNationalite());
        JTextField adresseField = new JTextField(etudiant.getAdresse());
        JTextField promotionField = new JTextField(etudiant.getPromotion());

        // Create labels for text fields
        JLabel nomLabel = new JLabel("Nom:");
        JLabel prenomLabel = new JLabel("Prenom:");
        JLabel emailLabel = new JLabel("mail:");
        JLabel phoneLabel = new JLabel("Numero de telephone:");
        JLabel cinLabel = new JLabel("CIN:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel dateNaissanceLabel = new JLabel("Date de naissance:");
        JLabel lieuNaissanceLabel = new JLabel("Lieu de naissance:");
        JLabel nationaliteLabel = new JLabel("Nationalité:");
        JLabel adresseLabel = new JLabel("Adresse:");
        JLabel promotionLabel = new JLabel("Promotion:");

        // Set bounds for labels and text fields
        nomLabel.setBounds(400, 50, 100, 25);
        prenomLabel.setBounds(400, 100, 100, 25);
        emailLabel.setBounds(400, 150, 100, 25);
        phoneLabel.setBounds(400, 200, 150, 25);
        nomField.setBounds(550, 50, 200, 25);
        prenomField.setBounds(550, 100, 200, 25);
        emailField.setBounds(550, 150, 290, 25);
        emailField.setEditable(false);
        phoneField.setBounds(550, 200, 200, 25);
        cinLabel.setBounds(400, 250, 100, 25);
        genreLabel.setBounds(400, 300, 100, 25);
        dateNaissanceLabel.setBounds(400, 350, 150, 25);
        lieuNaissanceLabel.setBounds(400, 400, 150, 25);
        nationaliteLabel.setBounds(400, 450, 100, 25);
        adresseLabel.setBounds(400, 500, 100, 25);
        promotionLabel.setBounds(400, 550, 100, 25);
        cinField.setBounds(550, 250, 200, 25);
        genreField.setBounds(550, 300, 200, 25);
        dateNaissanceField.setBounds(550, 350, 200, 25);
        lieuNaissanceField.setBounds(550, 400, 200, 25);
        nationaliteField.setBounds(550, 450, 200, 25);
        adresseField.setBounds(550, 500, 290, 25);
        promotionField.setBounds(550, 550, 200, 25);

        // Add labels and text fields to frame
        add(nomLabel);
        add(prenomLabel);
        if(!adding){
            add(emailLabel);
        }
        add(phoneLabel);
        add(nomField);
        add(prenomField);
        if(!adding){
            add(emailField);
        }
        add(phoneField);
        add(cinLabel);
        add(genreLabel);
        add(dateNaissanceLabel);
        add(lieuNaissanceLabel);
        add(nationaliteLabel);
        add(adresseLabel);
        add(promotionLabel);
        add(cinField);
        add(genreField);
        add(dateNaissanceField);
        add(lieuNaissanceField);
        add(nationaliteField);
        add(adresseField);
        add(promotionField);



        // Create "Enregistrer" button
        MyButtons enregistrerBtn = new MyButtons("Enregistrer", Color.blue, Color.white, 90 , 170 , 150 , 50);
        enregistrerBtn.addActionListener(e -> {
            etudiant.setNom(nomField.getText());
            etudiant.setPrenom(prenomField.getText());
            etudiant.setTelephone(phoneField.getText());
            etudiant.setCin(cinField.getText());
            etudiant.setGenre(genreField.getText());
            etudiant.setDateNaissance(dateNaissanceField.getText());
            etudiant.setLieuNaissance(lieuNaissanceField.getText());
            etudiant.setNationalite(nationaliteField.getText());
            etudiant.setAdresse(adresseField.getText());
            EtudiantDAO.modifierEtudiant(etudiant.getMatricule() , nomField.getText(), prenomField.getText(), etudiant.getMotDePasse() , etudiant.getCin() , etudiant.getGenre(), etudiant.getDateNaissance(), etudiant.getLieuNaissance(), etudiant.getNationalite(), etudiant.getTelephone(), etudiant.getAdresse(), etudiant.getCne()) ;
            dispose();
            GestionEtudiants frame = new GestionEtudiants();
        });






        //  "Retour" button
        MyButtons retourBtn = new MyButtons("Retour",Color.blue , Color.WHITE, 90 , 370 , 150 , 50);
        retourBtn.addActionListener(e -> {
            dispose();
            if(auteurEstAdmin){
                GestionEtudiants gestionEtudiants = new GestionEtudiants();
            }
            else{
                AcceuilEtudiant acceuilEtudiant = new AcceuilEtudiant(matricule);
            }
        });
        add(retourBtn);


        // Create "supprimer" button
        MyButtons supprimer = new MyButtons("supprimer", Color.blue, Color.white, 90 , 270 , 150 , 50);
        supprimer.addActionListener(e -> {
            etudiant.setNom(nomField.getText());
            etudiant.setPrenom(prenomField.getText());
            etudiant.setTelephone(phoneField.getText());
            EtudiantDAO.delete(etudiant.getMatricule());
            GestionEtudiants gestionEtudiants = new GestionEtudiants();
            JOptionPane.showMessageDialog(null, "L'étudiant " + etudiant.getPrenom() + " a été supprimé avec succès", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);

        });
        //Student can't modify fields
        if(!auteurEstAdmin){
            nomField.setEditable(false);
            prenomField.setEditable(false);
            emailField.setEditable(false);
            phoneField.setEditable(false);
            cinField.setEditable(false);
            genreField.setEditable(false);
            dateNaissanceField.setEditable(false);
            lieuNaissanceField.setEditable(false);
            nationaliteField.setEditable(false);
            adresseField.setEditable(false);
            promotionField.setEditable(false);
        }
        else{
            add(enregistrerBtn);
            add(supprimer);
        }




        setVisible(true);





    }
}