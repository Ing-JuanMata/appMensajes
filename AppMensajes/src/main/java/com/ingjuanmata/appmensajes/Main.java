package com.ingjuanmata.appmensajes;

import java.util.Scanner;
import static javax.swing.JOptionPane.*;

/**
 * @author ing Juan Mata
 */
public class Main {

    public static void main(String[] args) {

        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        do {

            while (!entrada.matches("^\\d$")) {
                entrada = showInputDialog("Favor de seleccionar una opcion:"
                        + "\n1. Nuevo mensaje"
                        + "\n2. Buscar un mensaje"
                        + "\n3. Editar un mensaje"
                        + "\n4. Borrar un mensaje"
                        + "\n5. Listar mensajes"
                        + "\n6. Eliminar todos los mensajes"
                        + "\n0. Salir");

                if (!entrada.matches("^\\d$")) {
                    System.out.println("Favor de ingresar un digito valido");
                }
            }

            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 0 ->
                    System.out.println("Hasta luego");
                case 1 ->
                    MensajeServicio.escribirMensaje();
                case 2 ->
                    MensajeServicio.obtenerMensaje();
                case 3 ->
                    MensajeServicio.editarMensaje();
                case 4 ->
                    MensajeServicio.eliminarMensaje();
                case 5 ->
                    MensajeServicio.obtenerMensajes();
                case 6 ->
                    MensajeServicio.eliminarMensajes();
                default ->
                    System.out.println("Favor de ingresar un digito valido");
            }

            if (opcion != 0) {
                entrada = "";
            }

        } while (opcion != 0);

        Conexion.closeConnection();
    }
}
