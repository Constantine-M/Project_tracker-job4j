package ru.job4j.tracker.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Constantine on 14.03.2024
 */
public class HbmTrackerTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Before
    public void truncate() {
        try(var session = sessionFactory.openSession()) {
            session.beginTransaction();
            String query = "truncate table items restart identity";
            session.createNativeQuery(query).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenUpdateItemThenGetUpdatedItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("current");
            tracker.add(item);
            Item updated = new Item("updatedItem");
            tracker.replace(1, updated);
            assertThat(tracker.findById(1).getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenFindAllItemThenGetThreeItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item first = new Item("first");
            Item second = new Item("second");
            Item third = new Item("third");
            tracker.add(first);
            tracker.add(second);
            tracker.add(third);
            var actual = tracker.findAll();
            var expected = List.of(first, second, third);
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    public void whenDeleteItemThenGetNothing() throws Exception {
        try (var tracker = new HbmTracker()) {
            tracker.add(new Item("deleted"));
            tracker.delete(1);
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenFindByNameThenGetItemWithNameConsta() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("consta");
            tracker.add(item);
            var excepted = List.of(item);
            assertThat(tracker.findByName("consta")).isEqualTo(excepted);
        }
    }

    @Test
    public void whenItemWithId1NotFoundThenThrowsException() throws Exception {
        try (var tracker = new HbmTracker()) {
            assertThatThrownBy(() -> tracker.findById(1)).isInstanceOf(NoSuchElementException.class);
        }
    }

    @Test
    public void whenItemWithId2NotExistsThenNothingToDelete() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("consta");
            tracker.add(item);
            assertThat(tracker.delete(2)).isFalse();
        }
    }
}