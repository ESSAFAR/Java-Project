package com.GUI.AdminFrames;

import com.DataBase.RequestDAO;
import com.Model2.Document;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class TraiterDemande extends MyFrame {

    private JLabel objectLabel;
    private JLabel textLabel;
    private JLabel urgentLabel;
    private JButton retourButton;
    private JButton traiteButton;

    public TraiterDemande(int id) {
        Document document = RequestDAO.getRequest(id);

        objectLabel = new JLabel("Objet : " + document.getObjet());
        objectLabel.setBounds(50, 50, 500, 30);
        add(objectLabel);


        // Urgent label
        JLabel urgentTitleLabel = new JLabel("Urgent :");
        urgentTitleLabel.setBounds(50, 150, 150, 30);
        add(urgentTitleLabel);

        urgentLabel = new JLabel(document.estUrgent());
        urgentLabel.setBounds(200, 150, 150, 30);
        add(urgentLabel);

        // Traite button
        traiteButton = new MyButtons("traité", Color.blue, Color.white, 50, 220, 150, 50);
        traiteButton.addActionListener(e -> {
            RequestDAO.deleteDemande(id);
            dispose();
        });
        add(traiteButton);

        // Retour button
        retourButton = new MyButtons("Retour", Color.blue, Color.white, 220, 220, 150, 50);
        retourButton.addActionListener(e -> {
            dispose();
            GestionDocument frame = new GestionDocument();
        });
        add(retourButton);

        setVisible(true);
    }
}
