package com.ingjuanmata.appmensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ing Juan Mata
 */
public class Conexion {

    public Connection get_connection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "mysql");

            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return con;
    }
}
