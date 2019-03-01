package org.integrados.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Alumno;
import org.integrados.exceptions.IntegradosException;

public class TestUpdateAlumno {
    private static final int ID = 1; //id del alumno que quiero obtener
    private static final String NUEVO_APELLIDO = "OtroNuevo";


    public static void main(String[] args) {
        Alumno a = obtenerAlumno();
        System.out.println("*****************************************");
        System.out.println("El viejo apellido es: " + a.getApellido());
        System.out.println("*****************************************");
        actualizarAlumno(a);
        Alumno a1 = obtenerAlumno();
        System.out.println("*****************************************");
        System.out.println("El nuevo apellido es: " + a1.getApellido());
        System.out.println("*****************************************");       
    }
    
    public static void actualizarAlumno(Alumno alumno) {
        alumno.setApellido(NUEVO_APELLIDO);
        try {
            saveAlumno(alumno);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestUpdateAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveAlumno(Alumno alumno) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(alumno);
            s.getTransaction().commit();
            s.close();
        } catch (IntegradosException e) {
        }
    }

    public static Alumno obtenerAlumno() {
        Alumno alumno = null;
        try {
            alumno = getAlumno(ID);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestUpdateAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    public static Alumno getAlumno(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Alumno a = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            a = (Alumno) s.get(Alumno.class, id);
            s.getTransaction().commit();
            s.close();
            return a;
        } catch (Exception e) {
            return null;
        }

    }

}
