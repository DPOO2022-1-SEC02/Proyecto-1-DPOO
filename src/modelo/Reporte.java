package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Reporte {
	private int tiempoTotal;
	private HashMap<String,Integer> tiempoPorTipo;
	private HashMap<LocalDate, Integer> tiempoPorDia;
	private int cantActividades;
	private int trabajoTotal;
	
	public Reporte(ArrayList<Actividad> actividades) 
	{
		
		tiempoPorDia = new HashMap<>();
		tiempoPorTipo = new HashMap<>();
		for (Actividad actividad: actividades) {
			trabajoTotal = actividad.getTrabTotal();
			tiempoTotal += trabajoTotal;
			tiempoPorTipo.put(actividad.getTipo(), trabajoTotal);
			actividad.sumarTiempo(tiempoPorDia);
			
		}
		
		this.cantActividades = actividades.size();
		
	}

	public int cantActividades() {
		return cantActividades;
	}
	
	public int tiempoTrabajo() {
		return tiempoTotal;
	}
	
	public HashMap<LocalDate, Integer> tiempoTrabajoDia() {
		return tiempoPorDia;
	}
	
	public HashMap<String,Integer> tiempoTrabajoTipo() {
		return tiempoPorTipo;
	}
	
}
