package com.GUI.StudentFrame;

import com.Model2.Avis;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.AvisDAO;
import com.GUI.AdminFrames.FicheAvis;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AvisEtudiant extends MyFrame {

    public AvisEtudiant(int matriculeEtudiant){

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
                    FicheAvis frame = new FicheAvis(id_avis, false, matriculeEtudiant);
                }
            }
        });









        //delete all data
        MyButtons clear = new MyButtons("Clear" , Color.blue , Color.white , 90 , 270 , 150 , 50);
//        clear.addActionListener(e -> {
//
//                }
//
//        );
//        add(clear);


        //Retour
        MyButtons BouttonRetour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 270 , 150 , 50);
        this.add(BouttonRetour);
        BouttonRetour.addActionListener(e -> {
            dispose();
            AcceuilEtudiant acceuilEtudiant = new AcceuilEtudiant(matriculeEtudiant);
        });
        add(BouttonRetour);



        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/04.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);




        setVisible(true);
    }
}
