package org.integrados.controller.ABM;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;

public class PersonaABM {
    
    public void guardar(Persona p) {
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("persona guardada");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("la persona no ha sido guardada");
        }
    }
    
    public Persona get(int id) {
        Session s=null;
        Persona p=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p=(Persona)s.get(Persona.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch(Exception e) {
            System.out.println("Error al buscar a la persona id= " + id);
            return null;
        }
    }
    
     public void borrar(Persona b) throws IntegradosException{
        Session s = null;
        try{
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Persona eliminada");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar la Persona");
        }
    }
     
     public List<Alumno> listaAlumnos(int id) {
        List<Alumno> alumnos = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select alumnos FROM Docente where id_Docente='" + id + "'");
            alumnos = (List<Alumno>) query.getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
        return alumnos;
    }
     
     public List<Docente> listaDocentes(int id) {
        List<Docente> docentes = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select docentes FROM Alumno where id_Docente='" + id + "'");
            docentes = (List<Docente>) query.getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
        return docentes;
    }
}
