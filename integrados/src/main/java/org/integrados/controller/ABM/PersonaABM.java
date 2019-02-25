package org.integrados.controller.ABM;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
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
}
