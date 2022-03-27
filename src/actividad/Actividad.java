package src.actividad;

import src.tipoActividad;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Actividad {
    private String titulo;
    private String descripcion;
    private String correo;
    private tipoActividad tipo;
    private Date fechaInicio;
    private Date fechaFinal;
    private int id;
    private int tiempoTrabajo;
    private Instant starts,ends;



    public Actividad(String correo, String titulo, String descripcion, tipoActividad tipo, Date fechaFinal, int id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaFinal = fechaFinal;
        this.id = id;
        this.correo = correo;

        fechaInicio = new Date();
        tiempoTrabajo = 0;
    }


    public void iniciarTrabajo(){
        starts = Instant.now();
    }

    public void terminarTrabajo(){
        ends = Instant.now();
        tiempoTrabajo+=(Duration.between(starts,ends).getSeconds());
    }

    public void setFechaInicio(Date fecha){
        fechaInicio = fecha;
    }
    public void setFechaFin(Date fecha){
        fechaFinal=fecha;
    }

    public void terminar() {
        fechaFinal = new Date();
    }

    public String consultarInformacion() {
        return ("Título: " + titulo +
                "\nDescripción: " + descripcion +
                "\nTipo: " + tipo +
                "\nFecha de Inicio: " + fechaInicio);
    }


}
