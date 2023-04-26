package com.GUI.StudentFrame;

import com.DataBase.RequestDAO;
import com.GUI.AdminFrames.GestionDocument;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class FicheDemande extends MyFrame implements ActionListener {
    private JLabel objectLabel, textLabel;
    private JTextField objectField, textField;
    private JCheckBox urgentCheckBox;
    MyButtons submitButton;
    private int idEtudiant;

    public FicheDemande(int idEtudiant){
        this.idEtudiant = idEtudiant;
        setTitle("Demander document");
        textLabel = new JLabel("Objet:");
        textLabel.setBounds(50, 120, 100, 30);
        add(textLabel);
        textField = new JTextField();
        textField.setBounds(150, 130, 800, 400);
        textField.setBounds(150, 100, 400, 30);
        add(textField);
        urgentCheckBox = new JCheckBox("Urgent");
        urgentCheckBox.setBounds(50, 150, 100, 30);
        add(urgentCheckBox);
        submitButton = new MyButtons("Submit", Color.blue, Color.white,150, 200, 100, 30 );
        submitButton.addActionListener(this);
        add(submitButton);
        MyButtons retourButton = new MyButtons("Retour", Color.blue, Color.white, 300, 200, 100, 30);
        retourButton.addActionListener(e -> {
            dispose();
            AcceuilEtudiant frame = new AcceuilEtudiant(idEtudiant);
        });
        add(retourButton);

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/09.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);

        // Show the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String text = textField.getText();
            boolean urgent = urgentCheckBox.isSelected();
            Date date = new Date();
            RequestDAO.addDemande(RequestDAO.generateId(), text, idEtudiant, false, urgent?"urgent":"non urgent", date);
            textField.setText("");
            urgentCheckBox.setSelected(false);
            dispose();
            AcceuilEtudiant frame = new AcceuilEtudiant(idEtudiant);
        }
    }




}
