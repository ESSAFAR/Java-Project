package com.GUI.AdminFrames;

import com.Model.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.jdbc.EtudiantDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class GestionEtudiants extends MyFrame {

    public GestionEtudiants(){

        //Table of students
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Matricule");
        tableModel.addColumn("Nom");
        tableModel.addColumn("Prenom");

        for (Etudiant etudiant : EtudiantDAO.getListEtudiant()) {
            tableModel.addRow(new Object[]{
                    etudiant.getMatricule(), etudiant.getNom(), etudiant.getPrenom()});
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
                    int matricule = (int) table.getValueAt(row , 0 );
                    dispose();
                    FicheEtudiant frame = new FicheEtudiant(matricule);
                }
            }
        });







        //Add a student
        MyButtons Ajouter = new MyButtons("Ajouter" , Color.blue , Color.white , 90 , 170 , 150 , 50);
//        Ajouter.addActionListener(e->{
//            EtudiantDAO.modifierEtudiant(690);
//            dispose();
//            GestionEtudiants gestionEtudiants = new GestionEtudiants();
//        });
        add(Ajouter);

        //Search a student
        MyButtons Rechercher = new MyButtons("Rechercher" , Color.blue , Color.white , 90 , 270 , 150 , 50);
        add(Rechercher);


        //delete a student
        MyButtons supprimer = new MyButtons("supprimer" , Color.blue , Color.white , 90 , 370 , 150 , 50);
        add(supprimer);


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
