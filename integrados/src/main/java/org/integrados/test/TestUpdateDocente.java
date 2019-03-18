package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.enums.Nivel;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;

public class TestUpdateDocente {
    private static final int ID = 1; //id del docente que quiero obtener
    private static final String NUEVO_APELLIDO = "Perez";
    


    public static void main(String[] args) {
        Docente d = obtenerDocente();
        System.out.println("*****************************************");
        System.out.println("El viejo apellido es: " + d.getApellido());
        System.out.println("*****************************************");
        actualizarDocente(d);
        Docente d1 = obtenerDocente();
        System.out.println("*****************************************");
        System.out.println("El nuevo apellido es: " + d1.getApellido());
        System.out.println("*****************************************");
        
        List<Alumno> alumnos = new ArrayList<>();
        Alumno a = new Alumno(101918, "alumnoDocente", "apellido", 5, "c", Nivel.Secundario);
        alumnos.add(a);
        d1.setAlumnos(alumnos);
        System.out.println("*****************************************");
        System.out.println("La lista de Alumnos es: " + d1.getAlumnos());
        System.out.println("*****************************************");
        
    }
    
    public static void actualizarDocente(Docente docente) {
        docente.setApellido(NUEVO_APELLIDO);
        try {
            saveDocente(docente);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestUpdateDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveDocente(Docente docente) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(docente);
            s.getTransaction().commit();
            s.close();
        } catch (IntegradosException e) {
        }
    }

    public static Docente obtenerDocente() {
        Docente docente = null;
        try {
            docente = getDocente(ID);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestUpdateDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docente;
    }

    public static Docente getDocente(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Docente d = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            d = (Docente) s.get(Docente.class, id);
            s.getTransaction().commit();
            s.close();
            return d;
        } catch (Exception e) {
            return null;
        }

    }

}
