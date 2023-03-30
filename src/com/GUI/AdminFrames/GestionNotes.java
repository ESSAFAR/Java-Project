package com.GUI.AdminFrames;

/*
Gestion des notes
 */

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class GestionNotes extends MyFrame {


    public GestionNotes() {
        //Combobox to choose 1ere annee, 2eme annee or 3eme annee
         String[] classes = {"1ere annee", "2eme annee", "3eme annee"};
         JComboBox<String> yearComboBox = new JComboBox<>(classes);
        yearComboBox.setBounds(300 , 50 , 130 ,32);
        add(yearComboBox);


        //Combobox to choose semester
        String[] semester = {"1 ere semestre", "2eme semestre"};
        JComboBox<String> semesterComboBox = new JComboBox<>(semester);
        semesterComboBox.setBounds(450 , 50 , 130 ,32);
        add(semesterComboBox);


        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 830 , 50 , 130 , 32);
        Retour.addActionListener(e -> {
            dispose();
            AcceuilAdmin frame = new AcceuilAdmin();
        });
        add(Retour);


        //Table of marks
        String[][] data = {
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"101" ,"Anwar","Es-Safar" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"102","Akram","Talibi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"103","Salah","Jouhaini" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "4" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"104","Soufian","Erraoudi" , "2" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},
                {"000","EOF","EOF" , "1" , "4" , "4", "4" , "4" , "4" ,"4" , "4" ,"4"},


        };

        String[] columnNames = {"Matricule", "Prenom","Nom" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "OS" , "Base de donnees" , "Base de donnees" , "Base de donnees"};
        JTable tableNotes = new JTable(data, columnNames);
        tableNotes.setBounds(20, 130, 1000, 400);
        JScrollPane scrollPane = new JScrollPane(tableNotes);
        scrollPane.setBounds(20, 130,  1000, 550);
        add(scrollPane);

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/05.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);


        setVisible(true);

    }

}
