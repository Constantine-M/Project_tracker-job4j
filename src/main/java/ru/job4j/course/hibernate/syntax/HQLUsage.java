package ru.job4j.course.hibernate.syntax;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.time.LocalDateTime;

/**
 * Данный класс описывает работу с БД
 * с помощью Hibernate Query Language (HQL).
 *
 * В HQL мы работаем с объектами, которые
 * прописаны в запросе, в отличие от SQL,
 * где мы работаем с таблицами.
 */
public class HQLUsage {

    public static void main(String[] args) {
        Item itemB = new Item(3, "ItemB", LocalDateTime.now());
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                                                .buildMetadata()
                                                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            findAll(session);
            unique(session);
            findById(session, 3);
            update(session, 3);
            System.out.println("AFTER UPDATE Item 3");
            findAll(session);
            delete(session, 3);
            System.out.println("AFTER DELETE new name");
            findAll(session);
            insert(session, itemB);
            System.out.println("AFTER INSERT ItemB");
            findAll(session);
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Данный метод выводит в консоль
     * все объекты {@link Item}.
     *
     * В отличие от SQL нам не обязательно
     * указывать select, а также указывать
     * имя таблицы откуда мы делаем выборку.
     */
    public static void findAll(Session session) {
        System.out.println("HQL FIND ALL");
        Query query = session.createQuery("from Item");
        for (Object st : query.list()) {
            System.out.println(st);
        }
    }

    /**
     * Данный метод ищет {@link Item}
     * по конкретному id = 3.
     *
     * Здесь мы использовали ключевое слово
     * where и выводили результат, используя
     * метод {@link Query#uniqueResult()} -
     * он возвращает единственный объект
     * (не список короче).
     */
    public static void unique(Session session) {
        System.out.println("HQL FIND UNIQUE ITEM");
        Query<Item> query = session.createQuery(
                "FROM Item as item where item.id = 3", Item.class);
        System.out.println(query.uniqueResult());
    }

    /**
     * Данный метод ищет {@link Item}
     * по его ID.
     *
     * Здесь мы уже начинаем пользоваться
     * псевдонимами, при этом использовать
     * конструкцию as - необязательно -
     * просто после имени класса откуда мы
     * делаем выборку, указываем значение
     * псевдонима которое мы будем использовать
     * далее в запросе.
     *
     * В отличие от SQL мы используем
     * подмену параметров по их имени -
     * главное ,чтобы имя указанное в
     * запросе (fId) и имя указанное при
     * установлении параметра - совпадали.
     */
    public static void findById(Session session, int id) {
        System.out.println("HQL FIND ITEM BY ID");
        Query<Item> query = session.createQuery(
                "from Item as item where item.id = :fId", Item.class
        );
        query.setParameter("fId", id);
        /* А можно еще вот так написать
        Query<Item> query = session.createQuery(
                "from Item where id = :id", Item.class
        );
        query.setParameter("id", id);*/
        System.out.println(query.uniqueResult());
    }

    /**
     * Данный метод обновляет {@link Item}
     * по его ID.
     *
     * Для операции обновления необходмо
     * начать транзакцию - для этого мы
     * используем блок try-catch.
     * Если упало исключение - все изменения
     * откатываются.
     */
    public static void update(Session session, int id) {
        System.out.println("HQL UPDATE");
        try {
            session.beginTransaction();
            session.createQuery(
                    "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Данный метод удаляет {@link Item}
     * по его ID.
     *
     * Здесь конструкция аналогична методу
     * update.
     */
    public static void delete(Session session, int id) {
        System.out.println("HQL DELETE");
        try {
            session.beginTransaction();
            session.createQuery(
                    "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insertFromOther(Session session, Item item) {
        System.out.println("HQL INSERT");
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                    "INSERT INTO Item (name, created) SELECT i.name, i.created FROM Item as i");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Данный метод производит вставку
     * {@link Item} в таблицу.
     *
     * Для обычной вставки нужно использовать
     * метод {@link Session#save(Object)}.
     */
    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
