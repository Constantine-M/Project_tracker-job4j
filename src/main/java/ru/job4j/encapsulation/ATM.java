package ru.job4j.encapsulation;

public class ATM {
    /**
     * В одном случае мы пополнили 100$ с помощью метода addMoney.
     * А во втором случае напрямую записали 50$ в поле баланс.
     * В итоге получили нет 150, а всего 50$. То есть объект Account не защищен.
     * P.S. После того, как мы изменили доступ к полю balance,
     * IDEA не дает скомпилировать код (account.balance = 50;), т.к. таким
     * образом пополнить баланс уже не получится. Меняем.
     */
    public static void main(String[] args) {
        Account account = new Account();
        account.addMoney(100);
        account.addMoney(50);
    }
}
