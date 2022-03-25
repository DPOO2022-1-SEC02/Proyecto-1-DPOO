package src.proyecto;

import src.usuario.Duenio;

import java.util.ArrayList;
import java.util.Scanner;

public class PrManager {


    Scanner entrada = new Scanner(System.in);

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
