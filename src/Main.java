import com.GUI.Login;
import com.DataBase.DBConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Connection con = DBConnection.getConnection();
        if( con == null){
            System.out.println("connection failure !!"); }
        else{
            System.out.println("connection succes !!");

        }


    }
}