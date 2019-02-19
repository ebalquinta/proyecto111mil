package org.integrados.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.enums.Nivel;
import org.integrados.data.usuarios.Alumno;
import org.integrados.exceptions.IntegradosException;

public class TestAddAlumno {

    public static void main(String[] args) {
        boolean add = agregarAlumno();
        System.out.println("¿El alumno se agrego correctamente?: " + add);
    }

    public static boolean agregarAlumno() {
        boolean agregarAlumno = false;
        Alumno alumno = new Alumno(344535, "Uha", "Hie", 5, "c", Nivel.SECUNDARIO);
        alumno.setUsuario("alumna9");
        alumno.setClave("alumna6");

        try {
            saveAlumno(alumno);
            agregarAlumno = true;
        } catch (IntegradosException ex) {
            Logger.getLogger(TestAddAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return agregarAlumno;
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

}
