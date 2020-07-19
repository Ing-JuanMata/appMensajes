package com.ingjuanmata.appmensajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ing Juan Mata
 */
public class MensajeDB {

    private static ResultSet rs;
    private static PreparedStatement ps;
    private static final Connection con = Conexion.getConnection();

    public static boolean escribirMensaje(Mensaje mensaje) {

        String query = "INSERT INTO mensajes(mensaje, autor) VALUES(?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, mensaje.getContenido());
            ps.setString(2, mensaje.getAutor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public static Mensaje obtenerMensaje(String id) {

        String sql = "SELECT mensaje, autor FROM mensajes m WHERE m.id=? ";
        String contenido = "No existe el mensaje", autor = "System";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                contenido = rs.getString(1);
                autor = rs.getString(2);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Mensaje(contenido, autor);
    }

    public static Mensaje[] obtenerMensajes() {

        Mensaje mensajes[];
        Date fecha;
        String sql = "SELECT COUNT(*) FROM mensajes", autor, contenido;
        int size = 0, id, i = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                size = rs.getInt(1);
            }

            if (size > 0) {
                mensajes = new Mensaje[size];
            } else {
                mensajes = new Mensaje[1];
                mensajes[0] = new Mensaje("No hay mensajes", "System");
                return mensajes;
            }

            sql = "SELECT id, mensaje, autor, fecha FROM mensajes";
            rs = ps.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt(1);
                contenido = rs.getString(2);
                autor = rs.getString(3);
                fecha = rs.getDate(4);

                mensajes[i] = new Mensaje(id, contenido, autor, fecha);
                i++;
            }

            return mensajes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mensajes = new Mensaje[1];
            mensajes[0] = new Mensaje("No hay mensajes", "System");
            return mensajes;
        }
    }

    public static boolean editarMensaje(Mensaje nuevo, String id) {

        String sql = "UPDATE mensajes SET mensaje=?, autor=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getContenido());
            ps.setString(2, nuevo.getAutor());
            ps.setString(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean eliminarMensaje(String id) {

        if (existeMensaje(id)) {

            String sql = "DELETE FROM mensajes WHERE id=?";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.executeUpdate();

                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }

        } else {
            return false;
        }

    }

    public static boolean eliminarMensajes() {
        String sql = "DELETE FROM mensajes";

        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean existeMensaje(String id) {

        String sql = "SELECT * FROM mensajes m WHERE m.id=? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
