package Com.Style;

import javax.swing.*;
/*
This class is for styling buttons, the constructor takes the text, the color as arguments
 */

public class MyButtons extends JButton {
    String text;
    java.awt.Color color;
    java.awt.Color backgroundColor;
    java.awt.Color textColor;
    int x,y,width,height;


    public MyButtons(String text , java.awt.Color backgroundColor , java.awt.Color textColor) {
        super(text);
        setFont(getFont().deriveFont(16f));
        setBackground(backgroundColor);
        setForeground(textColor);
        setBounds(190 , 250 , 250 , 50);
        setFocusPainted(false);

        setFocusable(false);
    }

    public MyButtons(String text , java.awt.Color backgroundColor , java.awt.Color textColor , int x, int y, int width, int height) {
        this(text , backgroundColor , textColor);
        setBounds(x , y , width , height);
    }

}
