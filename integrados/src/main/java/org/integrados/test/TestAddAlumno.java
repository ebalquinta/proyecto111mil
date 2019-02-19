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

public class TestAddAlumno {
    

    public static void main(String[] args) {
        boolean add = agregarAlumno();
        System.out.println("*****************************************");
        System.out.println("¿El alumno se agrego correctamente?: " + add);
        System.out.println("*****************************************");
 

    }

    public static boolean agregarAlumno() {
        boolean agregarAlumno = false;
        Alumno alumno = new Alumno(1313, "Carla", "Carla", 5, "c", Nivel.SECUNDARIO);
        alumno.setUsuario("alumno13");
        alumno.setClave("alumno13");
        
        
        List<Docente> docentes = new ArrayList<>();
        Docente d = new Docente(1313, "Pedro", "Pedro");
        docentes.add(d);
        alumno.setDocentes(docentes);

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
