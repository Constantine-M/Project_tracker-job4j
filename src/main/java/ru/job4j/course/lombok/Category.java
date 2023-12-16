package ru.job4j.course.lombok;

import lombok.*;

/**
 * Данный класс демонстрирует базовые
 * аннотации при использовании библиотеки
 * Lombok.
 *
 * Аннотация {@link EqualsAndHashCode}
 * – создаёт методы equals() и @hashCode().
 * Эта аннотация имеет параметры, в которых
 * можно указать какие поля использовать
 * для вычисления hashCode, equals.
 *
 * По умолчанию используются все не статические
 * поля. Чтобы явно указать, какие поля
 * использовать в equals и hashCode нужно
 * включить параметр onlyExplicitlyIncuded
 * и отметить нужные поля аннотацией
 * {@link EqualsAndHashCode.Include}.
 *
 * Аннотация {@link RequiredArgsConstructor}
 * создает конструктор по полям отмеченным
 * {@link NonNull}. В нашем случае это поле id.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @EqualsAndHashCode.Include
    @Getter
    private int id;

    @Getter
    @Setter
    private String name;
}
