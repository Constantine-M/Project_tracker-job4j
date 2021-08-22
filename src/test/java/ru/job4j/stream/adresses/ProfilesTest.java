package ru.job4j.stream.adresses;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 2. Список адресов.
 * 3. Уникальность элементов и сортировка.
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
     * ОБРАТИ ВНИМАНИЕ - тест валился
     * до тех пор пока я не скорректировал
     * equals & hashcode. Выходит, что
     * ранее происходило сравнение
     * по всем полям. Все поля, кроме
     * городов, были разные, поэтому
     * программа думала, что дублей нет.
     * UPD: в общем, надо было сделать
     * одинаковые адреса (чтоб один-в-один),
     * а город - это для сортировки похоже.
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
        List<Address> expected = List.of(
                new Address("Tagil", "Lenina", 1, 111),
                new Address("Ekb", "Malysheva", 12, 1),
                new Address("SPb", "Nauki", 120, 777)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectUniqueAddresses() {
        Profiles prof = new Profiles();
        Address firstAd = new Address("NYC", "Kosciuszko", 1127, 123);
        Address secondAd = new Address("Detroit", "Russell", 2735, 1);
        Address thirdAd = new Address("Compton", "ArtesiaBlvd", 1111, 43);
        Address fourthAd = new Address("Detroit", "Russell", 2735, 1);
        Address fifthAd = new Address("NYC", "Kosciuszko", 1127, 123);
        List<Profile> profiles = List.of(
                new Profile(firstAd),
                new Profile(secondAd),
                new Profile(thirdAd),
                new Profile(fourthAd),
                new Profile(fifthAd)
        );
        List<Address> result = prof.collectUniqSortedList(profiles);
        List<Address> expected = List.of(
                new Address("Compton", "ArtesiaBlvd", 1111, 43),
                new Address("Detroit", "Russell", 2735, 1),
                new Address("NYC", "Kosciuszko", 1127, 123)
        );
        assertThat(result, is(expected));
    }
}