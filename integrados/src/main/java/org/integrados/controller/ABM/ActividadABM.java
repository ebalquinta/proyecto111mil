/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.ABM;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class ActividadABM {
    
    public void guardar(Actividad p) throws IntegradosException {
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
    
    public Actividad get(int id) throws IntegradosException {
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
    
    public void borrar(Actividad b) throws IntegradosException{
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
}
