package com.Style;

import javax.swing.*;
/*
This class is for styling buttons, the constructor takes the text, the color as arguments
 */

public class MyButtons extends JButton {
    String text;
    java.awt.Color color;
    java.awt.Color backgroundColor;
    java.awt.Color textColor;


    public MyButtons(String text , java.awt.Color backgroundColor , java.awt.Color textColor) {
        super(text);
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        setFont(getFont().deriveFont(16f));
        setBackground(backgroundColor);
        setForeground(textColor);
        setFocusPainted(false);
        setFocusable(false);
    }

}
