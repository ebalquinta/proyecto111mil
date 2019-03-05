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
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.estadisticas.GraficaBrw;



/**
 *
 * @author Yani
 */
public class hshs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IntegradosException {
        
        Alumno al = getal(1);
        
        RegistroActividad r1 = getr(6);
        r1.setEstrella(3);
        r1.setFinalizoCorrectamente(true);
        r1.setIntentos(2);
        guardarR(r1);
        
//        ObservarAlumnoDlg ob = new ObservarAlumnoDlg(al);
        
//        
//        Docente d = get(1);
//        List<Alumno> reg = listaPersonas(d.getId());
//        
//        for(Alumno a : reg){
//            System.out.println(a.getNombre() + " " + a.getId());
//        }

//GraficaBrw g = new GraficaBrw();
//g.setVisible(true);

        
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
    public static Alumno getal(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Alumno p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Alumno) s.get(Alumno.class, id);
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
    public static void guardarR(RegistroActividad p) throws IntegradosException {
        HibernateUtiles.inicializar();
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
     
     
     public static List<Alumno> listaPersonas(int id) throws IntegradosException {
         HibernateUtiles.inicializar();
        List<Alumno> personas = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select alumnos FROM Docente where id_Docente='" + id + "'");
            personas = (List<Alumno>) query.getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {

        }
        return personas;
    }
}
