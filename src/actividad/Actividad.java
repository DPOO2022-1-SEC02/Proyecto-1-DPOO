package src.actividad;

import src.tipoActividad;

import java.sql.Time;
import java.util.Date;

public class Actividad {
    private String titulo;
    private String descripcion;
    private String correo;
    private tipoActividad tipo;
    private Date fechaInicio;
    private Date fechaFinal;
    private Time horaIncio;
    private Time horaFinal;
    private int id;


    public Actividad(String correo,String titulo, String descripcion, tipoActividad tipo, Date fechaFinal, Time horaFinal,int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaFinal = fechaFinal;
        this.horaFinal = horaFinal;
        this.id = id;
        this.correo = correo;
    }

    public String consultarInformacion() {
        return ("Título: " + titulo +
                "Descripción: " + descripcion +
                "Tipo: " + tipo +
                "Fecha de Inicio: " + fechaInicio);
    }



}
