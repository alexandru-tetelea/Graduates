package DAO;

import com.endava.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

/**
 * Created by lordusmd on 17.04.2016.
 */
public class CourseDAO implements GenericDAO<Course, Long> {

    private SessionFactory sessionFactory;

    public Course create(Course entity) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        return entity;
    }

    public void delete(Course entity) {
        getCurrentSession().delete(entity);
    }

    public Course update(Course entity, Course edited) {
        return null;
    }

    public Course find(Course entity) {
        return null;
    }

    public Course update(Course entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public Course read(Course entity) {
        return null;
    }

    public Set<Course> getAll() {
        return null;
    }

    public Course get(Long aLong) {
        return (Course) getCurrentSession().get(Course.class, aLong);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
