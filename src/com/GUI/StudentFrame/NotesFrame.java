package com.GUI.StudentFrame;

import com.DataBase.EtudiantDAO;
import com.DataBase.NoteDAO;
import com.Model2.Note;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NotesFrame extends MyFrame {

    private JTable table = new JTable();
    private DefaultTableModel tableModel;

    public NotesFrame(int matricule){
        this.setLayout(new BorderLayout());
        ArrayList<Note> listNotes = NoteDAO.getNotes(matricule);

        tableModel = new DefaultTableModel(new Object[]{"Module","Element","Professeur","Note"},0);
        for(Note note : listNotes){
            tableModel.addRow(new Object[]{note.getElementModule().getModule(),note.getElementModule().getNom(),note.getProfesseur().getNom(),note.getNote()});
        }

        // add some rows for testing
        //tableModel.addRow(new Object[]{"Maths", "Algebra", "John Smith", 85});
        //tableModel.addRow(new Object[]{"Conception", "POO", "Bouzoubaa karim", 92});



        //title
        JLabel labelTitre = new JLabel("Mes Notes");
        JPanel panelTitre = new JPanel();
        //panelTitre.add(labelTitre);


        //table des notes
        JTable table = new JTable();
        table.setModel(tableModel);
        table.setBounds(360, 120, 600, 900);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(360, 120, 600, 600);

        add(scrollPane);




        //boutton retour

        MyButtons BouttonRetour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 270 , 150 , 50);
        this.add(BouttonRetour);
        BouttonRetour.addActionListener(e -> {
            dispose();
            AcceuilEtudiant acceuilEtudiant = new AcceuilEtudiant(matricule);
        });
        add(BouttonRetour);



        //this.add(panelTitre,BorderLayout.NORTH);
        this.add(scrollPane,BorderLayout.CENTER);
        //this.add(panelBouttons,BorderLayout.SOUTH);

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/04.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);


        this.setVisible(true);

    }
}
