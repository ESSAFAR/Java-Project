package com.GUI;

import com.Style.MyButtons;
import com.Style.MyFrame;

import javax.swing.*;
import java.awt.*;

public class AdminFrame2 extends MyFrame {

    public AdminFrame2(){



        //Table of students
        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};

        String column[]={"ID","NAME","SALARY"};

        JTable studentsTable = new JTable(data , column);
        JScrollPane sp=new JScrollPane(studentsTable);

        studentsTable.setBounds(600,100,900,1000);
        add(studentsTable);
        add(sp);



        //Add a student
        MyButtons Ajouter = new MyButtons("Ajouter" , Color.blue , Color.white , 100 , 100 , 150 , 50);
        add(Ajouter);

        //Search a student
        MyButtons Rechercher = new MyButtons("Rechercher" , Color.blue , Color.white , 100 , 200 , 150 , 50);
        add(Rechercher);


        //delete a student
        MyButtons supprimer = new MyButtons("supprimer" , Color.blue , Color.white , 100 , 500 , 150 , 50);
        add(supprimer);






        setVisible(true);
    }





}
