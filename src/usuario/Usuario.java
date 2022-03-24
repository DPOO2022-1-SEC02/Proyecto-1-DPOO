package src.usuario;

import src.actividad.Actividad;
import src.tipoActividad;

import java.util.ArrayList;

public class Usuario {
    protected String nombre;
    protected String correo;
    private ArrayList<Actividad> actividades = new ArrayList<>();

    public void recibirReporte() {

    }
    public void inciarActividad(String correo, String nombreActividad, tipoActividad tipo, String descripcion){
        Actividad actividad = new Actividad();
    }
    public void finalizarActividad(String correo,String nombreActividad){
        
    }

}
