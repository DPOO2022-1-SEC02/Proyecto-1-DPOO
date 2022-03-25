package src.consola;

import src.proyecto.PrManager;
import src.proyecto.Proyecto;
import src.usuario.Duenio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Consola {

    Scanner entrada = new Scanner(System.in);
    PrManager manager = new PrManager();

    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.ejecutarOpcion();
    }

    private void mostrarMenu() {
        System.out.println("""
                ¡Bienvenido! :D, selecciona una de las opciones disponibles
                1. Crear un proyecto.
                2. Ver información de un proyecto.
                3. Ver información de las actividades de un proyecto.
                4. Ver los participantes de un proyecto.
                5. Generar un reporte de usuario.
                0. Salir de la aplicación.""");

    }

    private void ejecutarOpcion() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = Integer.parseInt(input("Por favor selecciona una opcion"));
            switch (opcion) {
                case 1 -> crearProyecto();
                case 2 -> darProyecto();
                case 6 -> continuar = false;
            }
        }
    }

    private void crearProyecto() {
        String nombre, descripcion;
        nombre = input("Escribe el nombre del proyecto");
        descripcion = input("Escribe la descripción del proyecto");

        String nameD = input("Ingresa el nombre del dueño");
        String emailD = input("Ingresa el correo del dueño");
        Duenio duenio = new Duenio(nameD,emailD);

        manager.crearProyecto(nombre, descripcion, duenio);


    }


    private void darProyecto() {
        int id;
        id = Integer.parseInt(input("ingrese el id del proyecto"));
        Proyecto seleccionado = manager.getProyecto(id);

        //TODO: imprimir esto bien
        System.out.println(seleccionado.darInfoProyecto());

    }


    public String input(String mensaje) {

        System.out.print(mensaje + ": ");

        return entrada.nextLine();
    }

}
