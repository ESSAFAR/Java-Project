import com.Style.MyButtons;
import com.Style.MyFrame;

import java.awt.*;

public class Login extends MyFrame {

    public Login() {
        setTitle("Login");
        MyButtons loginBtn = new MyButtons("Log in" , Color.BLUE);
        loginBtn.setBounds(400 , 200 , 300 , 50);
        add(loginBtn);
    }
}
