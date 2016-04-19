package com.endava.model;

import DAO.CourseDAO;
import DAO.PersonDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.ArrayList;

public class Main {

    @PersistenceContext(unitName = "grads")
    private EntityManager entityManager;

    public static void main(String[] args) {


//        Person p = new PersonBuilder().createPerson();
//        Discipline discipline = new Discipline();
//        Observations observations = new Observations();
//        observations.setDate(new Date(new java.util.Date().getTime()));
//        observations.setInformation("blabla");
////        observations.setPerson();
//        tt.setDescription("dsdsf");
//        p.setEmail("asdas");
//        p.setFirstName("asdasd");
//        p.setLastName("asdasd");
//        p.setType(Type.GRADUATE);
//        discipline.setDescription("descriere");

        // loads configuration and mappings
        /*Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry
			= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);


		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();

		StandardServiceRegistryBuilder.destroy(serviceRegistry);*/

        PersonDAO personDAO = new PersonDAO();
        personDAO.create(new PersonBuilder()
                .setEmail("lordusmdd@gmail.com")
                .setLastName("Tetelea")
                .setFirstName("Alexandru")
                .setType(Type.GRADUATE)
                .createPerson());
        personDAO.update(new PersonBuilder()
                .setEmail("lordusmdd@gmail.com")
                .setLastName("Tetelea").setFirstName("Alexandru")
                .setType(Type.GRADUATE)
                .createPerson(), new PersonBuilder()
                .setEmail("lordusmdd@yahoo.com")
                .setType(Type.GRADUATE)
                .createPerson());
        System.out.println(personDAO.get(10L));

        CourseDAO courseDAO = new CourseDAO();
        courseDAO.create(new CourseBuilder().setDescription("TRraining Java")
                .setTraining(new TrainingBuilder()
                        .setDescription("Blabla")
                        .setDisciplines(new ArrayList<Discipline>(){{
                            add(new DisciplineBuilder().setDescription("Descriere").createDiscipline());}})
                        .createTraining())
                .setHours(100L)
                .setPerson(personDAO.get(3L))
                .createCourse());
//        System.out.println(personDAO.get(6L));
//        System.out.println(personDAO.getAll());

        System.out.println(personDAO.findByType(Type.TRAINER));
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("grads");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction t = em.getTransaction();
//        t.begin();
//        em.persist(p);
//        em.persist(tt);
//        em.persist(discipline);
//        t.commit();
//        em.close();


    }

    @Override
    public String toString() {
        return "Main{" +
                "entityManager=" + entityManager +
                '}';
    }

}
