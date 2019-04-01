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
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.bloques.Bloque;
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
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;
import static org.integrados.test.MemoramaTest.getMateria;

/**
 *
 * @author Yani
 */
public class listaActividades {

    
    public void ejecutarPregYResp() throws IntegradosException {

//Bloques
        Bloque bImg = new BloqueTexto("cien kilos");
        Bloque bSon = new BloqueTexto("un kilo");
        Bloque bTex = new BloqueTexto("mil kilos");
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
        PregYResp preYResp = new PregYResp();
// for (Bloque b : unir.getSoluciones()){
// System.out.println("bloque: " + b);
// }
        preYResp.setSoluciones(bloquesSolucion);
        preYResp.setEnunciado("¿Cuantos kilos son una tonelada?");
        preYResp.setOpciones(bloques);
        guardar(preYResp);

        Materia materia = getMateria(3);
        Docente docente = get(1); //----------------------------> INGRESAR EL DOCENTE DE LA BASE DE DATOS AL QUE LE QUIERAN AGREGAR ACTIVIDADES
        Alumno alumno = geta(1); //----------------------------> INGRESAR EL DOCENTE DE LA BASE DE DATOS AL QUE LE QUIERAN AGREGAR ACTIVIDADES
// System.out.println(docente.getDni());
// List<Actividad> actividades = listaActividades(4);
// for(Actividad a : actividades){
// System.out.println("id actividad " + a.getId());
// }



//Bloques
        Bloque bImg1 = new BloqueTexto("Por el Norte");
        Bloque bSon1 = new BloqueTexto("Por el Oeste");
        Bloque bTex1 = new BloqueTexto("Por el Este");
        guardar(bImg1);
        guardar(bSon1);
        guardar(bTex1);

//Lista opciones
        List<Bloque> bloques1 = new ArrayList<>();
        bloques1.add(bImg1);
        bloques1.add(bSon1);
        bloques1.add(bTex1);
//Lista solucion
        List<Bloque> bloquesSolucion1 = new ArrayList<>();
        bloquesSolucion1.add(bTex1);

//Plantillas
        PregYResp preYResp1 = new PregYResp();
// for (Bloque b : unir.getSoluciones()){
// System.out.println("bloque: " + b);
// }
        preYResp1.setSoluciones(bloquesSolucion1);
        preYResp1.setEnunciado("¿Por donde sale el sol?");
        preYResp1.setOpciones(bloques1);
        guardar(preYResp1);

        Materia materia1 = getMateria(2);
        Docente docente1 = get(1); //----------------------------> INGRESAR EL DOCENTE DE LA BASE DE DATOS AL QUE LE QUIERAN AGREGAR ACTIVIDADES
        Alumno alumno1 = geta(1);


        
        //Bloques
        Bloque bImg2 = new BloqueTexto("Red");
        Bloque bSon2 = new BloqueTexto("Yellow");
        Bloque bTex2 = new BloqueTexto("Blue");
        guardar(bImg2);
        guardar(bSon2);
        guardar(bTex2);

//Lista opciones
        List<Bloque> bloques2 = new ArrayList<>();
        bloques2.add(bImg2);
        bloques2.add(bSon2);
        bloques2.add(bTex2);
//Lista solucion
        List<Bloque> bloquesSolucion2 = new ArrayList<>();
        bloquesSolucion2.add(bTex2);

//Plantillas
        PregYResp preYResp2 = new PregYResp();
// for (Bloque b : unir.getSoluciones()){
// System.out.println("bloque: " + b);
// }
        preYResp2.setSoluciones(bloquesSolucion2);
        preYResp2.setEnunciado("¿Como se escribe azul en Ingles?");
        preYResp2.setOpciones(bloques2);
        guardar(preYResp2);

        Materia materia2 = getMateria(9);
        Docente docente2 = get(1); //----------------------------> INGRESAR EL DOCENTE DE LA BASE DE DATOS AL QUE LE QUIERAN AGREGAR ACTIVIDADES
        Alumno alumno2 = geta(1);
        
        

        Actividad actividad1 = new Actividad(preYResp, docente, materia, "Medidas", 1, Nivel.Primario, Dificultad.Baja, 3);
        guardar(actividad1);
        Actividad actividad2 = new Actividad(preYResp1, docente1, materia1, "Puntos Cardinales", 1, Nivel.Secundario, Dificultad.Intermedia, 3);
        guardar(actividad2);
        Actividad actividad3 = new Actividad(preYResp2, docente2, materia2, "Colores", 1, Nivel.Terciario, Dificultad.Alta, 3);
        guardar(actividad3);

// List<Actividad> listaActividades = new ArrayList<>();
// listaActividades.add(actividad1);
// listaActividades.add(actividad2);
// listaActividades.add(actividad3);
//
// docente.setActividades(listaActividades);
// guardar(docente);
// ACTIVIDADES REALIZADAS //
        RegistroActividad reg = new RegistroActividad(actividad1, alumno, docente);
        reg.setFinalizoCorrectamente(true);
        reg.setIntentos(3);
        reg.setCorazon("Muy bien");
        reg.setEstrella(1);
        RegistroActividad reg1 = new RegistroActividad(actividad2, alumno1, docente1);
        reg1.setFinalizoCorrectamente(true);
        reg1.setIntentos(1);
        reg1.setCorazon("Felicitaciones");
        reg1.setEstrella(3);
        RegistroActividad reg2 = new RegistroActividad(actividad3, alumno2, docente2);
        reg2.setFinalizoCorrectamente(true);
        reg2.setIntentos(4);
        reg2.setCorazon("Sigue Trabajando");
        reg2.setEstrella(2);
// ACTIVIDADES NO REALIZADAS //
        RegistroActividad reg3 = new RegistroActividad(actividad1, alumno, docente);
        RegistroActividad reg4 = new RegistroActividad(actividad2, alumno1, docente1);
        RegistroActividad reg5 = new RegistroActividad(actividad3, alumno2, docente2);
        guardar(reg);
        guardar(reg1);
        guardar(reg2);
        guardar(reg3);
        guardar(reg4);
        guardar(reg5);

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

    public static Alumno geta(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Alumno p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Alumno) s.get(Alumno.class, id);
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

    public static void guardar(RegistroActividad p) throws IntegradosException {
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
        Session s;
        Materia p;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Materia) s.get(Materia.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch (IntegradosException e) {
            System.out.println("falla en la devolucion de Materia " + id);
            return null;
        }
    }

    public static List<Actividad> listaActividades(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        List<Actividad> actividades = new ArrayList<>();
        Session session;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from Actividad where id_Docente='" + id + "'");
            actividades = query.list();
            session.getTransaction().commit();
        } catch (IntegradosException e) {
        }
        return actividades;
    }
}
