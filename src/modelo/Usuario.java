package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected Proyecto prActual;


    private ArrayList<Actividad> actividades = new ArrayList<>();

    @Override
    public boolean equals(Object usuario2) {
        if (this.getEmail().equals(((Usuario) usuario2).getEmail())) {
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

    public String generarReporte() {
        String reporteTxt ="--- Inicio del reporte ---";
        int tiempoTotalTrabajo,tiempo,tiempoTipo;
        HashMap<LocalDate, Integer> tiempoPorDia;
        HashMap<String,Integer> tiempoPorTipo;
        int numActividades;
    	Reporte reporte = new Reporte(actividades); 
    	
    	
    	tiempoTotalTrabajo = reporte.tiempoTrabajo();
    	tiempoPorDia = reporte.tiempoTrabajoDia();
    	tiempoPorTipo = reporte.tiempoTrabajoTipo();
    	numActividades = reporte.cantActividades();
    	
    	reporteTxt += "Tiempo total trabajado" + " : "+ tiempoTotalTrabajo +"\n";
    	reporteTxt += "Numero total de actividades trabajadas es: " + numActividades+"\n";
    	reporteTxt+="Tiempo trabajado diariamente: \n";
    	for (LocalDate fecha : tiempoPorDia.keySet()) {
			tiempo = tiempoPorDia.get(fecha);
			reporteTxt+="\t-"+fecha+": "+tiempo+"\n";
		
			
		}
    	
    	reporteTxt += "El tiempo de trabajo por tipo de actividad es : \n";
    	for (String tipo : tiempoPorTipo.keySet()) {
    		tiempoTipo = tiempoPorTipo.get(tipo);
    		reporteTxt += "\t-"+ tipo + ": "+ tiempoTipo +"\n";
    		
    		 
		}
    	reporteTxt += "--- Fin del reporte ---";
    	return reporteTxt;
    	
    	
    }

    public void inciarActividad(String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad, nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        prActual.addActividad(actividad);
        actividades.add(actividad);
    }

    public void iniciarActividadExt(String correo, String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad,nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        prActual.addActividad(actividad);
    }

    public String consultarInformacion() {
        return ("Nombre: " + nombre
                + "\nCorreo: " + correo + "\n");
    }

    public void finalizarActividad(String correo, String nombreActividad) {

    }

    public Proyecto getPrActual() {
        return prActual;
    }

    public void addActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public String getName() {
        return nombre;
    }

    public String getEmail() {
        return correo;
    }
}
