package ru.job4j.collection.map.bank;

import java.util.*;

/**
 * 3. Банковские переводы.
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
     * 1.1.Лучше вынести список счетов пользователя в отдельную переменную, чтобы не копировать
     * код и не искать дважды.
     * 2.Спрашиваем, содержится ли у ключевого элемента user в списке счетов
     * нужный нам счет {@link Account account}, который мы передали в метод.
     * 3.Если не содержится, то добавляем значение счета в связку с указанным ключом.
     * @param passport поле класса {@link User#passport}.
     * @param account объект класса {@link Account}.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> listAccount = users.get(user);
        if (user != null && !listAccount.contains(account)) {
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
     * @param passport номер паспорта.
     * @return пользователя по данным паспорта
     * или null, если ничего не найдено.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Данный метод позволяет найти счет по реквизитам.
     * Метод {@code indexOf} запускает еще один цикл.
     * Здесь его не используем.
     * В цикле мы проходим по счетам пользователя. Когда находим, что
     * реквизиты совпадают, то просто возвращаем счет. Нам ведь его и нужно найти.
     * @param passport номер паспорта.
     * @param requisite номер счета.
     * @return возвращает счет пользователя
     * по введеным реквизитам или null, если таковой не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> userAccount = users.get(user);
        if (user != null) {
            for (Account s : userAccount) {
                if (s.getRequisite().equals(requisite)) {
                    return s;
                }
            }
        }
        return null;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null && srcAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance((destAccount.getBalance() + amount));
            rsl = true;
        }
        return rsl;
    }
}
