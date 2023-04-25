/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.DataBase.AvisDAO;
import com.Model.Avis;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FicheAvis extends MyFrame {
    private JPanel panel1;


    public FicheAvis(int id_avis) {
        Avis avis;
        boolean adding = true;  //true if user is adding an avis, false if modyfing an avis

        if(AvisDAO.idExiste(id_avis)){
            avis = AvisDAO.getAvis(id_avis);
        }
        else {
            adding = true;
            avis = new Avis(id_avis,"","",null);
        }




        // Create text fields to edit student information
        JTextField idField = new JTextField(avis.getId_avis());
        JTextField objetField = new JTextField(avis.getObjet());

        JTextField contenuField = new JTextField(avis.getContenu());
        idField.setBounds(200, 50, 200, 25);
        objetField.setBounds(200, 100, 200, 25);
        contenuField.setBounds(200, 150, 200, 25);



        // Create labels for text fields
        JLabel idLabel = new JLabel("id avis :");
        JLabel objetLabel = new JLabel("objet d'avis:");
        JLabel contenuLabel = new JLabel("contenu d'avis:");


        // Set bounds for labels and text fields
        idLabel.setBounds(50, 50, 100, 25);
        objetLabel.setBounds(50, 100, 100, 25);
        contenuLabel.setBounds(50, 150, 100, 25);


        // Add labels and text fields to frame
        add(idLabel);
        add(objetLabel);
        add(contenuLabel);
        add(idField);
        add(objetField);
        add(contenuField);







        // Create "Enregistrer" button
        MyButtons enregistrerBtn = new MyButtons("Enregistrer", Color.blue, Color.white, 600, 100, 150, 50);
        add(enregistrerBtn);

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

                // Fermer la connexion
                AvisDAO.closeConnection();

                // Fermer la fenêtre actuelle et ouvrir la fenêtre GestionEtudiants
                dispose();
                GestionEtudiants frame = new GestionEtudiants();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de l'avis.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });





        //  "Retour" button
        MyButtons retourBtn = new MyButtons("Retour",Color.blue , Color.WHITE, 600, 300, 150, 50);
        retourBtn.addActionListener(e -> {
            dispose();
            GestionAvis gestionavis = new GestionAvis();
        });
        add(retourBtn);


        // Create "supprimer" button


        setVisible(true);





    }
}
