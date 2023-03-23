package com.GUI.AdminFrames;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class AdminFrame2 extends MyFrame {

    public AdminFrame2(){



        //Table of students
        String[][] data = {
                {"101" ,"Anwar","Es-Safar" , "anwar.essafar@gmail.com"},
                {"102","Akram","Talibi" , "Akram.Talibi@gmail.com"},
                {"103","Salah","Jouhaini" , "Salah.Jouhaini@gmail.com"},
                {"104","Soufian","Erraoudi" , "Soufian.Erraoudi@gmail.com"},
        };

        String[] columnNames = {"Matricule", "Prenom","Nom" , "Email"};

        JTable table = new JTable(data, columnNames);
        table.setBounds(560, 10, 600, 900);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(560, 10, 600, 600);
        add(scrollPane);




        //When a student is clicked upon, this opens his personnal page
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String matricule = (String) table.getValueAt(row , 0 );
                    dispose();
                    AdminFrame3 frame = new AdminFrame3(matricule);
                }
            }
        });







        //Add a student
        MyButtons Ajouter = new MyButtons("Ajouter" , Color.blue , Color.white , 100 , 100 , 150 , 50);
        add(Ajouter);

        //Search a student
        MyButtons Rechercher = new MyButtons("Rechercher" , Color.blue , Color.white , 100 , 200 , 150 , 50);
        add(Rechercher);


        //delete a student
        MyButtons supprimer = new MyButtons("supprimer" , Color.blue , Color.white , 100 , 300 , 150 , 50);
        add(supprimer);


        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 100 , 400 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            AdminFrame1 frame = new AdminFrame1();
        });
        add(Retour);






        setVisible(true);
    }





}
