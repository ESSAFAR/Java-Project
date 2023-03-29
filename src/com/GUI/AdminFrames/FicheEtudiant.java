/*
A personnal page for the student(matricule)
*/

package com.GUI.AdminFrames;

import com.Style.MyButtons;
import com.Style.MyFrame;

import java.awt.*;

public class FicheEtudiant extends MyFrame {

    public FicheEtudiant(String matricule) {
        MyButtons btn = new MyButtons("Eleve de Matricule " + matricule , Color.blue , Color.white);
        add(btn);



        //Retour
        MyButtons Retour = new MyButtons("Retour" , Color.blue , Color.white , 100 , 400 , 150 , 50);
        Retour.addActionListener(e -> {
            dispose();
            GestionEtudiants frame = new GestionEtudiants();
        });
        add(Retour);



        setVisible(true);
    }
}