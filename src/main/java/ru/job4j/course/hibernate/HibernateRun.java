package ru.job4j.course.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.model.Item;

import java.util.List;

/**
 * Данный класс демонстрирует операции создания,
 * редактирования, удаления и чтения модели Item
 * при использвании фреймворка Hibernate.
 *
 * {@link SessionFactory} - это объект конфигуратор.
 * Он создается один раз на все приложение.
 * В нем происходит создания пулов, загрузка
 * кешей, проверка моделей. Создание этого
 * объекта трудозатратное.
 *
 * {@link SessionFactory} создается через
 * фабрику {@link StandardServiceRegistryBuilder}.
 * Метод {@link StandardServiceRegistryBuilder#configure()}
 * читает файл hibernate.cfg.xml и выполняет
 * инициализация пула и кешей.
 *
 * SessionFactory имеет метод
 * {@link SessionFactory#openSession()},
 * который отдает объект {@link Session}.
 * Объект Session позволяет записать, удалить
 * и прочитать данные из базы. Этот объект
 * создается быстро.
 *
 * Методы create, update, delete работает
 * с объектом Session.
 * {@link SessionFactory#openSession()}
 * Любое действие с базой происходит в транзакции.
 */
public class HibernateRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            var item = new Item();
            System.out.println("HIBERNATE CREATE -------↴");
            item.setName("Learn Hibernate");
            create(item, sf);
            System.out.println(item);
            System.out.println("HIBERNATE UPDATE -------↴");
            item.setName("Learn Hibernate 5.");
            update(item, sf);
            System.out.println(item);
            System.out.println("HIBERNATE FIND BY ID -------↴");
            Item rsl = findById(item.getId(), sf);
            System.out.println(rsl);
            System.out.println("HIBERNATE DELETE -------↴");
            delete(rsl.getId(), sf);
            System.out.println("HIBERNATE FIND ALL -------↴");
            List<Item> list = findAll(sf);
            for (Item it : list) {
                System.out.println(it);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Данный метод выводит все объекты {@link Item},
     * находящиеся в БД.
     *
     * Hibernate собирает объект сам. Мы не прописываем,
     * какие поля нужно достать.
     *
     * @param sf объект конфигуратор {@link SessionFactory}
     * @return список объектов {@link Item}
     */
    public static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session
                .createQuery("from Item", Item.class)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
