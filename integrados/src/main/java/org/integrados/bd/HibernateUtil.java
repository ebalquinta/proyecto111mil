/*
 * En esta clase se crea el Seccion Factory y se agregan metodos para devolver un Session y cerrar el Factory
 */
package org.integrados.bd;

/**
 *
 * @author Mariela
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {
    }

    public static void inicializar() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error al crear la comunicacion con la base de datos")
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void finalizar() {
        sessionFactory.close();
    }
}
