
/*
A personnal page for the student(matricule)
*/
package com.GUI.AdminFrames;

import com.DataBase.AvisDAO;
import com.GUI.StudentFrame.AvisEtudiant;
import com.Model2.Avis;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FicheAvis extends MyFrame {
    private JPanel panel1;
    private boolean auteurEstAdmin; //vrai si le frame ouvert par admin, faux si consulte par etudiant
    private int matricule; //Matricule de l'etudiant si auteurEstAdmin == false


    public FicheAvis(int id_avis, boolean auteurEstAdmin, int matricule) {
        Avis avis;
        boolean adding = true;  //true if user is adding an avis, false if modyfing an avis

        if(AvisDAO.idExiste(id_avis)){
            avis = AvisDAO.getAvis(id_avis);
        }
        else {
            adding = true;
            avis = new Avis(id_avis,"","",null);
        }



        //Titre
        JLabel titre = new JLabel("AJOUTER AVIS : ");
        titre.setBounds(550, 20, 400, 100);
        add(titre);

        // Create text fields to edit student information
        JTextField idField = new JTextField(avis.getId_avis());
        JTextField objetField = new JTextField(avis.getObjet());

        JTextField contenuField = new JTextField(avis.getContenu());
        idField.setBounds(550 , 240 , 210 , 30);
        objetField.setBounds(550, 310, 210, 30);
        contenuField.setBounds(550, 400, 210, 70);



        // Create labels for text fields
        JLabel idLabel = new JLabel("id avis :");
        JLabel objetLabel = new JLabel("objet d'avis:");
        JLabel contenuLabel = new JLabel("contenu d'avis:");


        // Set bounds for labels and text fields
        idLabel.setBounds(400 , 240 , 210 , 30);
        objetLabel.setBounds(400 , 310 , 210 , 30);
        contenuLabel.setBounds(400 , 400 , 210 , 30);


        // Add labels and text fields to frame
        add(idLabel);
        add(objetLabel);
        add(contenuLabel);
        add(idField);
        add(objetField);
        add(contenuField);







        // Create "Enregistrer" button
        MyButtons enregistrerBtn = new MyButtons("Enregistrer", Color.blue, Color.white, 90 , 270 , 150 , 50);

        enregistrerBtn.addActionListener(e -> {

            avis.setObjet(objetField.getText());
            avis.setContenu(contenuField.getText());

            try {
                // Créer une instance de PreparedStatement avec la requête SQL
                PreparedStatement ps = AvisDAO.getConnection().prepareStatement("INSERT INTO avis (id_avis, objet, contenu, date_creation) VALUES (?, ?, ?, sysdate())");

                // Définir les valeurs des paramètres de la requête
                ps.setInt(1, Integer.parseInt(idField.getText()));
                ps.setString(2, objetField.getText());
                ps.setString(3, contenuField.getText());

                // Exécuter la requête INSERT
                ps.executeUpdate();



                // Fermer la fenêtre actuelle et ouvrir la fenêtre GestionEtudiants
                dispose();
                GestionAvis frame = new GestionAvis();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de l'avis.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });





        //  "Retour" button
        MyButtons retourBtn = new MyButtons("Retour",Color.blue , Color.WHITE, 90 , 370 , 150 , 50);
        retourBtn.addActionListener(e -> {
            dispose();
            if(auteurEstAdmin){
                GestionAvis gestionavis = new GestionAvis();
            }
            else{
                AvisEtudiant avisEtudiant = new AvisEtudiant(matricule);
            }
        });
        add(retourBtn);


        // backgroud

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/03.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);

        //Si l'auteur n'est pas admin, il ne peut pas modifier les champs
        if(!auteurEstAdmin){
            idField.setEditable(false);
            objetField.setEditable(false);
            contenuField.setEditable(false);
        }
        else{
            add(enregistrerBtn);
        }


        setVisible(true);





    }

    public FicheAvis(int id_avis, boolean auteurEstAdmin) {
        this(id_avis, auteurEstAdmin, 0);
    }
    }

