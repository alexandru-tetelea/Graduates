package DAO;

import com.endava.model.Discipline;
import com.endava.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lordusmd on 17.04.2016.
 */
public class DisciplineDAO implements GenericDAO<Discipline, Long> {
    private SessionFactory sessionFactory;

    public Discipline create(Discipline entity) {
        getCurrentSession().save(entity);
        getCurrentSession().flush();
        return entity;
    }

    public void delete(Discipline entity) {
        getCurrentSession().delete(entity);
    }

    public Discipline update(Discipline entity, Discipline edited) {
        Discipline persons = find(entity);
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (edited.getDescription() != null) {
            persons.setDescription(edited.getDescription());
        }

        if (edited.getTrainings() != null) {
            persons.setTrainings(edited.getTrainings());
        }
        em.flush();
        transaction.commit();
        return em.find(Discipline.class, persons.getId());
    }

    public Discipline update(Discipline entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public Discipline read(Discipline entity) {
        return null;
    }

    public Set<Discipline> getAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        return new HashSet<Discipline>(em.createNamedQuery(Discipline.FIND_ALL, Discipline.class).getResultList());
    }

    public Discipline find(Discipline person) {
        EntityManager em = HibernateUtil.getEntityManager();

        return em.createNamedQuery(Discipline.FIND_DISCIPLINE, Discipline.class)
                .setParameter("description", person.getDescription())
                .getSingleResult();
    }

    public Discipline get(Long aLong) {
        return (Discipline) getCurrentSession().get(Discipline.class, aLong);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
