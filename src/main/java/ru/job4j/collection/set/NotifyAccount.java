package ru.job4j.collection.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. Модели данных и HashSet.
 * Данный класс описывает отправку уведомлений таким образом,
 * если подписок несколько, то они должны быть отправлены одним уведомлением.
 * Если мы уберем в классе Account переопределение equals и hashcode, то ТЕСТ УПАДЕТ.
 */
public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account acc : accounts) {
            rsl.add(acc);
        }
        return rsl;
    }
}
