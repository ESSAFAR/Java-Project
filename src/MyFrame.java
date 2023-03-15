import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        getContentPane().setBackground(new Color(236, 242, 255));
        setVisible(true);
        setResizable(false);
        setBounds(10 , 40 , 1300 , 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
