package ru.job4j.collection.map.bank;

import org.junit.Test;
import org.junit.Assert.*;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankServiceTest {

    @Test
    public void whenAddUser() {
        User user = new User("1234", "Consta");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("1234").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("1234", "Consta");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2143", 999999D));
        assertThat(bank.findByRequisite("12", "2143"), is(Optional.empty()));
    }

    @Test
    public void whenAddAccount() {
        User user = new User("1234", "Consta");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2143", 999999D));
        assertThat(bank.findByRequisite("1234", "2143").get().getBalance(), is(999999D));
    }

    @Test
    public void whenTransferMoney() {
        User user = new User("1234", "Consta");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2143", 999999D));
        bank.addAccount(user.getPassport(), new Account("7586", 150D));
        bank.transferMoney(user.getPassport(), "2143", user.getPassport(),
                "7586", 999998D);
        assertThat(bank.findByRequisite(user.getPassport(), "7586").get().getBalance(),
                is(1000148D));
    }

    @Test
    public void whenAddTwoAccounts() {
        User user = new User("1111", "Batman");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("BM1", 999999D));
        bank.addAccount(user.getPassport(), new Account("BM2", 999999999D));
        assertThat(bank.findByRequisite("1111", "BM2").get().getBalance(),
                is(999999999D));
    }
}