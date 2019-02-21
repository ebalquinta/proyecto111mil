/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Memorama;
import org.integrados.data.plantillas.Ordenamiento;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.plantillas.Unir;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.usuarios.Domicilio;
import org.integrados.data.usuarios.Institucion;
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class TestAgregarReg {

    
    public static void main(String[] args) throws IntegradosException {
        
        //Alumnos
        
        Alumno alumno1 = new Alumno(1, "Pepe", "Caseros", 2, "A", Nivel.PRIMARIO);
        alumno1.setDni(dniAleatorio(alumno1));
        
        saveObjeto(alumno1);
        
        Alumno alumno2 = new Alumno(1, "Juan", "Perez", 2, "A", Nivel.PRIMARIO);
        alumno2.setDni(dniAleatorio(alumno2));
        
        saveObjeto(alumno2);
        
        Alumno alumno3 = new Alumno(1, "Pipo", "Pezcador", 2, "A", Nivel.PRIMARIO);
        alumno3.setDni(dniAleatorio(alumno3));
        
        saveObjeto(alumno3);
        
        //Lista alumnos
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        
        //Docentes
        
        Docente docente1 = new Docente(2, "Marta", "Sanches");
        docente1.setDni(dniAleatorio(docente1));
        
        saveObjeto(docente1);
        
        Docente docente2 = new Docente(2, "Paola", "Krum");
        docente2.setDni(dniAleatorio(docente2));
        
        saveObjeto(docente2);
        
        //Lista docentes
        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente1);
        docentes.add(docente2);
        
        //--------------------RELACIONES (LISTAS) ALUMNO-DOCENTE------------------------//
        
        //Alumno1 posee una lista de docentes
        alumno1.setDocentes(docentes);
        
        //docente1 posee una lista de alumnos
        docente1.setAlumnos(alumnos);
        
        //-------------------------------------------------------------//
        
        //Domicilios
       
        Domicilio domicilio1 = new Domicilio("pasteur", 1654);
        saveObjeto(domicilio1);
        
        
        Domicilio domicilio2 = new Domicilio("paso", 54);
        saveObjeto(domicilio2);
        
        //Institucion
        
        Institucion institucion = new Institucion("Escuela 2", docente1);
        saveObjeto(institucion);
        
        //Bloques
        
        Bloque bImg = new BloqueImagen("url imagen");
        saveObjeto(bImg);
        Bloque bSon = new BloqueSonido("url sonido");
        saveObjeto(bSon);
        Bloque bTex = new BloqueTexto("¿Cuanto es 2+2?");
        saveObjeto(bTex);
        Bloque bAnd = new BloqueAnd(bImg, bTex);
        //saveObjeto(bAnd);   Todavia no funciona el guardar bloques dentro de AND
        
        //Lista Bloques
        List<Bloque> bloques = new ArrayList<>();
        bloques.add(bImg);
        bloques.add(bSon);
        bloques.add(bTex);
        //bloques.add(bAnd);
        
        //Plantillas
        
        Plantilla unir = new Unir();
        unir.setEnunciado("unir respuestas correctas");
        saveObjeto(unir);
        
        Plantilla pregunta = new PregYResp();
        pregunta.setEnunciado("¿que es una célula?");
        saveObjeto(pregunta);
        
        Plantilla orden = new Ordenamiento();
        orden.setEnunciado("Orden segun corresponda");
        saveObjeto(orden);
        
        Plantilla memo = new Memorama();
        memo.setEnunciado("encuentre los pares");
        saveObjeto(memo);
        
        //Materia
        
        Materia materia = new Materia("Naturales");
        saveObjeto(materia);
        
        //Actividad
        
        Actividad actividad = new Actividad(unir, docente1, materia, "Celula", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        saveObjeto(actividad);
        
        //Registro Actividad
        
        RegistroActividad regActividad = new RegistroActividad(actividad, alumno1, docente1);
        regActividad.setRespuestaAlumno(bloques);
        saveObjeto(regActividad);
        
        
    }
    public static int dniAleatorio(Persona p){
        int nuevoDni = (int) (Math.random() * 1000);
        
       return  nuevoDni;
    }
    
    
    public static void saveObjeto(Object objeto) throws IntegradosException {
        boolean objetoAgregado = false;
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(objeto);
            s.getTransaction().commit();
            objetoAgregado = true;
            s.close();
        } catch (IntegradosException e) {
            System.out.println("no agrego ALUMNO");
        }
    }
    
    
}
