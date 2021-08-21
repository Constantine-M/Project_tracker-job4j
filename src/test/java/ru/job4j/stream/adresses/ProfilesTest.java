package ru.job4j.stream.adresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 2. Список адресов.
 */
public class ProfilesTest {

    /**
     * Если поменять местами адреса,
     * например первый и второй,
     * то тест завалится, т.к.
     * будет происходить сравнение
     * разных ссылок.
     * Метод {@code List.of()} делает
     * список неизменяемым.
     */
    @Test
    public void whenCollectAddresses() {
        Profiles prof = new Profiles();
        Address firstAd = new Address("Tagil", "Lenina", 1, 111);
        Address secondAd = new Address("Ekb", "Malysheva", 12, 1);
        Address thirdAd = new Address("SPb", "Nauki", 120, 777);
        List<Profile> profiles = List.of(
                new Profile(firstAd),
                new Profile(secondAd),
                new Profile(thirdAd)
        );
        List<Address> result = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(
                new Address("Tagil", "Lenina", 1, 111)
        );
        expected.add(
                new Address("Ekb", "Malysheva", 12, 1)
        );
        expected.add(
                new Address("SPb", "Nauki", 120, 777)
        );
        assertThat(result, is(expected));
    }
}