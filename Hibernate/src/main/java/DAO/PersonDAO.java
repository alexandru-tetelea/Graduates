package DAO;

import com.endava.model.Person;
import com.endava.model.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lordusmd on 17.04.2016.
 */

public class PersonDAO implements GenericDAO<Person, Long> {
    private SessionFactory sessionFactory;
    private Session session;

    public Person create(Person entity) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        return entity;
    }

    public void delete(Person entity) {
        getCurrentSession().delete(entity);
    }

    public Person update(Person person, Person edited) {
        Person persons = find(person);
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (edited.getEmail() != null) {
            persons.setEmail(edited.getEmail());
        }
        if (edited.getFirstName() != null) {
            persons.setFirstName(edited.getFirstName());
        }
        if (edited.getLastName() != null) {
            persons.setLastName(edited.getLastName());
        }
        if (edited.getType() != null) {
            persons.setType(edited.getType());
        }
        em.flush();
        transaction.commit();
        return em.find(Person.class, persons.getId());
    }

    public Person read(Person entity) {
        return null;
    }

    public Set<Person> getAll() {

        EntityManager em = HibernateUtil.getEntityManager();
        return new HashSet<Person>(em.createNamedQuery(Person.FIND_ALL, Person.class).getResultList());


//        try {
//            session = getCurrentSession();
//            return new HashSet<Person>(session.createCriteria(Person.class).list());
//        } finally {
//            session.close();
//        }
    }

    public Person get(Long aLong) {
        EntityManager em = HibernateUtil.getEntityManager();
        return em.find(Person.class, aLong);

//        try {
//            session = getCurrentSession();
//            return (Person) getCurrentSession().get(Person.class, aLong);
//        } finally {
//            session.close();
//        }
    }

    public Session getCurrentSession() {
        return getSession();
    }

    public Person find(Person person) {
        EntityManager em = HibernateUtil.getEntityManager();

        return em.createNamedQuery(Person.FIND_PERSON, Person.class)
                .setParameter("email", person.getEmail())
                .setParameter("firstName", person.getFirstName())
                .setParameter("lastName", person.getLastName())
                .setParameter("type", person.getType())
                .getSingleResult();

    }

    public Set<Person> findByType(Type type) {
        EntityManager em = HibernateUtil.getEntityManager();

        return new HashSet<Person>(em.createNamedQuery(Person.FIND_GRADUATES, Person.class)
                .setParameter("type", type)
                .getResultList());


//        try {
//            session = getCurrentSession();
//            Query query = session
//                    .getNamedQuery("Person.findgraduates")
//                    .setString("ptype", String.valueOf(type));
//            return new HashSet<Person>(query.list());
//        } finally {
//            session.close();
//        }
    }

    public Session getSession() {
        return HibernateUtil
                .getSessionFactory()
                .openSession();
    }
}
