package com.GUI.AdminFrames;

import com.DataBase.EtudiantDAO;
import com.Model2.Note;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FicheNotes extends MyFrame {

    private DefaultTableModel tableModelListNotes ;
    private JTable tableListNotes ;
    public FicheNotes(int matricule){
        this.setLayout(new BorderLayout(5,5));


        //Titre
        JLabel labelTitre = new JLabel("Liste des notes de "+EtudiantDAO.getEtudiant(matricule).getNom()+" "+EtudiantDAO.getEtudiant(matricule).getPrenom());
        labelTitre.setHorizontalAlignment(JLabel.CENTER);

        //table Modele
        ArrayList<Note> listNotes = EtudiantDAO.getNotes(matricule);

        tableModelListNotes = new DefaultTableModel(new Object[]{"Module","Element","Professeur","Note"},0);
        for(Note note : listNotes){
            tableModelListNotes.addRow(new Object[]{note.getElementModule().getModule(),note.getElementModule().getNom(),note.getProfesseur().getNom(),note.getNote()});
        }

        tableListNotes = new JTable(tableModelListNotes);
        tableListNotes.setBounds(360, 120, 600, 900);
        JScrollPane scrollPaneListNotes = new JScrollPane(tableListNotes);
        scrollPaneListNotes.setBounds(360, 120, 600, 600);



        this.add(labelTitre,BorderLayout.NORTH);
        this.add(scrollPaneListNotes,BorderLayout.CENTER);
        setVisible(true);
    }
}
