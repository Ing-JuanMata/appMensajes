package com.ingjuanmata.appmensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ing Juan Mata
 */
public class Conexion {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "mysql");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Conexion cerrada");
    }
}
