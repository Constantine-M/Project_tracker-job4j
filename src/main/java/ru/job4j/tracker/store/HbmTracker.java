package ru.job4j.tracker.store;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс описывает реализацию
 * хранилища с использованием Hibernate 5.
 *
 * Начальная загрузка относится к процессу
 * создания и инициализации SessionFactory.
 * Для достижения этой цели нам нужен
 * {@link org.hibernate.service.ServiceRegistry} ,
 * содержащий службы , необходимые для Hibernate.
 * Из этого реестра мы можем создать объект
 * метаданных , который представляет модель
 * предметной области приложения и ее
 * сопоставление с базой данных .
 *
 * Реестр сервисов (ServiceRegistry) позволяет
 * поддерживать различные службы , которые
 * предоставляют функции, необходимые для
 * Hibernate.
 *
 * Существует два типа ServiceRegistry , и
 * они являются иерархическими . Первый — это
 * {@link org.hibernate.boot.registry.BootstrapServiceRegistry},
 * у которого нет родителя.
 * Второй - {@link StandardServiceRegistry} ,
 * основанный на предыдущем BootstrapServiceRegistry,
 * но у него более широкий функционал.
 */
@NoArgsConstructor
public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        return item;
    }

    /**
     * Обновляет Item по ID.
     *
     * @param id идентификатор Item
     * @param item item
     * @return true в случае успеха, иначе false
     */
    @Override
    public boolean replace(int id, Item item) {
        boolean result = true;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                    "UPDATE Item as item SET name = :fName, created = :fCreated WHERE item.id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", item.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            result = false;
            session.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = true;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                    "DELETE Item as item WHERE item.id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            result = false;
            session.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("FROM Item", Item.class);
        return new ArrayList<>(query.list());
    }

    /**
     * Поиск по имени.
     * В данном методе установлено строгое
     * соответствие (LIKE не используется).
     *
     * @param key имя Item
     * @return список Item с одинаковым именем
     */
    @Override
    public List<Item> findByName(String key) {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("FROM Item item WHERE item.name = :fName", Item.class);
        query.setParameter("fName", key);
        return new ArrayList<>(query.list());
    }

    @Override
    public Item findById(int id) {
        Session session = sessionFactory.openSession();
        Query<Item> query = session.createQuery("FROM Item item WHERE item.id = :fId", Item.class)
                .setParameter("fId", id);
        return query.uniqueResult();
    }

    /**
     * Данный метод закрывает регистр сервисов.
     */
    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
