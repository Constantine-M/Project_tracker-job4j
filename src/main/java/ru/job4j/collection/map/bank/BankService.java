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
//        if (!users.containsKey(user)) {
//            users.put(user, new ArrayList<Account>());
//        }
    }

    /**
     * Данный метод добавляет счет к пользователю.
     * 1.Находим пользователя.
     * 2.Спрашиваем, содержится ли у ключевого элемента user в списке счетов
     * нужный нам счет account, который мы передали в метод.
     * 3.Если не содержится, то добавляем значение счета в связку с указанным ключом.
     * @param passport поле класса User.
     * @param account объект класса Account.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * В данном методе мы проходим по ключам коллекции users.
     * Ключами являются объекты класса User, которые имеют
     * нужные нам параметры - паспорт и ФИО.
     * Мы проходим циклом по ключам и сравниваем поле passport с данными,
     * которые передаем в метод.
     * @param passport номер паспорта (String).
     * @return
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user != null && user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Не могу никак методом indexOf решить...Только с циклом. Точно есть способ
     * без цикла добраться до методов класса Account...
     * Я взял внимание эту строку в задаче:
     * "Обратите внимание, что в моделях User и Account используется только одно
     * поле passport и requisite для сравнения объектов. Это позволяет использовать
     * эти методы, без информации о всех полях."
     * Таким образом я теоретически с помощью метода indexOf нашел индекс счета,
     * сравнивая только поле "реквизит" (requisite).
     * НЕ ПОНИМАЮ, зачем создавать новый объект в методе indexOf, когда он уже есть в списке.
     * НО ДРУГИХ СПОСОБОВ Я НЕ НАШЕЛ.
     * @param passport номер паспорта (String).
     * @param requisite номер счета (String).
     * @return один из счетов пользователя по реквизитам.
     */
    public Account findByRequisite(String passport, String requisite) {
        List<Account> userAccount = users.get(findByPassport(passport));
        if (userAccount != null) {
            int index = userAccount.indexOf(new Account(requisite, -1));
            return userAccount.get(index);
//            for (Account s : userAccount) {
//                if (s.getRequisite().equals(requisite)) {
//                    int index = userAccount.indexOf(s);
//                    return userAccount.get(index);
//                }
//            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null || srcAccount.getBalance() > amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance((destAccount.getBalance() + amount));
            rsl = true;
        }
        return rsl;
    }
}
