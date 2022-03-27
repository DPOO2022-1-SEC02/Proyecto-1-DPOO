package src.proyecto;


import src.actividad.Actividad;
import src.usuario.Duenio;
import src.usuario.Participante;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private ArrayList<Actividad> actividades;
    private ArrayList<Participante> participantes;
    private Duenio duenio;
    private int id;

    public Proyecto(String nombre, String descripcion, Duenio duenio, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duenio = duenio;
        this.id = id;
        actividades = new ArrayList<>();
        participantes = new ArrayList<>();
    }

    public void addActividad(Actividad actividad) {
        actividades.add(actividad);
    }


    public String darInfoActividades() {
        String retorno = "";
        if (actividades.isEmpty()){
            return "No hay actividades";
        }

        int contador=1;
        for (Actividad actividad : actividades) {
            retorno += "\nActividad "+contador+"\n";
            retorno += actividad.consultarInformacion()+"\n";
            contador++;
        }
        return retorno;
    }

    public String darParticipantes() {
        String retorno = "Dueño: "+duenio.getName();
        if(participantes.isEmpty()){
            retorno+="\nNo hay participantes";
            return retorno;
        }
        int contador=1;
        for (Participante participante : participantes) {
            retorno += "\nParticipante "+contador+"\n";
            retorno += participante.consultarInformacion();
            contador++;
        }
        return retorno;
    }

    public void darReporte(String correo) {

    }

    public String darInfoProyecto() {
        return ("\nNombre: " + nombre + "\nDescripción: " + descripcion
                + "\nid: " + id + "\nDueño: " + duenio.getName()
                + "\nCantidad de actividades:" + actividades.size() + "\n");

    }

    public int getActividadesSize() {
        return actividades.size();
    }

    public Duenio getDuenio(){
        return duenio;
    }

    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    public Actividad getActividad(int id){
        return actividades.get(id);
    }
}
