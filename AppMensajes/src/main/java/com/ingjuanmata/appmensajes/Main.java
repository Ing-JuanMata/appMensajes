package com.ingjuanmata.appmensajes;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ing Juan Mata
 */
public class Main {

    public static void main(String[] args) {

        Conexion con = new Conexion();

        try ( Connection cnx = con.get_connection()) {

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
