package com.GUI.StudentFrame;

import com.Style.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FicheDemande extends MyFrame implements ActionListener {
    private JLabel objectLabel, textLabel;
    private JTextField objectField, textField;
    private JCheckBox urgentCheckBox;
    private JButton submitButton;

    public FicheDemande(){
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

            // Process the request (replace with actual code to handle the request)
            System.out.println("Text: " + text);
            System.out.println("Urgent: " + urgent);

            // Clear the input fields
            textField.setText("");
            urgentCheckBox.setSelected(false);
        }
    }




}
