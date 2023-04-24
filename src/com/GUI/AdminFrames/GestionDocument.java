package com.GUI.AdminFrames;

import com.DataBase.RequestDAO;
import com.Model2.Document;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GestionDocument extends MyFrame {

    public GestionDocument() {
        // Table of requests
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Object");
        tableModel.addColumn("Urgent");
        tableModel.addColumn("Date de demande");


        for (Document document : RequestDAO.getListRequest()) {
            tableModel.addRow(new Object[]{
                    document.getId(), document.getObjet(), document.estUrgent(), document.getDateDemande()});
        }

        JTable table = new JTable();
        table.setModel(tableModel);
        table.setBounds(360, 120, 600, 900);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(360, 120, 600, 600);
        add(scrollPane);

        // When a request is clicked upon, this opens its details page
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    int id = (int) table.getValueAt(row, 0);
                    dispose();
                    TraiterDemande frame = new TraiterDemande(id);
                }
            }
        });

        // Clear all requests
        MyButtons clear = new MyButtons("Clear" , Color.blue , Color.white , 90 , 270 , 150 , 50);
//        clear.addActionListener(e -> {
//            int confirm = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer toutes les demandes ?");
//            if (confirm == JOptionPane.YES_OPTION) {
//                RequestDAO.clearListRequest();
//                tableModel.setRowCount(0);
//            }
//        });
        add(clear);

        // Return to main admin page
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        Retour.addActionListener(e -> {
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

        setVisible(true);
    }
}