package com.GUI.AdminFrames;


import com.DataBase.ElementModuleDAO;
import com.DataBase.NoteDAO;
import com.DataBase.EtudiantDAO;
import com.Model2.Note;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class FicheNotes extends MyFrame {

    private DefaultTableModel tableModelListNotes ;
    private JTable tableListNotes ;
    public FicheNotes(int matricule) {
        this.setLayout(new BorderLayout(5, 5));


        //Titre
        JLabel labelTitre = new JLabel("Liste des notes de " + EtudiantDAO.getEtudiant(matricule).getNom() + " " + EtudiantDAO.getEtudiant(matricule).getPrenom());
        labelTitre.setHorizontalAlignment(JLabel.CENTER);

        //table Modele
        ArrayList<Note> listNotes = NoteDAO.getNotes(matricule);

        tableModelListNotes = new DefaultTableModel(new Object[]{"Module", "Element", "Professeur", "Note"}, 0);
        for (Note note : listNotes) {
            tableModelListNotes.addRow(new Object[]{note.getElementModule().getModule(), note.getElementModule().getNom(), note.getProfesseur().getNom(), note.getNote()});
        }

        tableListNotes = new JTable(tableModelListNotes);
        JScrollPane scrollPaneListNotes = new JScrollPane(tableListNotes);
        scrollPaneListNotes.setBounds(360, 120, 600, 600);


        //Boutton Retour
        MyButtons Retour = new MyButtons("Retour", Color.blue, Color.white, 90, 470, 150, 50);
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
            // If the user entered a name and a note, check if the element module exists in the element_module table
            if (elementModule != null && !elementModule.isEmpty() && note != null && !note.isEmpty()) {
                int a = ElementModuleDAO.elementModuleExiste(elementModule);
                if (a != -1) {
                    // Save the new note to the database
                    NoteDAO.saveNote(noteDouble, elementModule, matricule);

                    // Add the new note to the table
                    String[] result;
                    try {
                        result = ElementModuleDAO.getModuleAndProfessor(a);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    tableModelListNotes.addRow(new Object[]{result[0], elementModule, result[1], note});
                    tableModelListNotes.fireTableDataChanged();


                } else {
                    JOptionPane.showMessageDialog(null, "L'élément module n'existe pas dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // //When a student is clicked upon, this opens his list of grades
        ListSelectionModel selectionModel = tableListNotes.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = tableListNotes.getSelectedRow();
                    String elementModule = (String) tableListNotes.getValueAt(row, 1);

                    String input = JOptionPane.showInputDialog(null, "Nouvelle note:", "Modifier Note", JOptionPane.PLAIN_MESSAGE);
                    double doubleNewNote = Double.parseDouble(input);

                    if (input != null && !input.isEmpty()) {
                        NoteDAO.updateNote(doubleNewNote, elementModule, matricule);
                        tableModelListNotes.setValueAt(doubleNewNote, row, 3);
                        tableModelListNotes.fireTableDataChanged();
                    }
                }
            }
        });


        //Panel pour les bouttons
        JPanel panelBouttons = new JPanel();
        //panelBouttons.setLayout(new GridLayout(4,1));

        panelBouttons.add(Ajouter);

        panelBouttons.add(Retour);


        this.add(labelTitre, BorderLayout.NORTH);
        this.add(scrollPaneListNotes, BorderLayout.CENTER);
        this.add(panelBouttons, BorderLayout.WEST);
        setVisible(true);
    }
}