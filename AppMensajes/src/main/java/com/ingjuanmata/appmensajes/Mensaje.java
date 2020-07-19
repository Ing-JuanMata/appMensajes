package com.ingjuanmata.appmensajes;

import java.sql.Date;

/**
 * @author ing Juan Mata
 */
public class Mensaje {

    private int id;
    private String contenido, autor;
    private Date fecha;

    public Mensaje(String contenido, String autor) {
        this.contenido = contenido;
        this.autor = autor;
    }

    public Mensaje(int id, String contenido, String autor, Date fecha) {
        this.id = id;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Escrito por: " + autor + "\nid: " + id + "\nMensaje:\n" + contenido + "\n\n";
    }

}
