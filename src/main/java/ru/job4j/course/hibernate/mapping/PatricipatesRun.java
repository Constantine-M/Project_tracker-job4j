package ru.job4j.course.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Данный класс демонстрирует приницип
 * работы связи "many to many" между
 * таблицами.
 *
 * @author Constantine on 15.02.2024
 */
public class PatricipatesRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            var role = new Role();
            role.setName("ADMIN");
            create(role, sf);
            var user = new User();
            user.setName("Admin Admin");
            user.setMessengers(List.of(
                    new UserMessenger(0, "tg", "@tg"),
                    new UserMessenger(0, "wu", "@wu")
            ));
            user.setRole(role);
            create(user, sf);
            var thing = new Thing();
            thing.setName("Learn Hibernate");
            thing.setParticipates(List.of(user));
            create(thing, sf);
            sf.openSession()
                    .createQuery("from Thing where id = :fId", Thing.class)
                    .setParameter("fId", thing.getId())
                    .getSingleResult()
                    .getParticipates()
                    .forEach(System.out::println);
            delete(thing.getId(), sf);
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static <T> T create(T model, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }

    public static void update(Thing thing, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(thing);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Thing thing = new Thing();
        thing.setId(id);
        session.delete(thing);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Thing> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.course.hibernate.mapping.Thing").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Thing findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Thing result = session.get(Thing.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
