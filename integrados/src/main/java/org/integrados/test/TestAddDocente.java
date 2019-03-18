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

public class TestAddDocente {

    public static void main(String[] args) {
        boolean add = agregarDocente();
        System.out.println("*****************************************");
        System.out.println("¿El Docente se agrego correctamente?: " + add);
        System.out.println("*****************************************");

    }

    public static boolean agregarDocente() {
        boolean agregarDocente = false;
        Docente docente = new Docente(6666, "Profesora", "La Mejor");
        docente.setUsuario("docente6");
        docente.setClave("docente6");
        
         
        List<Alumno> alumnos = new ArrayList<>();
        Alumno a = new Alumno(6666, "Es", "Ese", 5, "c", Nivel.Secundario);
        alumnos.add(a);
        docente.setAlumnos(alumnos);

        
        try {
            saveDocente(docente);
            agregarDocente = true;
        } catch (IntegradosException ex) {
            Logger.getLogger(TestAddDocente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return agregarDocente;
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

}
