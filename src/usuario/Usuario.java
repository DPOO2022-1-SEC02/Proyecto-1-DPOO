package src.usuario;

import src.actividad.Actividad;
import src.proyecto.PrManager;
import src.proyecto.Proyecto;
import src.tipoActividad;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    protected String nombre;
    protected String correo;
    protected Proyecto prActual;


    private ArrayList<Actividad> actividades = new ArrayList<>();


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
    }

    public void iniciarActividadExt(String correo, String nombreActividad, tipoActividad tipo, String descripcion, Date fechaFinal) {
        Actividad actividad = new Actividad(correo, nombreActividad, descripcion, tipo, fechaFinal, prActual.getActividadesSize());
        prActual.addActividad(actividad);
    }

    public void finalizarActividad(String correo, String nombreActividad) {

    }

    public String getName() {
        return nombre;
    }
}
