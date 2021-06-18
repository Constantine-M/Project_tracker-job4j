package ru.job4j.encapsulation;

/**Это класс для хранения информации о счете клиента*/
public class Account {
    /**В данном поле отсутствует модификатор доступа, а
     * значит он по умолчанию default. Поэтому мы можем записать данные напрямую в это поле.
     * Классы Account и ATM находятся внутри одного пакета encapsulation.
     * P.S. Поменяли модификатор на private.
     */
    private int balance;

    /**
     * Данный метод осуществляет пополнение счета.
     * @param money деньги, которые вносим.
     */
    public void addMoney(int money) {
        if (money > 0) {
            balance += money;
        }
    }
}
