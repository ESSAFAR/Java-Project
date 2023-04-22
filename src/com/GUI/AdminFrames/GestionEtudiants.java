package com.GUI.AdminFrames;

import com.Model.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
        Ajouter.addActionListener(e->{
            dispose();
            FicheEtudiant ficheEtudiant = new FicheEtudiant(EtudiantDAO.generateMatricule());
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
