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
import org.integrados.controller.actividades.JugarMemoramaCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Memorama;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.util.Util;
import org.integrados.exceptions.IntegradosException;
import static org.integrados.test.TestCargaDeDatos.getAlumno;
import static org.integrados.test.TestCargaDeDatos.getDocente;

/**
 *
 * @author alumno
 */
public class MemoramaTest {

    List<Bloque> bloques;
    List<Bloque> bloques2;
    List<Bloque> solucion;

    public void ejecutarMemorama() throws IntegradosException {
        System.out.println("Inicio Memorama");
// Obtengo la ruta relativa de donde estoy parado
        String path = this.getClass().getResource("../").toString();
// Reescribo esa ruta en formato correcto para que saque espacios y caracteres especiales
        String result = Util.getDecodedUrl(path);
        System.out.println(result);

        bloques = new ArrayList();
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/uno.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/dos.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/tres.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/cinco.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/seis.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/siete.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/ocho.jpg"));

        bloques2 = new ArrayList();
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/uno.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/dos.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/tres.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/cinco.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/seis.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/siete.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/ocho.jpg"));

        solucion = new ArrayList();
        for (int i = 0; i < bloques.size(); i++) {
            solucion.add(bloques.get(i));
            solucion.add(bloques2.get(i));
        }

        Memorama memorama = new Memorama("Reconocer el par de numeros", solucion, bloques, bloques2);
        guardarPlantilla(memorama);
        Memorama memoramaRecuperado = (Memorama) getPlantilla(1);
        Docente docente = getDocente(2);
        Materia materia = getMateria(3);
        Actividad actividad = new Actividad(memoramaRecuperado, docente, materia, "Numeros", 3, Nivel.Inicial, Dificultad.Alta, 3);
        guardarActividad(actividad);
        Actividad actividadRecuperada = getActividad(1);
        Alumno alumno = getAlumno(2);
        RegistroActividad registro = new RegistroActividad(actividadRecuperada, alumno, docente);
        registro.setRespuestaAlumno(bloques);
        registro.setFinalizoCorrectamente(Boolean.TRUE);
        registro.setEstrella(3);
        registro.setIntentos(2);
        registro.setCorazon("Excelente");
        guardarRegistroActividad(registro);
        //JugarMemoramaCtrl ctrl = new JugarMemoramaCtrl(actividad);

    }

    public static Materia getMateria(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        Materia m;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            m = (Materia) s.get(Materia.class, id);
            s.getTransaction().commit();
            s.close();
            return m;
        } catch (IntegradosException e) {
            return null;
        }
    }

    public static void guardarRegistroActividad(RegistroActividad p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
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

    public static void guardarActividad(Actividad p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
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

    public static Actividad getActividad(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        Actividad ac;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            ac = (Actividad) s.get(Actividad.class, id);
            s.getTransaction().commit();
            s.close();
            return ac;
        } catch (IntegradosException e) {
            return null;
        }
    }

    public static void guardarPlantilla(Plantilla p) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
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

    public static Plantilla getPlantilla(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        Plantilla p;
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

}
