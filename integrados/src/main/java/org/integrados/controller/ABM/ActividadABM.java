/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.ABM;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.actividad.Actividad;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class ActividadABM {
    
    public void guardar(Actividad p) {
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("Actividad guardada");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de Actividad");
        }
    }
    
     public void set(Actividad actividad){
         Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.update(actividad);
            s.getTransaction().commit();
            System.out.println("Actividad actualizada");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla al actualizar la actividad");
        }
     }
    
    public Actividad get(int id){
        Session s=null;
        Actividad p=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p=(Actividad) s.get(Actividad.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch(Exception e) {
            System.out.println("falla en la devolucion de Actividad " + id);
            return null;            
        }
    }
    
    public void borrar(Actividad b) {
        Session s = null;
        try{
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Actividad eliminada");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar la Actividad");
        }
    }
    
    public List<Actividad> listaActividades(int id){
        List<Actividad> actividades = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();             
            Query query = session.createQuery("from Actividad where id_Docente='" + id  + "'");  
            actividades = (List<Actividad>) query.getResultList();
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            
        }
        return actividades;
    }
}
