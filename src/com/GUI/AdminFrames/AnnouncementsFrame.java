package com.GUI.AdminFrames;

import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementsFrame extends MyFrame {
    private JPanel announcementsPanel;
    private List<String> announcements;

    public AnnouncementsFrame() {
        // Initialize the announcements list
        announcements = new ArrayList<>();

        // Create the announcements panel with a null layout
        announcementsPanel = new JPanel();
        announcementsPanel.setBounds(0 , 0, this.getWidth() , this.getHeight());
        announcementsPanel.setLayout(null);

        // Add a button to open the add announcement frame
        JButton addAnnouncementButton = new JButton("Add Announcement");
        addAnnouncementButton.setBounds(10, 10, 150, 30);
        announcementsPanel.add(addAnnouncementButton);

        // Add a label for each announcement in the list
        int y = 50;
        for (String announcement : announcements) {
            JLabel announcementLabel = new JLabel(announcement);
            announcementLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            announcementLabel.setBounds(10, y, 200, 30);
            announcementsPanel.add(announcementLabel);
            y += 40; // Increase the y-coordinate for the next label
        }

        // Add an action listener to the button to open the add announcement frame
        addAnnouncementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnnouncementFrame();
            }
        });

        // Add the announcements panel to the frame
        add(announcementsPanel, BorderLayout.CENTER);

        // Set the frame properties
        setVisible(true);
    }

    // Method to add a new announcement to the list and update the announcements panel
    public void addAnnouncement(String announcement) {
        announcements.add(announcement);
        JLabel announcementLabel = new JLabel(announcement);
        announcementLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        announcementLabel.setBounds(10, announcements.size() * 40 + 10, 200, 30);
        announcementsPanel.add(announcementLabel);
        announcementsPanel.revalidate();
        announcementsPanel.repaint();
    }

    // Inner class for the add announcement frame
    private class AddAnnouncementFrame extends JFrame {
        private JTextField announcementField;

        public AddAnnouncementFrame() {
            // Create the add announcement panel with a null layout
            JPanel addAnnouncementPanel = new JPanel();
            addAnnouncementPanel.setLayout(null);

            // Add a label and text field for the announcement text
            JLabel announcementLabel = new JLabel("Announcement:");
            announcementLabel.setBounds(10, 10, 100, 30);
            addAnnouncementPanel.add(announcementLabel);

            announcementField = new JTextField();
            announcementField.setBounds(110, 10, 400, 200);
            addAnnouncementPanel.add(announcementField);

            // Add a button to submit the announcement
            JButton submitButton = new JButton("Submit");
            submitButton.setBounds(10, 50, 100, 30);
            addAnnouncementPanel.add(submitButton);

            // Add an action listener to the button to add the announcement to the list
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String announcement = announcementField.getText();
                    addAnnouncement(announcement);
                    dispose(); // Close the add announcement frame
                }
            });

            // Add the add announcement panel to the frame
            add(addAnnouncementPanel, BorderLayout.CENTER);

            setSize(900, 500);
            setVisible(true);
        }
    }}