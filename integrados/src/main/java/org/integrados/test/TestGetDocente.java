package org.integrados.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;

public class TestGetDocente {

    private static final int ID = 28; //id del alumno que quiero obtener

    public static void main(String[] args) {
        Docente d = obtenerDocente();
        System.out.println("El DNI del Docente es: " + d.getDni());
        System.out.println("El NOMBRE del Docente es: " + d.getNombre());

    }

    public static Docente obtenerDocente() {
        Docente docente = null;
        try {
            docente = getDocente(ID);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestGetDocente.class.getName()).log(Level.SEVERE, null, ex);
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
