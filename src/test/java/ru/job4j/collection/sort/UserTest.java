package ru.job4j.collection.sort;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Consta", 77));
        users.add(new User("Petr", 29));
        users.add(new User("Petr", 26));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Consta", 77)));
        assertThat(it.next(), is(new User("Petr", 26)));
        assertThat(it.next(), is(new User("Petr", 29)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 25).compareTo(new User(
                "Ivan", 77)
        );
        assertThat(rsl, greaterThan(0));
    }
}