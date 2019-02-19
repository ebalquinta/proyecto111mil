package org.integrados;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.enums.Nivel;
import org.integrados.data.usuarios.Alumno;
import org.integrados.exceptions.IntegradosException;

public class TestEnums {

    public static void main(String[] args) {
        Alumno alumno = new Alumno(344535,"Uha","Hie",5,"c",Nivel.SECUNDARIO);
        alumno.setUsuario("alumna6");
        alumno.setClave("alumna6");
                
        try {
            guardarAlumno(alumno);
        } catch (IntegradosException ex) {
            Logger.getLogger(TestEnums.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void guardarAlumno(Alumno alumno) throws IntegradosException {
        HibernateUtiles.inicializar();
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(alumno);
            s.getTransaction().commit();
            s.close();
        } catch (IntegradosException e) {
        }
    }
   
//    public  Alumno getAlumno(int id) {
//        Session s=null;
//        Alumno a=null;
//        try {
//            s = HibernateUtiles.getSession();
//            s.beginTransaction();
//            a=(Alumno)s.get(Alumno.class, id);
//            s.getTransaction().commit();
//            s.close();
//            return a;
//        } catch(Exception e) {
//            return null;            
//        }
//    }

}
