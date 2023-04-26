package com.GUI.AdminFrames;

import com.Model2.Etudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GestionEtudiants extends MyFrame {

    private JComboBox<String> yearComboBox;
    private DefaultTableModel tableModel;
    private JTable table;
    private String[] yearOptions = {"1A", "2A", "3A"};


    public GestionEtudiants() {

        // JComboBox for selecting year
        yearComboBox = new JComboBox<>(yearOptions);
        yearComboBox.setBounds(50, 120, 150, 30);
        yearComboBox.addActionListener(e -> updateTable());
        add(yearComboBox);

        // Table of students
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Matricule");
        tableModel.addColumn("Nom");
        tableModel.addColumn("Prenom");
        JTable table = new JTable();
        table.setModel(tableModel);
        table.setBounds(360, 120, 600, 900);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(360, 120, 600, 600);
        add(scrollPane);

        // When a student is clicked upon, this opens his personal page
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                int matricule = (int) table.getValueAt(row, 0);
                dispose();
                FicheEtudiant frame = new FicheEtudiant(matricule, true);
            }
        });

        // Add a student
        MyButtons Ajouter = new MyButtons("Ajouter" , Color.blue , Color.white , 90 , 170 , 150 , 50);
        Ajouter.addActionListener(e -> {
            dispose();
            FicheEtudiant ficheEtudiant = new FicheEtudiant(EtudiantDAO.generateMatricule(), true);
        });
        add(Ajouter);

        // Delete all data
        MyButtons clear = new MyButtons("Suprimer tous les étudiant " , Color.blue , Color.white , 90 , 270 , 150 , 50);
        clear.addActionListener(e -> {
            int confirmation = JOptionPane.showConfirmDialog(null, "Attention! tous les étudiants de cette promotion vont etre supprimes", "Attention!", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                String year = yearOptions[yearComboBox.getSelectedIndex()];
                List<Etudiant> etudiants = EtudiantDAO.getListEtudiant().stream()
                        .filter(e1 -> e1.getPromotion().equals(year))
                        .collect(Collectors.toList());
                for (Etudiant etudiant : etudiants) {
                    EtudiantDAO.delete(etudiant.getMatricule());
                }
                updateTable();
            }
        });

        add(clear);

        // Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        Retour.addActionListener(e1 -> {
            dispose();
            AcceuilAdmin frame = new AcceuilAdmin();
        });
        add(Retour);

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0, 0, 1050, 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/04.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);

        updateTable();

        setVisible(true);
    }


    private void updateTable() {
        String year = yearOptions[yearComboBox.getSelectedIndex()];
        List<Etudiant> etudiants = EtudiantDAO.getListEtudiant().stream()
                .filter(e -> e.getPromotion().equals(year))
                .collect(Collectors.toList());
        tableModel.setRowCount(0);
        System.out.println(year);
        tableModel.setRowCount(0);
        for (Etudiant etudiant : etudiants) {
            tableModel.addRow(new Object[]{
                    etudiant.getMatricule(), etudiant.getNom(), etudiant.getPrenom()
            });
        }
    }
}

