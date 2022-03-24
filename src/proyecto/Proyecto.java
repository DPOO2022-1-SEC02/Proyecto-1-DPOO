package src.proyecto;


import src.actividad.Actividad;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private ArrayList<Actividad> Actividades = new ArrayList<Actividad>();


    public void addActividad(Actividad actividad){
        Actividades.add(actividad);
    }

    public void crearProyecto(){

    }

    public void darProyecto() {

    }
    public void darInfoActividades() {

    }

    public void darParticipantes(){

    }

    public void darReporte(String correo){

    }

    public static void main(String[] args) {
        System.out.println("hola que hace");
    }



}
