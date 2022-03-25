package src.proyecto;


import src.actividad.Actividad;
import src.usuario.Duenio;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private ArrayList<Actividad> Actividades;
    private Duenio duenio;
    private int id;

    public Proyecto(String nombre, String descripcion, Duenio duenio, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duenio = duenio;
        this.id = id;
        Actividades = new ArrayList<Actividad>();
    }

    public void addActividad(Actividad actividad) {
        Actividades.add(actividad);
    }


    public void darInfoActividades() {

    }

    public void darParticipantes() {

    }

    public void darReporte(String correo) {

    }

    public String darInfoProyecto(){
        return ("\nNombre: "+nombre+"\nDescripción: "+descripcion
                + "\nid: "+id+"\nDueño: "+duenio.getName()+"\n");

    }

}
