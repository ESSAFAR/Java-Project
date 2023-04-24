package com.GUI.StudentFrame;

import com.DataBase.RequestDAO;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class FicheDemande extends MyFrame implements ActionListener {
    private JLabel objectLabel, textLabel;
    private JTextField objectField, textField;
    private JCheckBox urgentCheckBox;
    private JButton submitButton;
    private int idEtudiant;

    public FicheDemande(int idEtudiant){
        this.idEtudiant = idEtudiant;
        setTitle("Demander document");
        textLabel = new JLabel("Objet:");
        textLabel.setBounds(50, 100, 100, 30);
        add(textLabel);
        textField = new JTextField();
        textField.setBounds(150, 100, 800, 400);
        add(textField);
        urgentCheckBox = new JCheckBox("Urgent");
        urgentCheckBox.setBounds(50, 550, 100, 30);
        add(urgentCheckBox);
        submitButton = new JButton("Submit");
        submitButton.setBounds(450, 550, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Show the frame
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String text = textField.getText();
            boolean urgent = urgentCheckBox.isSelected();
            Date date = new Date();
            RequestDAO.addDemande(RequestDAO.generateId(), text, idEtudiant, false, date);
            textField.setText("");
            urgentCheckBox.setSelected(false);
        }
    }




}
