/*
Apres authentification, si l'utlisateur est un admin, il fait le choix entre
gestion eleves
gestion profs
Entrer les notes
Communiquer les avis
 */

package com.GUI.StudentFrame;

import com.GUI.AdminFrames.Avis;
import com.GUI.AdminFrames.GestionNotes;
import com.GUI.AdminFrames.FicheEtudiant;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class AcceuilEtudiant extends MyFrame {
    String matricule;
    public AcceuilEtudiant(String matricule){

        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(500 , 50 , 400 , 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase4resized.png"));
        logoContainer.setBackground(new Color(0,0,0,0));
        logoContainer.add(logo);
        add(logoContainer);


        //Voir les notes
        MyButtons btn_eleves = new MyButtons("Mes notes" , Color.blue , Color.white , 50 , 380 , 250 , 50);
        add(btn_eleves);
        btn_eleves.addActionListener(e -> {
            dispose();
            GestionNotes notes = new GestionNotes();
        });






        //Avis
        MyButtons btn_professeurs = new MyButtons("Avis" , Color.blue , Color.white ,570 , 380 , 250 , 50);
        add(btn_professeurs);
        btn_professeurs .addActionListener(e -> {
            dispose();
            Avis adminFrame4 = new Avis();
        });




        //Emploi
        MyButtons btn_emploi = new MyButtons("Voir Emploi" , Color.blue , Color.white , 700 , 530 , 250 , 50);
        add(btn_emploi);
        btn_emploi.addActionListener(e -> {
            dispose();
            Avis Avis = new Avis();
        });



        //Profil eleve
        MyButtons btn_avis = new MyButtons("Ma fiche" , Color.blue , Color.white , 700 , 530 , 250 , 50);
        add(btn_avis);
        btn_avis.addActionListener(e -> {
            dispose();
            FicheEtudiant AvisJFrame = new FicheEtudiant(matricule);
        });



        //centre image
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(getWidth()-400 , 0 , 400 , getHeight());
        imageContainer.setBackground(Color.pink);
        add(imageContainer);






        setVisible(true);
    }
}
