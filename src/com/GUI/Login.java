package com.GUI;

import com.Style.MyButtons;
import com.Style.MyFrame;

import java.awt.*;

public class Login extends MyFrame {

    public Login() {
        setTitle("Login");
        MyButtons loginBtn = new MyButtons("Log in" , Color.BLUE , Color.WHITE) ;
        loginBtn.setBounds(100 , 150 , 350 , 50);
        add(loginBtn);
    }
}
