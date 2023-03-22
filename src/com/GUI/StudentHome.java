package com.GUI;

import com.Style.MyButtons;
import com.Style.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentHome extends MyFrame {

    public StudentHome() {

        // Create a new JFrame object to serve as the main window of the dashboard
        JFrame dashboard = new JFrame("SchoolEase");
        dashboard.getContentPane().setBackground(new Color(240, 240, 240)); // Set the background color of the dashboard

        // Create a new JPanel object to serve as the top panel of the dashboard
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE); // Set the background color of the topPanel to white

        // Add an image to the top panel using the ImageIcon class and JLabel class
        ImageIcon icon = new ImageIcon("images/2345.png"); // Replace "path/to/image.jpg" with the actual file path of your image
        JLabel label = new JLabel(icon);
        topPanel.add(label);

        // Add the topPanel to the top of the dashboard using the add() method
        dashboard.add(topPanel, BorderLayout.NORTH);

        // Create a new JPanel object to serve as the left-side frame of the dashboard
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Set the background color of the buttonPanel to white

        // Set the layout manager of the buttonPanel to something that allows you to place buttons in a vertical column
        buttonPanel.setLayout(new GridLayout(6, 1, 0, 10)); // set vertical gap to 10px between buttons

        // Create 6 button objects using the MyButtons class and add them to the buttonPanel using the add() method
        MyButtons button1 = new MyButtons("1baby", Color.BLUE, Color.WHITE, 170, 650, 250, 50);
        buttonPanel.add(button1);

        MyButtons button2 = new MyButtons("2baby", Color.BLUE, Color.WHITE, 10, 650, 120, 50);
        button2.setPreferredSize(new Dimension(120, 60)); // set size of button 2
        buttonPanel.add(button2);

        MyButtons button3 = new MyButtons("3baby", Color.BLUE, Color.WHITE, 170, 650, 250, 50);
        button3.setPreferredSize(new Dimension(120, 60)); // set size of button 3
        buttonPanel.add(button3);

        MyButtons button4 = new MyButtons("4baby", Color.BLUE, Color.WHITE, 170, 650, 250, 50);
        button4.setPreferredSize(new Dimension(120, 60)); // set size of button 4
        buttonPanel.add(button4);

        MyButtons button5 = new MyButtons("5baby", Color.BLUE, Color.WHITE, 170, 650, 250, 50);
        button5.setPreferredSize(new Dimension(120, 60)); // set size of button 5
        buttonPanel.add(button5);

        MyButtons button6 = new MyButtons("6baby", Color.BLUE, Color.WHITE, 170, 650, 250, 50);
        button6.setPreferredSize(new Dimension(120, 60)); // set size of button 6
        buttonPanel.add(button6);

        // Add the buttonPanel to the left side of the dashboard using the add() method
        dashboard.add(buttonPanel, BorderLayout.WEST);

        // Set the size and visibility of the dashboard window
        dashboard.setSize(800, 600);
        dashboard.setVisible(true);

        // Add event listeners to the buttons to handle their actions when clicked
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 1 click
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 2 click
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 3 click
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 4 click
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 5 click
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 6 click
            }
        });

        // Create a new JPanel object to serve as the center panel of the dashboard
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE); // Set the background color of the centerPanel to white

// Set the layout manager of the centerPanel to BorderLayout
        centerPanel.setLayout(new BorderLayout());

// Create the text panel with the label and button as before
        JPanel textpanel = new JPanel();
        JLabel txt1 = new JLabel("Ceci est un texte de démonstration adfsafftyyyyy yt yrty t yrty ety ety tr r tye t");
        textpanel.add(txt1);
        JButton button = new JButton("Cliquez ici");
        textpanel.add(button);
        textpanel.setBackground(Color.RED);

// Add the text panel to the center region of the centerPanel using BorderLayout.CENTER
        centerPanel.add(textpanel, BorderLayout.CENTER);

// Add the centerPanel to the dashboard using BorderLayout.CENTER
        dashboard.add(centerPanel, BorderLayout.CENTER);




    }}