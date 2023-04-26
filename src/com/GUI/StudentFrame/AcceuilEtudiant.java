/*
Apres authentification, si l'utlisateur est un admin, il fait le choix entre
gestion eleves
gestion profs
Entrer les notes
Communiquer les avis
 */

package com.GUI.StudentFrame;

import com.GUI.AdminFrames.GestionAvis;
import com.GUI.AdminFrames.FicheEtudiant;
import com.GUI.Login;
import com.Style.MyButtons;
import com.Style.MyFrame;
import com.DataBase.EtudiantDAO;

import javax.swing.*;
import java.awt.*;

public class AcceuilEtudiant extends MyFrame {
    String matricule;
    public AcceuilEtudiant(int matricule){
        //text : Bonjour + Prenom de l'Etudiant
        JLabel salutation = new JLabel("Bonjour "+ EtudiantDAO.getEtudiant(matricule).getPrenom());
        salutation.setBounds(220, 200, 400, 100);
        add(salutation);


        //Deconnection
        MyButtons deconnection = new MyButtons("Se Deconnecter", Color.blue , Color.white, 100 , 550 , 170 , 40);
        deconnection.addActionListener(e-> {
            dispose();
            Login login = new Login();
        });
        add(deconnection);

        //Logo
        JPanel logoContainer = new JPanel();
        logoContainer.setBounds(330 , 20 , 400 , 158);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("images/skol.png"));
        logoContainer.setBackground(new Color(0,0,0,0));
        logoContainer.add(logo);
        add(logoContainer);


        //Voir les notes
        MyButtons btn_eleves = new MyButtons("Mes notes" , Color.blue , Color.white , 250 , 300 , 250 , 50);
        add(btn_eleves);
        btn_eleves.addActionListener(e -> {
            dispose();
            NotesFrame notes = new NotesFrame(matricule);
        });






        //Avis
        MyButtons btn_professeurs = new MyButtons("Avis" , Color.blue , Color.white ,550 , 300 , 250 , 50);
        add(btn_professeurs);
        btn_professeurs .addActionListener(e -> {
            dispose();
            AvisEtudiant adminFrame4 = new AvisEtudiant(matricule);
        });




        //Emploi
        MyButtons btn_demande = new MyButtons("Demander un document" , Color.blue , Color.white ,250 , 430 , 250 , 50);
        add(btn_demande);
        btn_demande.addActionListener(e -> {
            dispose();

            GestionAvis Avis = new GestionAvis();
            FicheDemande frame = new FicheDemande(matricule);

        });



        //Profil eleve
        MyButtons btn_avis = new MyButtons("Ma fiche" , Color.blue , Color.white , 550 , 430 , 250 , 50);
        add(btn_avis);
        btn_avis.addActionListener(e -> {
            dispose();
            FicheEtudiant AvisJFrame = new FicheEtudiant(matricule, false);
        });


        //background
        JPanel imageContainer = new JPanel();
        imageContainer.setBounds(0 , 0 , 1050 , 650);
        JLabel sideImage = new JLabel();
        sideImage.setIcon(new ImageIcon("images/02.jpeg"));
        imageContainer.add(sideImage);
        add(imageContainer);

        setVisible(true);
    }

    public AcceuilEtudiant() {

    }
}
