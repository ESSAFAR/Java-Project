package com.Style;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    /*
    This class is for styling frames
    */

    public MyFrame(){
        getContentPane().setBackground(new Color(236, 242, 255));
        setVisible(true);
        setResizable(false);
        setBounds(90 , 50 , 1100 , 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }
}
