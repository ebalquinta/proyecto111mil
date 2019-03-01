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
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class hshs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IntegradosException {
        // TODO code application logic here
        Docente d = get(1);
        List<RegistroActividad> reg = listaActividades(d.getId());
        for(RegistroActividad r : reg){
            System.out.println(r.getAlumno().getNombre());
        }
        
//RegistroActividad reg = getr(1);
//        System.out.println(reg.getEstrella());
        
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
    public static RegistroActividad getr(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        RegistroActividad p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (RegistroActividad) s.get(RegistroActividad.class, id);
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
    
     public static List<RegistroActividad> listaActividades(int id) throws IntegradosException{
          HibernateUtiles.inicializar();
        List<RegistroActividad> actividades = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();             
            Query query = session.createQuery("from RegistroActividad where id_Docente='" + id  + "'");  
            actividades = (List<RegistroActividad>) query.getResultList();
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            
        }
        return actividades;
    }
}
