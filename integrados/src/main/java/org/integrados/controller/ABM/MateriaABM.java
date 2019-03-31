package org.integrados.controller.ABM;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.actividad.Materia;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class MateriaABM {
    
    public void guardar(Materia p) {
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
    
    public Materia get(int id){
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
    public Materia getSegunString(String materia){
        Session s = null;
        Materia mate = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            System.out.println("String de Materia a buscar " + materia);
            Query query = s.createQuery("from Materia where materia='" + materia  + "'");
            mate = (Materia) query.getSingleResult();
            s.getTransaction().commit();
            s.close();
            return mate;
        } catch (Exception e) {
            System.out.println("falla en la devolucion de Materia " + materia);
            return null;
        }
    }
    
    public static String[] getMaterias(){
        Session s = null;
        List<Materia> p = null;
        String[] materias = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            Query query = s.createQuery("FROM Materia m");
            p = query.list();
            s.getTransaction().commit();
            s.close();
            
        } catch (Exception e) {
            System.out.println("falla en la devolucion de lista de Materias");
            return null;
        }
        if (p != null) {
            materias = new String[p.size()];
            for (int i = 0; i < p.size(); i++) {
                materias[i] = p.get(i).getMateria();
            }
        }
        return materias;
    }
    
    public void borrar(Materia b){
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
