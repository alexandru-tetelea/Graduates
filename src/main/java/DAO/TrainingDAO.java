package DAO;

import com.endava.model.Training;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by atetelea on 4/18/2016.
 */
public class TrainingDAO implements GenericDAO<Training, Long> {

    private SessionFactory sessionFactory;

    public Training create(Training entity) {
        getCurrentSession().save(entity);
        getCurrentSession().flush();
        return entity;
    }

    public void delete(Training entity) {
        getCurrentSession().delete(entity);
    }

    public Training update(Training entity, Training edited) {
        Training persons = find(entity);
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if (edited.getDescription() != null) {
            persons.setDescription(edited.getDescription());
        }
        em.flush();
        transaction.commit();
        return em.find(Training.class, persons.getId());
    }

    public Training update(Training entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public Training read(Training entity) {
        return null;
    }

    public Set<Training> getAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        return new HashSet<Training>(em.createNamedQuery(Training.FIND_ALL, Training.class).getResultList());
    }

    public Training find(Training person) {
        EntityManager em = HibernateUtil.getEntityManager();

        return em.createNamedQuery(Training.FIND_TRAINING, Training.class)
                .setParameter("description", person.getDescription())
                .getSingleResult();
    }

    public Training get(Long aLong) {
        return (Training) getCurrentSession().get(Training.class, aLong);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
