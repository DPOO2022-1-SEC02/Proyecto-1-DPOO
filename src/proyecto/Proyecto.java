package src.proyecto;


import src.actividad.Actividad;
import src.usuario.Duenio;
import src.usuario.Participante;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private HashMap<String,Actividad> actividades;
    private ArrayList<Participante> participantes;
    private Duenio duenio;
    private int id;

    public Proyecto(String nombre, String descripcion, Duenio duenio, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duenio = duenio;
        this.id = id;
        actividades = new HashMap<>();
        participantes = new ArrayList<>();
    }

    public void addActividad(Actividad actividad) {
        actividades.put(actividad.getTitulo(),actividad);
    }


    public String darInfoActividades() {
        String retorno = "";
        if (actividades.isEmpty()){
            return "No hay actividades";
        }

        int contador=1;
        for (String titulo : actividades.keySet()) {
            Actividad actividad = actividades.get(titulo);
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

    public Actividad getActividad(String titulo){
        return actividades.get(titulo);
    }
}
