import com.GUI.Login;
import com.jdbc.JdbConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Connection con = JdbConnection.getConnection();
        if( con == null){
            System.out.println("connection failure !!"); }
        else{
            System.out.println("connection succes !!");
        }


    }
}