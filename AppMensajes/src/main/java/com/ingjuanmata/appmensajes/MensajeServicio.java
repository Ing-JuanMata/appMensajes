package com.ingjuanmata.appmensajes;

import static javax.swing.JOptionPane.*;

/**
 * @author ing Juan Mata
 */
public class MensajeServicio {

    public static void escribirMensaje() {
        String contenido, autor;

        contenido = showInputDialog("Favor de ingresar el contenido del mensaje: ");
        autor = showInputDialog("Favor de ingresar el nombre del autor");

        if (MensajeDB.escribirMensaje(new Mensaje(contenido, autor))) {
            showMessageDialog(null, "Mensaje guardado");
        } else {
            showMessageDialog(null, "No se ha podido guardar el mensaje correctamente", "Error en escritura", ERROR_MESSAGE);
        }
    }

    public static void obtenerMensaje() {
        String strId = "";

        while (!esNumero(strId)) {
            strId = showInputDialog("Ingrese el id del mensaje que busca");
        }

        Mensaje mensaje = MensajeDB.obtenerMensaje(strId);

        showMessageDialog(null, mensaje);
    }

    public static void obtenerMensajes() {

        String mensajes = "";
        int contador = 0;

        for (Mensaje m : MensajeDB.obtenerMensajes()) {
            mensajes += m.toString();

            if (contador == 5) {
                showMessageDialog(null, mensajes);
                contador = 0;
                mensajes = "";
            } else {
                contador++;
            }
        }

        if (contador != 0) {
            showMessageDialog(null, mensajes);
        }

    }

    public static void editarMensaje() {

        String entrada = "";

        while (!esNumero(entrada)) {
            entrada = showInputDialog("Dame el id del mensaje");
        }

        if (MensajeDB.existeMensaje(entrada)) {
            String contenido, autor;
            Mensaje mensaje = MensajeDB.obtenerMensaje(entrada);

            autor = showInputDialog("Favor de escribir el nuevo nombre del autor", mensaje.getAutor());
            contenido = showInputDialog("Favor de escribir el nuevo contenido del mensaje", mensaje.getContenido());

            MensajeDB.editarMensaje(new Mensaje(contenido, autor), entrada);
        } else {
            showMessageDialog(null, "El mensaje que busca no existe en la base de datos");
        }

    }

    public static void eliminarMensaje() {
        String strId = "";

        while (!esNumero(strId)) {
            strId = showInputDialog("Dame el id del mensaje a eliminar");
        }

        if (MensajeDB.eliminarMensaje(strId)) {
            showMessageDialog(null, "Se ha eliminado el mensaje de manera correcta");
        } else {
            showMessageDialog(null, "El mensaje que desea borrar no existe");
        }
    }

    public static void eliminarMensajes() {
        String alerta = showInputDialog("¿Realmente desea eliminar los mensajes?[Y/N]");

        if (alerta.equalsIgnoreCase("Y")) {
            if(MensajeDB.eliminarMensajes()){
                showMessageDialog(null, "Limpieza de mensajes completada");
            }else {
                showMessageDialog(null, "Fallo en la limpieza de mensajes");
            }
        } else {
            showMessageDialog(null, "Limpieza de mensajes cancelada");
        }
    }

    private static boolean esNumero(String numero) {
        return numero.matches("^\\d+$");
    }
}
