/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.GUI.AdminFrames.AdminFrame1;
import com.Style.MyButtons;
import com.Style.MyFrame;

import java.awt.*;

public class AdminFrame3 extends MyFrame {

    public AdminFrame3(String matricule) {
        MyButtons btn = new MyButtons("Eleve de Matricule " + matricule , Color.blue , Color.white);
        add(btn);



        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 100 , 400 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            AdminFrame2 frame = new AdminFrame2();
        });
        add(Retour);



        setVisible(true);
    }
}
