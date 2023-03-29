/*
Apres authentification, si l'utlisateur est un admin, il fait le choix entre
gestion eleves
gestion profs
Entrer les notes
Communiquer les avis
 */

package com.GUI.AdminFrames;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class AdminFrame1 extends MyFrame {
    public AdminFrame1(){

        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(90 , 50 , 400 , 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase4resized.png"));
        logoContainer.setBackground(new Color(0,0,0,0));
        logoContainer.add(logo);
        add(logoContainer);


        //Gestion eleves
        MyButtons btn_eleves = new MyButtons("Gestion eleves" , Color.blue , Color.white , 50 , 380 , 250 , 50);
        add(btn_eleves);
        btn_eleves.addActionListener(e -> {
            dispose();
            AdminFrame2 adminFrame2 = new AdminFrame2();
        });






        //Gestion prof
        MyButtons btn_professeurs = new MyButtons("Gestion professeurs" , Color.blue , Color.white ,570 , 380 , 250 , 50);
        add(btn_professeurs);
        btn_professeurs .addActionListener(e -> {
            dispose();
            AdminFrame4 adminFrame4 = new AdminFrame4();
        });



        //Gestion notes
        MyButtons btn_notes = new MyButtons("Gestion Notes" , Color.blue , Color.white , 290 , 530 , 250 , 50);
        add(btn_notes);
        btn_notes.addActionListener(e -> {
            dispose();
            AdminFrame6 adminFrame6 = new AdminFrame6();
        });


        //Communiquer un avis
        MyButtons btn_avis= new MyButtons("Gestion avis" , Color.blue , Color.white , 700 , 530 , 250 , 50);
        add(btn_avis);
        btn_avis.addActionListener(e -> {
            dispose();
            AnnouncementsFrame AnnouncementsFrame = new AnnouncementsFrame();
        });



        //centre image
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(600 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/blueBack.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);






        setVisible(true);
    }
}
