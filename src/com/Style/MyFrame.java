package com.Style;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static int frameWidth = 1050;
    public static int frameHeight = 650;


    /*
    This class is for styling frames
    */

    public MyFrame(){
        super("SchoolEase");
        getContentPane().setBackground(new Color(255, 255, 255));

        setResizable(false);
        setBounds(0 , 0 , frameWidth , frameHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon logo = new ImageIcon("images\\SchoolEase2.png");
        setIconImage(logo.getImage());
    }
}
