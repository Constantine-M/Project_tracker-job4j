package ru.job4j.course.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * Данный класс демонстрирует
 * возможности библиотеки Lombok и
 * в частности аннотацию
 * {@link Builder}, которая реализовывает
 * шаблон строитель.
 *
 * Ключ builderMethodName задает
 * имя метода создания объекта контейнера.
 * По умолчанию он называется builder().
 * Аннотация {@link Singular} позволяет
 * аккумулировать отдельные элементы
 * коллекции. Если ее убрать, то метод
 * rules должен принимать список.
 */
@Builder(builderMethodName = "of")
@Getter
@ToString
public class Permission {

    private int id;

    private String name;

    @Singular("rules")
    private List<String> rules;

    public static void main(String[] args) {
        Permission permission = Permission.of()
                .id(1)
                .name("Full Control")
                .rules("Read")
                .rules("Modify")
                .rules("Write")
                .build();
        System.out.println(permission);
    }
}
