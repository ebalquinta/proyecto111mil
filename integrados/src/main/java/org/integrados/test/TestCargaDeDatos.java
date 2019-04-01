package org.integrados.test;

import java.util.Date;
import java.util.GregorianCalendar;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.enums.*;
import org.integrados.data.usuarios.*;
import static org.integrados.data.util.Util.*;
import org.integrados.exceptions.IntegradosException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.integrados.data.actividad.*;
import org.integrados.data.bloques.*;
import org.integrados.data.plantillas.*;

public class TestCargaDeDatos {

    public static void main(String[] args) throws IntegradosException, ParseException {

        agregarDocentes();
        agregarInstitucion();
        agregarMaterias();
        MemoramaTest test = new MemoramaTest();
        test.ejecutarMemorama();
        //listaActividades pregYResp = new listaActividades();
        //pregYResp.ejecutarPregYResp();

    }
//----------------------------------------------------------------------------------------//

    /**
     * Guarda un objeto (Domicilio, institución,etc)
     *
     * @param objeto
     * @throws IntegradosException
     */
    public static void saveObjeto(Object objeto) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(objeto);
            s.getTransaction().commit();
            s.close();
        } catch (IntegradosException e) {
            System.out.println("No se agrego el Obejeto ");
        }
    }

    /**
     * Guarda a una persona (Alumno o Docente)
     *
     * @param p persona
     * @throws IntegradosException
     */
    public static void savePersona(Persona p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();
        } catch (IntegradosException e) {
            System.out.println("No se agrego la Persona");
        }
    }

    /**
     * busca al docente de acuerdo al ID solicitado
     *
     * @param id
     * @return docente encontrado
     * @throws IntegradosException
     */
    public static Docente getDocente(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        Docente d;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            d = (Docente) s.get(Docente.class, id);
            s.getTransaction().commit();
            s.close();
            return d;
        } catch (IntegradosException e) {
            return null;
        }
    }

    public static Alumno getAlumno(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        Alumno a;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            a = (Alumno) s.get(Alumno.class, id);
            s.getTransaction().commit();
            s.close();
            return a;
        } catch (IntegradosException e) {
            return null;
        }
    }

//----------------------------------------------------------------------------------------//
    /**
     * genera numeros aleatorios entre los valores pasados por parametro
     *
     * @param inicio
     * @param fin
     * @return
     */
    public static int randBetween(int inicio, int fin) {
        return inicio + (int) Math.round(Math.random() * (fin - inicio));
    }

    /**
     * Generación de Nombres de forma aleatoria
     *
     * @return nombre
     */
    public static String nombreAleatorio() {
        String[] nombres = {"Viviana", "Sebastian", "Leandro", "Paz", "Bruno", "Mariela", "Ezequiel", "Yanina", "Jacco"};
        int i = (int) (Math.random() * 9);
        return nombres[i];
    }

    /**
     * Generación de Apellidos de forma aleatorio
     *
     * @return apellido
     */
    public static String apellidoAleatorio() {
        String[] apellidos = {"Perez", "Sanchez", "Diez", "Martinez", "Gutierrez", "Gonzalez", "Perez", "Lopez", "Dominguez"};
        int i = (int) (Math.random() * 9);
        return apellidos[i];
    }

    /**
     * Generación de Domicilio de forma aleatoria
     *
     * @return domicilio
     * @throws org.integrados.exceptions.IntegradosException
     */
    public static Domicilio domicilioAleatorio() throws IntegradosException {
        String[] calles = {"Juan Fugl", "Las Acacias", "Juan XXIII", "Albert Schweitzer", "Av. Falucho", "25 de Mayo", "Centinela", "Av.Bolivar", "Av.Santamarina"};
        Integer i = (int) (Math.random() * 9);
        Integer numero = randBetween(101, 1902);
        Domicilio d = new Domicilio(calles[i], numero);
        saveObjeto(d);
        return d;
    }

    /**
     * genera una fecha aleatoria
     *
     * @return fecha aleatoria
     * @throws ParseException
     */
    public static Date fechaAleatoria() throws ParseException {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1960, 2000);
        gc.set(GregorianCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
        int month = randBetween(1, 13);
        gc.set(GregorianCalendar.MONTH, month);
        String fecha = gc.get(GregorianCalendar.DAY_OF_MONTH) + "/" + gc.get(GregorianCalendar.MONTH) + "/" + gc.get(GregorianCalendar.YEAR);
        return stringToDate(fecha);
    }

    /**
     * Generación de division de forma aleatoria
     *
     * @return division
     */
    public static String divisionAleatorio() {
        String[] divisiones = {"a", "b", "c", "d", "e", "f"};
        int i = (int) (Math.random() * 6);
        return divisiones[i];
    }

    /**
     * Generación de Niveles de forma aleatoria
     *
     * @return Nivel
     */
    public static Nivel nivelAleatorio() {
        Nivel[] niveles = {Nivel.Inicial, Nivel.Primario, Nivel.Secundario, Nivel.Terciario, Nivel.Universitario};
        int i = (int) (Math.random() * 5);
        return niveles[i];
    }

//----------------------------------------------------------------------------------------//
    /**
     * agrega a cinco Docentes
     *
     * @throws IntegradosException
     * @throws java.text.ParseException
     */
    public static void agregarDocentes() throws IntegradosException, ParseException {
        for (int i = 0; i < 5; i++) {
            List<Alumno> alumnos = agregarAlumnos();
            int dni = randBetween(10471825, 50182673);
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            Docente docente = new Docente(dni, nombre, apellido);
            docente.setDomicilio(domicilioAleatorio());
            docente.setTelefono("0249 4" + dni);
            docente.setMail(nombre + "_" + apellido + "@gmail.com");
            docente.setUsuario(dni + "");
            docente.setClave(nombre);
            docente.setAlumnos(alumnos);
            savePersona(docente);
        }
    }

    /**
     * Agrega una Institución con un nombre y un Docente administrador
     *
     * @throws IntegradosException
     */
    public static void agregarInstitucion() throws IntegradosException {
        Docente d = getDocente(1);
        Institucion institucion = new Institucion("Escuela Nacional Ernesto Sabato", d);
        saveObjeto(institucion);
    }

    /**
     * agrega a cinco alumnos por docente
     *
     * @return lista de alumnos para un docente
     * @throws IntegradosException
     * @throws java.text.ParseException
     */
    public static List<Alumno> agregarAlumnos() throws IntegradosException, ParseException {
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int dni = randBetween(10471825, 50182673);
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            Integer grado = randBetween(1, 7);
            String division = divisionAleatorio();
            Nivel nivel = nivelAleatorio();
            Alumno alumno = new Alumno(dni, nombre, apellido, grado, division, nivel);
            alumno.setDomicilio(domicilioAleatorio());
            alumno.setTelefono("0249 4" + dni);
            alumno.setMail(nombre + "_" + apellido + "@gmail.com");
            alumno.setUsuario(dni + "");
            alumno.setClave(nombre);
            alumno.setFechaNacimiento(fechaAleatoria());
            alumno.setEdadMadurativa(randBetween(1, 18));
            alumno.setObservaciones("");
            savePersona(alumno);
            alumnos.add(alumno);

        }
        return alumnos;

    }

    /**
     * Agrega las materias
     *
     * @throws IntegradosException
     */
    public static void agregarMaterias() throws IntegradosException {
        String[] materias = {"Historia", "Geografia", "Matematica", "Lengua", "Quimica", "Biologia", "Civica", "Fisica", "Ingles", "Contabilidad", "Psicologia", "Filosofia"};
        for (int i = 0; i < materias.length; i++) {
            Materia materia = new Materia(materias[i]);
            saveObjeto(materia);

        }

    }
}
