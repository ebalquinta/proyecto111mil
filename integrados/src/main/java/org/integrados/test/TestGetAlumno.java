package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;

public class TestGetAlumno {
    private static final int ID = 7; //id del alumno que quiero obtener

    
    public static void main(String[] args) {
        Alumno a = obtenerAlumno();
        System.out.println("El DNI del alumno es: "+a.getDni());
       
        
        List<Docente> docentes = new ArrayList<>();
        Docente d = new Docente(1313, "Pedro", "Pedro");
        docentes.add(d);
        a.setDocentes(docentes);
        System.out.println("La cantidad de docentes es : "+docentes.size());
       for (Docente docente : docentes) {
            System.out.println("El Docente es : "+docente.getNombre());
        }
    }

    public static Alumno obtenerAlumno() {
        Alumno alumno = null;
        try {
            alumno = getAlumno(ID);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestGetAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
