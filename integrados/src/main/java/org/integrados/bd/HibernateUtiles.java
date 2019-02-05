/*
 * En esta clase se crea el Seccion Factory y se agregan metodos para devolver un Session y cerrar el Factory
 */
package org.integrados.bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;

/**
 *
 * @author Grupo Front
 */
public class HibernateUtiles {

    private static SessionFactory sessionFactory = null;

    private HibernateUtiles() {
    }

    public static void inicializar() throws IntegradosException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IntegradosException("Error de inicialización de Hibernate");
        }
    }

    public static Session getSession() throws IntegradosException {
        if (sessionFactory == null) 
            throw new IntegradosException("No se ha creado un SessioFactory");
        
        return sessionFactory.openSession();
    }

    public static void finalizar() {
        sessionFactory.close();
    }
}
