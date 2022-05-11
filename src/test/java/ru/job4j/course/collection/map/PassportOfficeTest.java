package ru.job4j.course.collection.map;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PassportOfficeTest {

    /**
     * В данном тесте проверяется сразу 2 метода - add и get в классе PassportOffice.
     * В assertThat, в части expected мы вызываем метод get,
     * который должен вернуть объект класса Citizen.
     * При этом в метод get мы должны передать данные паспорта, поэтому
     * в скобках мы вызывает метод getPassport класса Citizen.
     */
    @Test
    public void whenAdd() {
        Citizen citizen = new Citizen("6514", "Ura Movsisyan");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    /**
     * В этом тесте я в assertThat добавил второго гражданина с тем же ключом
     * и ожидал, что метод вернет false.
     * С гордостью объявляю, что ожидания оправдались.
     */
    @Test
    public void whenCitizenAlreadyExists() {
        Citizen citizen = new Citizen("6514", "Ura Movsisyan");
        Citizen citizenSecond = new Citizen("6514", "Consta");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Assert.assertFalse(office.add(citizenSecond));
    }
}