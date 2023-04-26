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


        //boutton Enregistrer
        MyButtons Enregistrer = new MyButtons("Enregistrer" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        Enregistrer.addActionListener(e -> {
            // parcourir toutes les notes dans le modèle de la table
            for (int i = 0; i < tableModelListNotes.getRowCount(); i++) {
                // récupérer les valeurs des champs de la ligne i
                String module = (String) tableModelListNotes.getValueAt(i, 0);
                String element = (String) tableModelListNotes.getValueAt(i, 1);
                String professeur = (String) tableModelListNotes.getValueAt(i, 2);
                double note = (double) tableModelListNotes.getValueAt(i, 3);
                // mettre à jour la note dans la base de données
                NoteDAO.updateNote(module, element, professeur, note);
            }
        });


        //Boutton Ajouter une note
        MyButtons Ajouter = new MyButtons("Ajouter Note" , Color.blue , Color.white , 90 , 470 , 150 , 50);

        //Boutton pour Supprimer Note
        MyButtons Supprimer = new MyButtons("Supprimer" , Color.blue , Color.white , 90 , 470 , 150 , 50);



        //Panel pour les bouttons
        JPanel panelBouttons = new JPanel();
        panelBouttons.setLayout(new GridLayout(4,1));
        panelBouttons.add(Enregistrer);
        panelBouttons.add(Ajouter);
        panelBouttons.add(Supprimer);
        panelBouttons.add(Retour);




        this.add(labelTitre,BorderLayout.NORTH);
        this.add(scrollPaneListNotes,BorderLayout.CENTER);
        this.add(panelBouttons,BorderLayout.WEST);
        setVisible(true);
    }
}
