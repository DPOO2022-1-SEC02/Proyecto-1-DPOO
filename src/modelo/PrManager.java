package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PrManager implements Serializable {


    private ArrayList<Proyecto> proyectos;

    public PrManager() {
        proyectos = new ArrayList<>();
    }


    public void crearProyecto(String nombre, String descripcion, Usuario duenio, Date fechaFin) {
        Proyecto retorno = new Proyecto(nombre, descripcion, duenio, proyectos.size(), fechaFin);
        proyectos.add(retorno);
    }

    public Proyecto getProyecto(int id) {
        return proyectos.get(id);
    }
        
    public int getId()
        {
            return proyectos.size();
        }

}
