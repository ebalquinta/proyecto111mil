package org.integrados.controller.ABM;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.actividad.Materia;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class MateriaABM {
    
    public void guardar(Materia p) throws IntegradosException {
        Session s = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de Materia");
        }
    }
    
    public Materia get(int id) throws IntegradosException {
        Session s = null;
        Materia p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Materia) s.get(Materia.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch (Exception e) {
            System.out.println("falla en la devolucion de Materia " + id);
            return null;
        }
    }
    
    public void borrar(Materia b) throws IntegradosException{
        Session s = null;
        try{
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Materia eliminado");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar el Materia");
        }
    }
}
