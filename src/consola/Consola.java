package src.consola;

import src.actividad.Actividad;
import src.proyecto.PrManager;
import src.proyecto.Proyecto;
import src.tipoActividad;
import src.usuario.Duenio;
import src.usuario.Participante;
import src.usuario.Usuario;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Consola {

    int cantidadProyectos = 0;
    Scanner entrada = new Scanner(System.in);
    PrManager manager = new PrManager();

    Usuario usuarioActual;


    public static void main(String[] args) throws Exception {
        Consola consola = new Consola();
        consola.identificarUsuario();
        consola.ejecutarOpcion();
    }

    private void mostrarMenu() {
        System.out.println("""
                ¡Selecciona una de las opciones disponibles!
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

    private void ejecutarOpcion() throws Exception {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = Integer.parseInt(input("Por favor selecciona una opcion"));
            switch (opcion) {
                case 1 -> crearProyecto();
                case 2 -> darProyecto();
                case 3 -> editarProyecto();
                case 4 -> mostrarInfoActividades();
                case 5 -> mostrarParticipantes();
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


        System.out.println("Proyecto creado exitosamente. El id es: " + cantidadProyectos);
        cantidadProyectos++;
    }


    private void darProyecto() {
        int id;
        id = Integer.parseInt(input("ingrese el id del proyecto"));
        Proyecto seleccionado = manager.getProyecto(id);

        //TODO: imprimir esto bien
        System.out.println(seleccionado.darInfoProyecto());

    }

    private void editarProyecto() throws Exception {
        int id = Integer.parseInt(input("Ingresa el id del proyecto a modificar"));
        usuarioActual.setProyecto(manager.getProyecto(id));
        opcionEdicion();
    }

    private void mostrarMenuEdicion() {
        System.out.println("""
                \nSelecciona una opción:
                1. Iniciar una Actividad.
                2. Finalizar una Actividad.
                3. Editar una Actividad.
                4. Agregar participantes.
                5. Iniciar a trabajar en una actividad.
                6. Finalizar trabajo en una actividad.
                0. Regresar al menu anterior""");
    }

    private void opcionEdicion() throws Exception {
        boolean cont = true;
        while (cont) {
            mostrarMenuEdicion();
            int seleccionado = Integer.parseInt(input("Selecciona una opción"));
            switch (seleccionado) {
                case 1 -> iniciarActividad();
                case 2 -> terminarActividad();
                case 3 -> editarActividad();
                case 4 -> agregarParticipantes();
                case 5 -> iniciarTrabajo();
                case 6 -> terminarTrabajo();
                case 0 -> cont = false;
            }
        }
    }

    private void iniciarActividad() throws Exception {
        int opcion = Integer.parseInt(input("""
                1. A nombre propio
                2. Hecha por otra persona"""));
        String nombre, descripcion, strFecha;
        Date fechaFin;


        nombre = input("Escribe el nombre de la actividad");
        descripcion = input("Escribe la descripción de la actividad");
        strFecha = input("Escriba la fecha estimada de finalización (dia/mes/año)");
        fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(strFecha);

        //TODO hacer algo para poder seleccionar el tipo de actividad
        tipoActividad tipo = tipoActividad.Documentacion;


        if (opcion == 1) {
            usuarioActual.inciarActividad(nombre, tipo, descripcion, fechaFin);
        } else {
            String correo = input("Escribe el correo del usuario");
            usuarioActual.iniciarActividadExt(correo, nombre, tipo, descripcion, fechaFin);
        }

    }

    private void terminarActividad() {
        int id = Integer.parseInt(input("Escribe el id del proyecto"));
        String tituloA = input("Escribe el título de la actividad");
        Proyecto prActual = manager.getProyecto(id);
        Actividad acActual = prActual.getActividad(tituloA);
        acActual.terminar();
    }


    private void mostrarInfoActividades() {
        int id = Integer.parseInt(input("Escribe el id del proyecto a consultar"));
        Proyecto actual = manager.getProyecto(id);
        System.out.println(actual.darInfoActividades());
    }

    private void agregarParticipantes() {
        int id = Integer.parseInt(input("Escribe el id del proyecto al que quieres añadir participantes"));
        Proyecto prActual = manager.getProyecto(id);
        Duenio duenio = prActual.getDuenio();
        if (usuarioActual.equals(duenio)) {
            String nombre, correo;
            nombre = input("Escribe el nombre del nuevo usuario");
            correo = input("Escribe el correo del nuevo usuario");
            Participante agregar = new Participante(nombre, correo);
            prActual.addParticipante(agregar);
        } else {
            System.out.println("Para hacer esto debes ser el dueño del proyecto.");
        }

    }

    private void editarActividad() throws Exception {
        String strFecha;
        boolean continuar = true;

        int id = Integer.parseInt(input("Escribe el id del proyecto"));
        String tituloA = input("Escribe el titulo de la actividad");
        Proyecto prActual = manager.getProyecto(id);
        Actividad acActual = prActual.getActividad(tituloA);

        while (continuar) {
            int opcion = Integer.parseInt(input("""
                    1. Cambiar fecha de inicio.
                    2. Cambiar fecha de finalización
                    0. volver"""));
            if (opcion == 1) {
                strFecha = input("Escriba la fecha de inicio (dia/mes/año)");
                Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(strFecha);
                acActual.setFechaInicio(fechaInicio);
            } else if (opcion == 2) {
                strFecha = input("Escriba la fecha de finalización (dia/mes/año)");
                Date fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(strFecha);
                acActual.setFechaFin(fechaFin);
            } else {
                continuar = false;
            }
        }

    }

    private void mostrarParticipantes() {
        int id = Integer.parseInt(input("Escribe el id del proyecto"));
        Proyecto prActual = manager.getProyecto(id);
        String participantes = prActual.darParticipantes();
        System.out.println(participantes);

    }

    private void iniciarTrabajo() {
        Actividad actualAc = getActividad();
        actualAc.iniciarTrabajo();
    }

    private void terminarTrabajo() {
        Actividad actualAc = getActividad();
        actualAc.terminarTrabajo();
    }

    private Actividad getActividad() {
        int id = Integer.parseInt(input("Escribe el id del proyecto"));
        String titulo = input("Escribe el título de la actividad");
        Proyecto actual = manager.getProyecto(id);
        Actividad actualAc = actual.getActividad(titulo);
        return actualAc;
    }

    public String input(String mensaje) {

        System.out.print(mensaje + ": ");

        return entrada.nextLine();
    }

}
