package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected Proyecto prActual;
    private ArrayList<Actividad> actividades;

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
        actividades = new ArrayList<>();
       
    }

    public String generarReporte() {
    	System.out.println(actividades);
        String reporteTxt ="--- Inicio del reporte ---\n";
        int tiempoTotalTrabajo,tiempo,tiempoTipo;
        HashMap<LocalDate, Integer> tiempoPorDia;
        HashMap<String,Integer> tiempoPorTipo;
        int numActividades;
    	Reporte reporte = new Reporte(actividades); 
    	
    	
    	tiempoTotalTrabajo = reporte.tiempoTrabajo();
    	tiempoPorDia = reporte.tiempoTrabajoDia();
    	tiempoPorTipo = reporte.tiempoTrabajoTipo();
    	numActividades = reporte.cantActividades();
    	
    	reporteTxt += "Numero total de actividades trabajadas es: " + numActividades+" \n";
    	reporteTxt += "Tiempo total trabajado" + " : "+ tiempoTotalTrabajo +" mins\n";
    	reporteTxt+="Tiempo trabajado diariamente: \n";

    	if(tiempoPorDia.isEmpty()) {
    		reporteTxt += "  - No hay tiempo por dia registrado\n";
    		
    	}
    	else {
        	for (LocalDate fecha : tiempoPorDia.keySet()) {
    			tiempo = tiempoPorDia.get(fecha);
    			reporteTxt+="  - "+fecha+": "+tiempo+" mins\n";			
    		}
    	}

    	
    	reporteTxt += "El tiempo de trabajo por tipo de actividad es: \n";
    	if (tiempoPorTipo.isEmpty()) {
    		reporteTxt += "  - No hay tiempo por tipo de actividad registrado\n";
    		
    	}
    	
    	else {
	    	for (String tipo : tiempoPorTipo.keySet()) {
	    		tiempoTipo = tiempoPorTipo.get(tipo);
	    		reporteTxt += "  - "+ tipo + ": "+ tiempoTipo +" mins\n"; 
			}
	    }
    	reporteTxt += "--- Fin del reporte ---";
    	
    	return reporteTxt;
    	
    	
    }

    public void inciarActividad(String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad, nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        prActual.addActividad(actividad);
        actividades.add(actividad);
        prActual.updateParticipante(this);
    }

    public void iniciarActividadExt(String correo, String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad,nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        Usuario otro = prActual.getParticipante(correo);
     	prActual.addActividad(actividad);
     	otro.addActividad(actividad);
     	prActual.updateParticipante(otro);
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
