package src.actividad;

import src.tipoActividad;
import java.util.Date;

public class Actividad {
    private String titulo;
    private String descripcion;
    private String correo;
    private tipoActividad tipo;
    private Date fechaInicio;
    private Date fechaFinal;
    private int id;


    public Actividad(String correo,String titulo, String descripcion, tipoActividad tipo, Date fechaFinal,int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaFinal = fechaFinal;
        this.id = id;
        this.correo = correo;

        fechaInicio = new Date();
    }

    public String consultarInformacion() {
        return ("Título: " + titulo +
                "\nDescripción: " + descripcion +
                "\nTipo: " + tipo +
                "\nFecha de Inicio: " + fechaInicio);
    }



}
