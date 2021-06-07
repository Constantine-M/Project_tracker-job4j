package ru.job4j.collection.map.bank;

import java.util.*;

/**
 * 3. Банковские переводы.
 * Данный класс описывает банковский сервис.
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Данный метод добавляет только пользователя.
     * Изначально список счетов пользователя пустой - добавили пустой список аккаунтов.
     * Сделали проверку на наличие пользователя в коллекции Map<> users.
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
     * нужный нам счет account, который мы передали в метод.
     * 3.Если не содержится, то добавляем значение счета в связку с указанным ключом.
     * @param passport поле класса User.
     * @param account объект класса Account.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> listAccount = users.get(user);
        if (user != null && !listAccount.contains(account)) {
            listAccount.add(account);
        }
    }

    /**
     * В данном методе мы проходим по ключам коллекции users.
     * Ключами являются объекты класса User, которые имеют
     * нужные нам параметры - паспорт и ФИО.
     * Мы проходим циклом по ключам и сравниваем поле passport с данными,
     * которые передаем в метод.
     * @param passport номер паспорта (String).
     * @return пользователя по данным паспорта
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
     * Я взял внимание эту строку в задаче:
     * "Обратите внимание, что в моделях User и Account используется только одно
     * поле passport и requisite для сравнения объектов. Это позволяет использовать
     * эти методы, без информации о всех полях."
     * Таким образом я теоретически с помощью метода indexOf нашел индекс счета,
     * сравнивая только поле "реквизит" (requisite).
     * @param passport номер паспорта (String).
     * @param requisite номер счета (String).
     * @return один из счетов пользователя по реквизитам.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> userAccount = users.get(user);
        if (user != null) {
            for (Account s : userAccount) {
                if (s.getRequisite().equals(requisite)) {
                    int index = userAccount.indexOf(s);
                    return userAccount.get(index);
                }
            }
        }
        return null;
    }

    /**
     * Данный метод позволяет осуществлять перевод средств с одного счета пользователя на другой.
     * Условия нужно объединять с помощью &&.
     * @param srcPassport данные паспорта отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport данные паспорта получаетля.
     * @param destRequisite реквизиты получаетля.
     * @param amount кол-во средств, которое будет переведено.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null && srcAccount!= null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance((destAccount.getBalance() + amount));
            rsl = true;
        }
        return rsl;
    }
}
