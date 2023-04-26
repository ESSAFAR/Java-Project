package com.GUI.AdminFrames;

import com.DataBase.NoteDAO;
import com.DataBase.EtudiantDAO;
import com.Model2.Note;
import com.Style.MyButtons;
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


        //Boutton Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            GestionNotes gestionNotes = new GestionNotes();
        });


        //Boutton Ajouter une note
        MyButtons Ajouter = new MyButtons("Ajouter Note", Color.blue, Color.white, 90, 470, 150, 50);
        Ajouter.addActionListener(e -> {
            // Display a dialog box to prompt the user for the name of the element and the note
            String elementModule = JOptionPane.showInputDialog(null, "Entrez le nom de l'élément module:", "Ajouter une note", JOptionPane.PLAIN_MESSAGE);
            String note = String.valueOf(Double.parseDouble(JOptionPane.showInputDialog(null, "Entrez la note:", "Ajouter une note", JOptionPane.PLAIN_MESSAGE)));
            double noteDouble = Double.parseDouble(note);
            // If the user entered a name and a note, add them to the table
            if (elementModule != null && !elementModule.isEmpty() && note != null && !note.isEmpty()) {
                // Save the new note to the database
                NoteDAO.saveNote(noteDouble,elementModule,matricule);

                // Add the new note to the table
                tableModelListNotes.addRow(new Object[]{"", elementModule, "", note});
            }
        });




        //Panel pour les bouttons
        JPanel panelBouttons = new JPanel();
        //panelBouttons.setLayout(new GridLayout(4,1));

        panelBouttons.add(Ajouter);

        panelBouttons.add(Retour);




        this.add(labelTitre,BorderLayout.NORTH);
        this.add(scrollPaneListNotes,BorderLayout.CENTER);
        this.add(panelBouttons,BorderLayout.WEST);
        setVisible(true);
    }
}
