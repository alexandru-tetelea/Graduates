package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("grads");
    private static EntityManager em = factory.createEntityManager();

    static {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }


    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static EntityManager getEntityManager() {
        return em;
    }

    public static void shutDown() {
        //closes caches and connections
        getSessionFactory().close();
        getEntityManager().close();
    }
}