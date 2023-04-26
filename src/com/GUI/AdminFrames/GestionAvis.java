package com.GUI.AdminFrames;

import com.Model.Avis;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.AvisDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GestionAvis extends MyFrame {
    boolean auteurEstAdmin; //vrai si le frame ouvert par admin, faux si consulte par etudiant


    public GestionAvis(){

        //Table of students
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("id_avis");
        tableModel.addColumn("objet");
        tableModel.addColumn("contenu");
        tableModel.addColumn("date_creation");
        for (Avis  avis : AvisDAO.getListAvis()) {
            tableModel.addRow(new Object[]{
                    avis.getId_avis(), avis.getObjet(), avis.getContenu(),avis.getDate_avis()});
        }


        JTable table = new JTable();
        table.setModel(tableModel);
        table.setBounds(360, 120, 600, 900);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(360, 120, 600, 600);
        add(scrollPane);




        //When a student is clicked upon, this opens his personnal page
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    int id_avis = (int) table.getValueAt(row , 0 );
                    dispose();
                    FicheAvis frame = new FicheAvis(id_avis, false);
                }
            }
        });




// Modifier un avis
        //Modifier avis
        MyButtons Modifier = new MyButtons("Modifier avis" , Color.blue , Color.white , 90 , 270 , 150 , 50);
        Modifier.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(null, "Entrez l'id de l'avis à modifier: ");
            if (input != null && !input.isEmpty()) {
                int id_avis = Integer.parseInt(input);
                Avis avis = AvisDAO.getAvis(id_avis);
                if (avis != null) {
                    String objet = JOptionPane.showInputDialog(null, "Entrez le nouvel objet: ", avis.getObjet());
                    String contenu = JOptionPane.showInputDialog(null, "Entrez le nouveau contenu: ", avis.getContenu());
                    avis.setObjet(objet);
                    avis.setContenu(contenu);
                    AvisDAO.updateAvis(avis.getId_avis(), avis.getObjet(), avis.getContenu());
                    dispose();
                    GestionAvis frame = new GestionAvis();
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun avis avec cet ID n'existe.");
                }
            }
        });
        add(Modifier);


        // supprimer
        MyButtons Supprimer = new MyButtons("Supprimer avis" , Color.blue , Color.white , 90 , 370 , 150 , 50);
        Supprimer.addActionListener(e -> {
            //Récupération de l'id_avis à supprimer
            String idAvis = JOptionPane.showInputDialog(null, "Veuillez entrer l'id de l'avis à supprimer : ", "Supprimer un avis", JOptionPane.PLAIN_MESSAGE);
            if (idAvis != null) {
                try {
                    int id = Integer.parseInt(idAvis);
                    //Suppression de l'avis avec l'id spécifié
                    AvisDAO.deleteAvis(id);
                    //Actualisation de la table
                    tableModel.setRowCount(0);
                    for (Avis avis : AvisDAO.getListAvis()) {
                        tableModel.addRow(new Object[]{
                                avis.getId_avis(), avis.getObjet(), avis.getContenu(),avis.getDate_avis()});
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "L'id saisi est invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(Supprimer);

        //Add a student
        MyButtons Ajouter = new MyButtons("Ajouter avis " , Color.blue , Color.white , 90 , 170 , 150 , 50);
        Ajouter.addActionListener(e->{
            dispose();
            FicheAvis ficheAvis = new FicheAvis(AvisDAO.generateidAvis(), false);
        });
        add(Ajouter);


        //delete all data
        MyButtons clear = new MyButtons("Clear" , Color.blue , Color.white , 90 , 270 , 150 , 50);
//        clear.addActionListener(e -> {
//
//                }
//
//        );
//        add(clear);


        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            AcceuilAdmin frame = new AcceuilAdmin();
        });
        add(Retour);



        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/04.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);




        setVisible(true);
    }






}
