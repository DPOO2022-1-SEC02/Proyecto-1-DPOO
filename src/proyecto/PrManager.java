package src.proyecto;

import src.usuario.Duenio;

import java.io.Serializable;
import java.util.ArrayList;

public class PrManager implements Serializable {



    private ArrayList<Proyecto> proyectos;

    public PrManager() {
        proyectos = new ArrayList<>();
    }


    public Proyecto crearProyecto(String nombre, String descripcion, Duenio duenio) {
        Proyecto retorno = new Proyecto(nombre, descripcion, duenio,proyectos.size());
        proyectos.add(retorno);
        return retorno;
    }

    public Proyecto getProyecto(int id){
        return proyectos.get(id);
    }

}
