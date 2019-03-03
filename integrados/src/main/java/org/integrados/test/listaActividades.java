/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.integrados.bd.HibernateUtiles;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.plantillas.Unir;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class listaActividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IntegradosException {

        //Bloques
        Bloque bImg = new BloqueImagen("url imagen");
        Bloque bSon = new BloqueSonido("url sonido");
        Bloque bTex = new BloqueTexto("se prende");
        
        guardar(bImg);
        guardar(bSon);
        guardar(bTex);
        

        //Lista opciones
        List<Bloque> bloques = new ArrayList<>();
        bloques.add(bImg);
        bloques.add(bSon);
        bloques.add(bTex);
        
        //Lista solucion
        List<Bloque> bloquesSolucion = new ArrayList<>();
        bloquesSolucion.add(bTex);

        //Plantillas
        PregYResp unir = new PregYResp();
        
//        for (Bloque b : unir.getSoluciones()){
//            System.out.println("bloque: " + b);
//        }
        
        unir.setSoluciones(bloquesSolucion);
        unir.setEnunciado("¿Que pasa si metemos una lampara en un microondas?");
        unir.setOpciones(bloques);
        guardar(unir);

        Materia materia = new Materia("Lengua");
        guardar(materia);
        
        Docente docente = get(1);  //----------------------------> INGRESAR EL DOCENTE DE LA BASE DE DATOS AL QUE LE QUIERAN AGREGAR ACTIVIDADES
//        System.out.println(docente.getDni());
//        List<Actividad> actividades = listaActividades(4);
//        for(Actividad a : actividades){
//            System.out.println("id actividad " + a.getId());
//        }
        
        
        Actividad actividad1 = new Actividad(unir, docente, materia, "Oraciones", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        guardar(actividad1);
        Actividad actividad2 = new Actividad(unir, docente, materia, "Guerra", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        guardar(actividad2);
        Actividad actividad3 = new Actividad(unir, docente, materia, "Celula", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        guardar(actividad3);

//        List<Actividad> listaActividades = new ArrayList<>();
//        listaActividades.add(actividad1);
//        listaActividades.add(actividad2);
//        listaActividades.add(actividad3);
//
//        docente.setActividades(listaActividades);
//        guardar(docente);

    }

    public static Docente get(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Docente p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Docente) s.get(Docente.class, id);
            s.getTransaction().commit();
            System.out.println("");
            System.out.println("id ***" + p.getId());
            System.out.println("");
            s.close();
            return p;
        } catch (Exception e) {
            System.out.println("Error al buscar a la persona id= " + id);
            return null;
        }
    }
    public static Plantilla getp(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Plantilla p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Plantilla) s.get(Plantilla.class, id);
            s.getTransaction().commit();
            System.out.println("");
            System.out.println("id ***" + p.getId());
            System.out.println("");
            s.close();
            return p;
        } catch (Exception e) {
            System.out.println("Error al buscar a la plantilla id= " + id);
            return null;
        }
    }

    public static void guardar(Actividad p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("Actividad guardada");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de Actividad");
        }
    }

    public static void guardar(Persona p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("persona guardada");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("la persona no ha sido guardada");
        }
    }

    public static void guardar(Bloque p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("Bloque guardado");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de Bloque");
        }
    }

    public static void guardar(Plantilla p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de plantilla");
        }
    }
    public static void guardar(Materia p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de materia");
        }
    }

    public static Materia getm(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Materia p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Materia) s.get(Materia.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch (Exception e) {
            System.out.println("falla en la devolucion de Materia " + id);
            return null;
        }
    }
    
    public static List<Actividad> listaActividades(int id) throws IntegradosException{
        HibernateUtiles.inicializar();
        List<Actividad> actividades = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();             
            Query query = session.createQuery("from Actividad where id_Docente='" + id  + "'");  
            actividades =  query.list();
            session.getTransaction().commit();
            
        }catch(Exception e){
            
        }
        return actividades;
    }
}
