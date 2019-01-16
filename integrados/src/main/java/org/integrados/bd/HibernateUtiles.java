/*
 * En esta clase se crea el Seccion Factory y se agregan metodos para devolver un Session y cerrar el Factory
 */
package org.integrados.bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Mariela
 */
public class HibernateUtiles {

    private static SessionFactory sessionFactory = null;

    private HibernateUtiles() {
    }

    public static void inicializar() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear la comunicacion con la base de datos");
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void finalizar() {
        sessionFactory.close();
    }
}
