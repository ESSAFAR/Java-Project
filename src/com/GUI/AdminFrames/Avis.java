package com.GUI.AdminFrames;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Avis extends MyFrame {
    private JPanel announcementsPanel;
    private List<String> avis;

    public Avis() {

        //Cette liste comporte les avis à affiches
        avis = new ArrayList<>();


        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 250 , 50 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            AcceuilAdmin frame = new AcceuilAdmin();
        });
        add(Retour);

        // Ce button permet d'ajouter des nouveaux avis
        MyButtons AjouterAvisButton = new MyButtons("Ajouter un avis" , Color.blue , Color.white , 80 , 50 , 150 , 50);
        add(AjouterAvisButton);

        int distanceEntreAvis = 50;
        for (String avis : avis) {
            JLabel avisLabel = new JLabel(avis);
            avisLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            avisLabel.setBounds(10, distanceEntreAvis, 200, 30);
            add(avisLabel);
            distanceEntreAvis += 40; // Increase the distanceEntreAvis-coordinate for the next label
        }

        // Add an action listener pour ajouter les avis

        AjouterAvisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnnouncementFrame();
            }
        });


        setVisible(true);
    }

    // Ajouter l'avis au liste
    public void addAnnouncement(String avis) {
        this.avis.add(avis);
        JLabel announcementLabel = new JLabel(avis);
        announcementLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        announcementLabel.setBounds(10, this.avis.size() * 40 + 10, 200, 30);
        add(announcementLabel);
        revalidate();
        repaint();
    }

    // Un frame qui s'affiche pour saisir l'avis
    private class AddAnnouncementFrame extends JFrame {
        private JTextField avisField;

        public AddAnnouncementFrame() {
            JPanel addAnnouncementPanel = new JPanel();
            addAnnouncementPanel.setLayout(null);
            JLabel announcementLabel = new JLabel("Entrer un avis:");
            announcementLabel.setBounds(10, 10, 100, 30);
            addAnnouncementPanel.add(announcementLabel);

            avisField = new JTextField();
            avisField.setBounds(10, 130, 870, 200);
            addAnnouncementPanel.add(avisField);
            avisField.selectAll();
//            avisField.setCaretPosition(0);
            avisField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // add padding
            avisField.setCaretColor(Color.WHITE); // customize caret color
            setForeground(Color.WHITE); // customize text color



            avisField.setFont(new Font("Arial",Font.PLAIN,20));
            MyButtons  submitButton = new MyButtons("Submit" , Color.blue ,Color.WHITE);
            submitButton.setBounds(10, 50, 100, 30);
            addAnnouncementPanel.add(submitButton);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String announcement = avisField.getText();
                    if (!announcement.equals("")){
                        addAnnouncement(announcement);
                    }
                    dispose(); // Close the add announcement frame
                }
            });

            // Add the add announcement panel to the frame
            add(addAnnouncementPanel);

            setSize(900, 500);
            setVisible(true);
        }
    }}