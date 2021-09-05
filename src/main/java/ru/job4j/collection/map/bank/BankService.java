package ru.job4j.collection.map.bank;

import java.util.*;

/**
 * 3. Банковские переводы.
 * 6. Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.
 * 4. Optional в Stream API.
 * Данный класс описывает банковский сервис - его максимально упрощенная версия.
 * @author Constantine
 * @version 1.0
 */
public class BankService {

    /**
     * Данное поле описывает список счетов,
     * которые закреплены за пользователем.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Данный метод добавляет только пользователя.
     * Изначально список счетов пользователя пустой - добавили пустой список аккаунтов.
     * Сделали проверку на наличие пользователя внутри
     * коллекции {@code Map<> users}.
     * @param user пользователь банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Данный метод добавляет счет к пользователю.
     * 1.Находим пользователя.
     * 1.1.Лучше вынести список счетов пользователя
     * в отдельную переменную, чтобы не копировать
     * код и не искать дважды.
     * 2.Спрашиваем, содержится ли у ключевого
     * элемента user в списке счетов
     * нужный нам счет {@link Account account},
     * который мы передали в метод.
     * 3.Если не содержится, то добавляем значение
     * счета в связку с указанным ключом.
     * @param passport паспорт пользователя.
     * @param account банковский счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        List<Account> listAccount = new ArrayList<>();
        if (user.isPresent()) {
            listAccount = users.get(user.get());
        }
        if (!listAccount.contains(account)) {
            listAccount.add(account);
        }
    }

    /**
     * Данный метод находит пользователя по паспорту.
     * Внутри метода мы проходим по ключам коллекции {@code users}.
     * Ключами являются объекты класса {@link User}, которые имеют
     * нужные нам параметры - паспорт и ФИО.
     * Мы проходим циклом по ключам и сравниваем поле {@code passport}
     * с данными, которые передаем в метод.
     * А потом мы переписали все на Stream API
     * с использованием {@link Optional},
     * т.к. данный класс делает наш код
     * более безопасным (null-safety) и
     * читабельным.
     * @param passport номер паспорта.
     * @return пользователя по данным паспорта
     * или null, если ничего не найдено.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Данный метод позволяет найти счет по реквизитам.
     * Метод {@code indexOf} запускает еще один цикл.
     * Здесь его не используем.
     * В цикле мы проходим по счетам пользователя. Когда находим, что
     * реквизиты совпадают, то просто возвращаем счет. Нам ведь его и нужно найти.
     * А потом мы переписали все на Stream API
     * с использованием {@link Optional},
     * т.к. данный класс делает наш код
     * более безопасным (null-safety) и
     * читабельным.
     * @param passport номер паспорта.
     * @param requisite номер счета.
     * @return возвращает счет пользователя
     * по введеным реквизитам или null, если таковой не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(usr -> usr.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Данный метод позволяет осуществлять перевод средств
     * с одного счета пользователя на другой.
     * Условия нужно объединять с помощью {@code &&}.
     * @param srcPassport данные паспорта отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport данные паспорта получаетля.
     * @param destRequisite реквизиты получателя.
     * @param amount кол-во средств, которое будет переведено.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount.isPresent()
                && srcAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance((destAccount.get().getBalance() + amount));
            rsl = true;
        }
        return rsl;
    }
}
