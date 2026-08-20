package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();

    static ProfesorDAO profesorDAO = new ProfesorDAO();
    static Profesor profesor = new Profesor();

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    private static void inscribir() throws IOException {
        System.out.print("Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("Curp: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Número de Expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.inscribirAlumno(alumno);
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();

        System.out.println("========== LISTA DE ALUMNOS ==========");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private static void actualizarALumno() throws IOException {
        System.out.println("NUMERO DE EXPEDIENTE: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.println("NOMBRE: ");
        alumno.setNombre(leer.readLine());

        System.out.println("CURP: ");
        alumno.setCurp(leer.readLine());

        System.out.println("GRUPO: ");
        alumno.setGrupo(leer.readLine());

        System.out.println("PROMEDIO: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.actualizar(alumno);
    }

    private static void agregarProfesor() throws IOException {
        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());

        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());

        System.out.print("Numero de Empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.print("Nombre del Empleado: ");
        profesor.setNombreEmpleado(leer.readLine());

        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());

        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.agregarProfesor(profesor);
    }

    private static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        System.out.println("========== LISTA DE PROFESORES ==========");

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    private static void actualizarProfesor() throws IOException {

        System.out.print("Numero de Empleado del profesor a modificar: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.print("Nombre: ");
        profesor.setNombre(leer.readLine());

        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());

        System.out.print("Nombre del Empleado: ");
        profesor.setNombreEmpleado(leer.readLine());

        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());

        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.actualizarProfesor(profesor);
    }

    private static void bajaAlumno() {
    }

    private static void buscarAlumno() {
    }

    public static void menu() throws IOException {

        int salir = 0;

        do {

            System.out.println("========== MENU ==========");
            System.out.println("1.- Inscribir Alumno");
            System.out.println("2.- Mostrar Alumnos");
            System.out.println("3.- Actualizar Alumno");
            System.out.println("4.- Dar de baja Alumno");
            System.out.println("5.- Buscar Alumno");
            System.out.println("6.- Agregar Profesor");
            System.out.println("7.- Mostrar Profesores");
            System.out.println("8.- Modificar Profesor");
            System.out.println("9.- Salir");
            System.out.println("==========================");
            System.out.print("Elige tu opción: ");

            salir = Integer.parseInt(leer.readLine());

            switch (salir) {

                case 1:
                    inscribir();
                    break;

                case 2:
                    mostrarAlumnos();
                    break;

                case 3:
                    actualizarALumno();
                    break;

                case 4:
                    bajaAlumno();
                    break;

                case 5:
                    buscarAlumno();
                    break;

                case 6:
                    agregarProfesor();
                    break;

                case 7:
                    mostrarProfesores();
                    break;

                case 8:
                    actualizarProfesor();
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (salir != 9);
        
    }
}