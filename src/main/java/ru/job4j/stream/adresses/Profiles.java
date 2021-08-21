package ru.job4j.stream.adresses;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов.
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
}
