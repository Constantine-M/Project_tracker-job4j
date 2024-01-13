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
        Item item1 = new Item(1, "Item 1", LocalDateTime.now());
        Item item2 = new Item(1, "Item 2", LocalDateTime.now());
        Item item3 = new Item(1, "Item 3", LocalDateTime.now());
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                                                .buildMetadata()
                                                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            insert(session, item1);
            insert(session, item2);
            findAll(session);
            unique(session);
            findById(session, 2);
            System.out.println("UPDATE Item 2");
            update(session, 2);
            System.out.println("AFTER UPDATE Item 2");
            findAll(session);
            System.out.println("DELETE Item 2");
            delete(session, 2);
            System.out.println("AFTER DELETE bebebe");
            findAll(session);
            insert(session, item3);
            System.out.println("AFTER INSERT Item");
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL FIND ALL");
        System.out.println("---------------------------------------------------");
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL FIND UNIQUE ITEM");
        System.out.println("---------------------------------------------------");
        Query<Item> query = session.createQuery(
                "FROM Item as item where item.id = 1", Item.class);
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL FIND ITEM BY ID");
        System.out.println("---------------------------------------------------");
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL UPDATE");
        System.out.println("---------------------------------------------------");
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                    "UPDATE Item SET name = :fName WHERE id = :fId")
                        .setParameter("fName", "be-be-be")
                        .setParameter("fId", id);
            int result = query.executeUpdate();
            System.out.println("Rows Affected: " + result);
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL DELETE");
        System.out.println("---------------------------------------------------");
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

    /**
     * HQL поддерживает вставку только из
     * другой таблицы.
     *
     * То есть команда вроде:
     * "INSERT ... VALUES ..." в HQL не
     * поддерживается! Для простой вставки,
     * какой мы ее знаем, используется
     * {@link Session#save(Object)} как
     * в методе {@link HQLUsage#insert(Session, Item)}.
     */
    public static void insertFromOther(Session session, Item item) {
        System.out.println("---------------------------------------------------");
        System.out.println("HQL INSERT");
        System.out.println("---------------------------------------------------");
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
        System.out.println("---------------------------------------------------");
        System.out.println("HQL INSERT (CLASSIC INSERT)");
        System.out.println("---------------------------------------------------");
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
