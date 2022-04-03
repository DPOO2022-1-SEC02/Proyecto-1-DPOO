package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Proyecto implements Serializable {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;
    private HashMap<String, Actividad> actividades;
    private HashMap<String, Usuario> participantesMap;
    private ArrayList<Usuario> participantes;
    private Usuario duenio;
    private int id;
    private ArrayList<String> tipos;

    public Proyecto(String nombre, String descripcion, Usuario duenio, int id, Date fechaFinal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duenio = duenio;
        this.id = id;
        this.fechaInicio = new Date();
        this.fechaFinal = fechaFinal;
        actividades = new HashMap<>();
        participantes = new ArrayList<>();
        participantesMap = new HashMap<>();
        tipos = new ArrayList<>();
        addParticipante(duenio);
    }


    public void addTipo(String tipo) {
        tipos.add(tipo);
    }

    public String getTipos() {
        String retorno = "";
        int posicion = 1;
        for (String tipo : tipos) {
            retorno += posicion + ". " + tipo + "\n";
            posicion++;
        }
        return retorno;
    }

    public String getTipo(int pos) {
        return tipos.get(pos - 1);
    }

    public boolean participanteExiste(String mail) {
        for (Usuario participante : participantes) {
            if (mail.equals(participante.getEmail())) {
                return true;
            }
        }
        return false;
    }
    
    public void addActividad(Actividad actividad) {
        actividades.put(actividad.getTitulo(), actividad);
    }


    public String darInfoActividades() {
        String retorno = "";
        if (actividades.isEmpty()) {
            return "No hay actividades";
        }

        int contador = 1;
        for (String titulo : actividades.keySet()) {
            Actividad actividad = actividades.get(titulo);
            retorno += "\nActividad " + contador + "\n";
            retorno += actividad.consultarInformacion() + "\n";
            contador++;
        }
        return retorno;
    }

    public String darParticipantes() {
        String retorno = "Dueño: " + duenio.getName();
        if (participantes.isEmpty()) {
            retorno += "\nNo hay participantes";
            return retorno;
        }
        int contador = 1;
        for (Usuario participante : participantes) {
            retorno += "\nParticipante " + contador + "\n";
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
                + "\nCantidad de actividades: " + actividades.size() 
                + "\nCantidad de participantes: " + participantes.size() + "\n");

    }

    public int getActividadesSize() {
        return actividades.size();
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void addParticipante(Usuario participante) {
        participantes.add(participante);
        participantesMap.put(participante.getEmail(),participante);
    }
    public Usuario getParticipante(String mail) {
    	return participantesMap.get(mail);
    }
    public Actividad getActividad(String titulo) {
        return actividades.get(titulo);
    }
    
    public void  updateParticipante(Usuario usuario){
        participantesMap.put(usuario.getEmail(),usuario);
    }
    
}
