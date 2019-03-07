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
import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.MateriaABM;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.ABM.PlantillaABM;
import org.integrados.controller.estadisticas.AsignarActividadesCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.usuarios.Alumno;
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
        
         Docente d = get(1);
        Actividad a = getr(2);
        
         
        AsignarActividadesCtrl a1 = new AsignarActividadesCtrl(d, a);
      
        
//        ObservarAlumnoDlg ob = new ObservarAlumnoDlg(al);
        
//        
//        Docente d = get(1);
//        List<Alumno> reg = listaPersonas(d.getId());
//        
//        for(Alumno a : reg){
//            System.out.println(a.getNombre() + " " + a.getId());
//        }

//GraficaBrw g = new GraficoDlg();
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
    public static Plantilla getal(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Plantilla p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Plantilla) s.get(Plantilla.class, id);
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
    public static Actividad getr(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Actividad p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Actividad) s.get(Actividad.class, id);
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
    public static Materia getMate(int id) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s = null;
        Materia p = null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p = (Materia) s.get(Materia.class, id);
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
