package ru.job4j.course.stream.adresses;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов.
 * 3. Уникальность элементов и сортировка.
 */
public class Profiles {
    /**
     * Данный метод формирует список
     * адресов из списка анкет.
     * Задание выполнено с использованием
     * Stream API.
     * @param profiles список анкет.
     * @return список адресов.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Данный метод позволяет отсортировать
     * список и исключить дублирующиеся
     * записи. В нашем случае это имя города.
     * Здесь есть нюанс - даже с более хитрой
     * сортировкой имя города лучше писать
     * с заглавной буквы.
     * @param profiles список анкет.
     * @return список адресов.
     */
    public List<Address> collectUniqSortedList(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
