package com.GUI.AdminFrames;

/*
Gestion des notes
 */

import com.Style.MyFrame;

import javax.swing.*;

public class AdminFrame6 extends MyFrame {


    public AdminFrame6() {
        //Combobox to choose 1ere annee, 2eme annee or 3eme annee
         String[] classes = {"1ere annee", "2eme annee", "3eme annee"};
         JComboBox<String> yearComboBox = new JComboBox<>(classes);
        yearComboBox.setBounds(5 , 5 , 80 ,24);
        add(yearComboBox);


        //Combobox to choose semester
        String[] semester = {"1 ere semestre", "2eme semestre"};
        JComboBox<String> semesterComboBox = new JComboBox<>(semester);
        semesterComboBox.setBounds(105 , 5 , 80 ,24);
        add(semesterComboBox);




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
        };

        String[] columnNames = {"Matricule", "Prenom","Nom" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "Base de donnees" , "OS" , "Base de donnees" , "Base de donnees" , "Base de donnees"};
        JTable tableNotes = new JTable(data, columnNames);
        tableNotes.setBounds(0, 30, this.getWidth(), 900);
        JScrollPane scrollPane = new JScrollPane(tableNotes);
        scrollPane.setBounds(0, 30,  this.getWidth(), 600);
        add(scrollPane);


        setVisible(true);

    }








}
