package org.integrados.controller.usuarios;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Persona;

public class PersonaABMCtrl {
    
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
            return null;            
        }
    }
    public void guardar(Persona p) {
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
