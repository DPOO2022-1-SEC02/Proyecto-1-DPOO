package src.usuario;

import src.actividad.Actividad;
import src.proyecto.PrManager;
import src.proyecto.Proyecto;
import src.tipoActividad;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected Proyecto prActual;


    private ArrayList<Actividad> actividades = new ArrayList<>();

    @Override
    public boolean equals(Object usuario2){
        if (this.getEmail().equals(((Usuario) usuario2).getEmail())){
            return true;
        }
        return false;
    }

    public void setProyecto(Proyecto proyectoEntrada) {
        prActual = proyectoEntrada;
    }

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public void recibirReporte() {

    }

    public void inciarActividad(String nombreActividad, tipoActividad tipo, String descripcion, Date fechaFinal) {
        Actividad actividad = new Actividad(correo, nombreActividad, descripcion, tipo, fechaFinal, prActual.getActividadesSize());
        prActual.addActividad(actividad);
        actividades.add(actividad);
    }

    public void iniciarActividadExt(String correo, String nombreActividad, tipoActividad tipo, String descripcion, Date fechaFinal) {
        Actividad actividad = new Actividad(correo, nombreActividad, descripcion, tipo, fechaFinal, prActual.getActividadesSize());
        prActual.addActividad(actividad);
    }

    public String consultarInformacion(){
        return("Nombre: "+nombre
        +"\nCorreo: "+correo+"\n");
    }

    public void finalizarActividad(String correo, String nombreActividad) {

    }

    public void addActividad(Actividad actividad){
        actividades.add(actividad);
    }

    public String getName() {
        return nombre;
    }

    public String getEmail(){
        return correo;
    }
}
