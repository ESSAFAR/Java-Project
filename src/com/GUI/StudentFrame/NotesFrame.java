package com.GUI.StudentFrame;

import com.DataBase.EtudiantDAO;
import com.Model2.Note;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class NotesFrame extends MyFrame {

    private JTable table = new JTable();
    private DefaultTableModel tableModel;

    public NotesFrame(int matricule){
        this.setLayout(new BorderLayout());
        ArrayList<Note> listNotes = EtudiantDAO.getNotes(matricule);

        tableModel = new DefaultTableModel(new Object[]{"Module","Element","Professeur","Note"},0);
        for(Note note : listNotes){
            tableModel.addRow(new Object[]{note.getElementModule().getModule(),note.getElementModule().getNom(),note.getProfesseur().getNom(),note.getNote()});
        }

        table = new JTable(tableModel);


        JLabel labelTitre = new JLabel("Mes Notes");

        this.add(labelTitre);
        this.add(table);

    }
}
