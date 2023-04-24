package com.GUI.AdminFrames;
import com.DataBase.RequestDAO;
import com.Model2.Document;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;

public class TraiterDemande extends MyFrame {
    private JLabel objectLabel;
    private JLabel textLabel;
    private JLabel urgentLabel;
    private JButton retourButton;
    private JButton traiteButton;

    public TraiterDemande(int id) {
        Document document = null;
        document = RequestDAO.getRequest(id);

        objectLabel = new JLabel(document.getObjet());
        objectLabel.setBounds(200, 50, 800, 30);
        add(objectLabel);

        // Urgent label
        JLabel urgentTitleLabel = new JLabel(document.estUrgent()+"");
        urgentTitleLabel.setBounds(50, 520, 150, 30);
        add(urgentTitleLabel);

        urgentLabel = new JLabel(document.estUrgent() ? "Yes" : "No");
        urgentLabel.setBounds(200, 520, 150, 30);
        add(urgentLabel);

        // Retour button
        retourButton = new JButton("Retour");
        retourButton.setBounds(50, 570, 150, 30);
        add(retourButton);

        // Traite button
        traiteButton = new JButton("Docuement traite");
        traiteButton.setBounds(850, 520, 150, 30);
        traiteButton.addActionListener(e->{
            RequestDAO.deleteDemande(id);
        });
        RequestDAO.traiterDemande(id);
        add(traiteButton);

        // supprimer button
        MyButtons supprimer = new MyButtons("Docuement traite", Color.blue , Color.white , 90 , 470 , 150 , 50);
        supprimer.addActionListener(e->{
            RequestDAO.deleteDemande(id);
        });
        RequestDAO.deleteDemande(id);
        supprimer.addActionListener(e -> {

        });

        add(supprimer);

        MyButtons retour = new MyButtons("Retour" , Color.blue , Color.white , 90 , 470 , 150 , 50);
        retour.addActionListener(e->{
                dispose();
                GestionDocument frame = new GestionDocument();
        });



        setVisible(true);
    }




}


