/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.ABM;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.bloques.Bloque;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class BloqueABM {
    
    
     public void guardar(Bloque p){
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            System.out.println("Bloque guardado");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de Bloque");
        }
    }
     
     public void set(Bloque bloque){
         Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.update(bloque);
            s.getTransaction().commit();
            System.out.println("Bloque actualizado");
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla al actualizar el Bloque");
        }
     }
     
     public Bloque get(int id) {
        Session s=null;
        Bloque p=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p=(Bloque) s.get(Bloque.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch(Exception e) {
            System.out.println("falla en la devolucion del Bloque id= " + id);
            return null;            
        }
    }
    
    public void borrar(Bloque b){
        Session s = null;
        try{
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Bloque eliminado");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar el bloque");
        }
    }
}
