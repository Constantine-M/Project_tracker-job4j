package ru.job4j.course.hibernate.toone;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static lombok.EqualsAndHashCode.*;

/**
 * Модель описывает роль пользователя.
 *
 * Для моделей не используем аннотацию
 * lombok {@link lombok.Data}, т.к.
 * имеются подводные камни.
 *
 * В {@link EqualsAndHashCode} добавили
 * только поле id, т.к. только оно уникально.
 *
 * @author Constantine on 10.02.2024
 */
@NoArgsConstructor
@Getter
@Setter
@Table(name = "j_role")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{"
                + "id=" + id
                + ", name='" + name + '\''
                +
                '}';
    }
}
