package src.proyecto;

import src.usuario.Duenio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PrManager implements Serializable {



    private ArrayList<Proyecto> proyectos;

    public PrManager() {
        proyectos = new ArrayList<>();
    }


    public Proyecto crearProyecto(String nombre, String descripcion, Duenio duenio, Date fechaFin) {
        Proyecto retorno = new Proyecto(nombre, descripcion, duenio,proyectos.size(),fechaFin);
        proyectos.add(retorno);
        return retorno;
    }

    public Proyecto getProyecto(int id){
        return proyectos.get(id);
    }

}
