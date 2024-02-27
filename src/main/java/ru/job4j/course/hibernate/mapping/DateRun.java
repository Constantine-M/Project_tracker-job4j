package ru.job4j.course.hibernate.mapping;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author Constantine on 27.02.2024
 */
public class DateRun {

    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("Etc/GMT+13"))
                    .openSession();
            session.beginTransaction();
            var thing = new Thing();
            thing.setName("check timezone");
            thing.setCreated(LocalDateTime.now());
            session.persist(thing);
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
