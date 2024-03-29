/*
Apres authentification, si l'utlisateur est un admin, il fait le choix entre
gestion eleves
gestion profs
Entrer les notes
Communiquer les avis
 */

package com.GUI.AdminFrames;

import com.GUI.Login;
import com.GUI.StudentFrame.FicheDemande;
import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class AcceuilAdmin extends MyFrame {
    public AcceuilAdmin(){

        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(330 , 20 , 400 , 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/SchoolEase4resized.png"));
        logoContainer.setBackground(new Color(0,0,0,0));
        logoContainer.add(logo);
        add(logoContainer);


        //Gestion eleves
        MyButtons btn_eleves = new MyButtons("Gestion eleves" , Color.blue , Color.white , 250 , 300 , 250 , 50);
        add(btn_eleves);
        btn_eleves.addActionListener(e -> {
            dispose();
            GestionEtudiants gestionEtudiants = new GestionEtudiants();
        });






        //Gestion prof
        MyButtons btn_professeurs = new MyButtons("Gestion demandes" , Color.blue , Color.white ,550 , 300 , 250 , 50);
        add(btn_professeurs);
        btn_professeurs .addActionListener(e -> {
            dispose();
            GestionDocument frame = new GestionDocument();
        });



        //Gestion notes
        MyButtons btn_notes = new MyButtons("Gestion Notes" , Color.blue , Color.white , 250 , 430 , 250 , 50);
        add(btn_notes);
        btn_notes.addActionListener(e -> {
            dispose();
            GestionNotes gestionNotes = new GestionNotes();
        });


        //Communiquer un avis
        MyButtons btn_avis= new MyButtons("Gestion avis" , Color.blue , Color.white , 550 , 430 , 250 , 50);
        add(btn_avis);
        btn_avis.addActionListener(e -> {
            dispose();
            GestionAvis Avis = new GestionAvis();
        });


        //Deconnection
        MyButtons deconnection = new MyButtons("Se Deconnecter", Color.blue , Color.white, 100 , 550 , 170 , 40);
        deconnection.addActionListener(e-> {
            dispose();
            Login login = new Login();
        });
        add(deconnection);



        //centre image
        //JPanel imageContainer = new JPanel();
        //imageContainer.setBounds(getWidth()-400 , 0 , 400 , getHeight());
        //imageContainer.setBackground(Color.pink);
        //imageContainer.setBounds(600 , 0 , 1050 , 650);
        //JLabel sideImage = new JLabel();
        //sideImage.setIcon(new ImageIcon("images/blueBack.jpeg"));
        //imageContainer.add(sideImage);
        //add(imageContainer);

        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/01.jpg"));
        imageContainer.add(sideImage);
        add(imageContainer);




        setVisible(true);
    }
}
