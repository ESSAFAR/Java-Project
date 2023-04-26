package com.DataBase;

import com.Model2.ElementModule;

import java.sql.Connection;
import java.sql.*;

public class ElementModuleDAO {

    private static Connection conn = DBConnection.getConnection();
    public static int elementModuleExiste(String name) {

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM element_module WHERE nom = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}