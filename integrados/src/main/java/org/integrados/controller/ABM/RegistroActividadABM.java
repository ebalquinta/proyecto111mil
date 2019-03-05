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
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class RegistroActividadABM {
    
    
    public void guardar(RegistroActividad p) throws IntegradosException {
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("registro Actividad guardado");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de registro Actividad");
        }
    }
    
    public RegistroActividad get(int id) {
        Session s=null;
        RegistroActividad p=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p=(RegistroActividad) s.get(RegistroActividad.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch(Exception e) {
            System.out.println("falla en la devolucion de registro actividad " + id);
            return null;            
        }
    }
    
    public void borrar(RegistroActividad b) throws IntegradosException{
        Session s = null;
        try{
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Registro eliminado");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar la Resgistro actividad");
        }
    }
    
    public List<RegistroActividad> listaActividades(int id){
        List<RegistroActividad> actividades = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();             
            Query query = session.createQuery("from RegistroActividad where id_Docente='" + id  + "'");  
            actividades = (List<RegistroActividad>) query.list();
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            
        }
        return actividades;
    }
}
