package com.Style;

import javax.swing.*;
/*
This class is for styling buttons, the constructor takes the text, the color as arguments
 */

public class MyButtons extends JButton {
    String text;
    java.awt.Color color;

    public MyButtons(String text , java.awt.Color color) {
        super(text);
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        setFont(getFont().deriveFont(16f));
        setBackground(color);
        setForeground(java.awt.Color.WHITE);
        setFocusPainted(false);
    }

}
