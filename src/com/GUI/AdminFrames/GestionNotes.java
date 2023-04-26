package com.GUI.AdminFrames;

/*
Gestion des notes
 */

import com.DataBase.EtudiantDAO;
import com.Model2.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class GestionNotes extends MyFrame {

    private DefaultTableModel tableModelListEtudiant;
    private JTable tableListEtudiant;
    private String[] promotions = {"1A", "2A", "3A"};
    private JComboBox<String> yearComboBox = new JComboBox<>(promotions);


    public GestionNotes() {

        this.setLayout(new BorderLayout());

        JLabel labelTitre = new JLabel("Liste des etudiants ");


        //table de la liste des etudiants
        tableModelListEtudiant = new DefaultTableModel(new Object[]{"Nom","Prenom","Matricule"},0);

        //Combobox to choose 1ere annee, 2eme annee or 3eme annee
        yearComboBox.setBounds(300 , 50 , 130 ,32);
        yearComboBox.addActionListener(e -> {
            updateTable();
        });



        /* for (Etudiant etudiant : EtudiantDAO.getListEtudiant()) {
            tableModelListEtudiant.addRow(new Object[]{etudiant.getNom(),etudiant.getPrenom(),etudiant.getMatricule()});
        } */

        tableListEtudiant = new JTable(tableModelListEtudiant);
        tableListEtudiant.setBounds(360, 120, 600, 900);
        JScrollPane scrollPaneListEtudiant = new JScrollPane(tableListEtudiant);
        scrollPaneListEtudiant.setBounds(360, 120, 600, 600);



        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 830 , 50 , 130 , 32);
        Retour.addActionListener(e -> {
            dispose();
            AcceuilAdmin frame = new AcceuilAdmin();
        });
        JPanel panelRetour = new JPanel();
        panelRetour.add(Retour);


        //icone Image
        /*JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 20 , 20);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/05.jpg"));
        imageContainer.add(sideImage);*/


        //panel Image And Combox
        JPanel panelImageAndCombox = new JPanel();
        panelImageAndCombox.add(yearComboBox);
        //panelImageAndCombox.add(imageContainer);



        // //When a student is clicked upon, this opens his list of grades
        ListSelectionModel selectionModel = tableListEtudiant.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = tableListEtudiant.getSelectedRow();
                    int matricule = (int) tableListEtudiant.getValueAt(row , 2 );
                    dispose();
                    FicheNotes ficheNotes = new FicheNotes(matricule);
                }
            }
        });


        this.add(labelTitre);
        this.add(panelImageAndCombox,BorderLayout.NORTH);
        this.add(scrollPaneListEtudiant,BorderLayout.CENTER);
        this.add(panelRetour,BorderLayout.WEST);

        setVisible(true);

    }


    // updateTable
    public void updateTable() {
        String year = promotions[yearComboBox.getSelectedIndex()];
        List<Etudiant> etudiants = EtudiantDAO.getListEtudiant().stream()
                .filter(e -> e.getPromotion().equals(year))
                .collect(Collectors.toList());
        tableModelListEtudiant.setRowCount(0);
        System.out.println(year);
        tableModelListEtudiant.setRowCount(0);
        for (Etudiant etudiant : etudiants) {
            tableModelListEtudiant.addRow(new Object[]{etudiant.getNom(),etudiant.getPrenom(),etudiant.getMatricule()});
            System.out.println(etudiant.getMatricule());
        }
    }

}