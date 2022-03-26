package src.consola;

import src.proyecto.PrManager;
import src.proyecto.Proyecto;
import src.usuario.Duenio;
import src.usuario.Usuario;

import java.util.Scanner;

public class Consola {

    Scanner entrada = new Scanner(System.in);
    PrManager manager = new PrManager();

    Usuario usuarioActual;

    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.identificarUsuario();
        consola.ejecutarOpcion();
    }

    private void mostrarMenu() {

        System.out.println("""
                ¡Selecciona una de las opciones disponibles
                1. Crear un proyecto.
                2. Ver información de un proyecto.
                3. Editar un proyecto (Editar y añadir actividades y participantes).
                4. Ver información de las actividades de un proyecto.
                5. Ver los participantes de un proyecto.
                6. Generar un reporte de usuario.
                0. Salir de la aplicación.""");

    }


    private void identificarUsuario() {
        System.out.println("¡Bienvenido :D! Para empezar ingresa tus datos");
        String nombre = input("Escribe tu nombre");
        String correo = input("Escribe tu dirección de correo");
        usuarioActual = new Usuario(nombre, correo);

    }

    private void ejecutarOpcion() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = Integer.parseInt(input("Por favor selecciona una opcion"));
            switch (opcion) {
                case 1 -> crearProyecto();
                case 2 -> darProyecto();
                case 3 -> editarProyecto();
                case 0 -> continuar = false;
            }
            System.out.println("\n");
        }
    }

    private void crearProyecto() {
        String nombre, descripcion;
        nombre = input("Escribe el nombre del proyecto");
        descripcion = input("Escribe la descripción del proyecto");

        String nameD = input("Ingresa el nombre del dueño");
        String emailD = input("Ingresa el correo del dueño");
        Duenio duenio = new Duenio(nameD, emailD);

        manager.crearProyecto(nombre, descripcion, duenio);

    }


    private void darProyecto() {
        int id;
        id = Integer.parseInt(input("ingrese el id del proyecto"));
        Proyecto seleccionado = manager.getProyecto(id);

        //TODO: imprimir esto bien
        System.out.println(seleccionado.darInfoProyecto());

    }

    private void editarProyecto() {
        int id = Integer.parseInt(input("Ingresa el id del proyecto a modificar"));
        usuarioActual.setProyecto(id);
        mostrarMenuEdicion();
    }

    private void mostrarMenuEdicion() {
        System.out.println("""
                Selecciona una de las opciones disponibles:
                1. Iniciar una Actividad
                2. Finalizar una Actividad
                3. Editar una Actividad""");
    }

    private void opcionEdicion() {
        int seleccionado = Integer.parseInt(input("Selecciona una opción"));
        switch (seleccionado) {
            case 1 -> usuarioActual.inciarActividad();
            case 2 -> usuarioActual.finalizarActividad();
            case 3 -> usuarioActual.editarActividad();
        }
    }

    public String input(String mensaje) {

        System.out.print(mensaje + ": ");

        return entrada.nextLine();
    }

}
