package ru.job4j.course.hibernate.toone;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static lombok.EqualsAndHashCode.*;

/**
 * Модель описывает пользователя.
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "j_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String name;

    /**
     * Здесь мы задали отношение между
     * таблицами j_user  и j_role.
     * У одного ползователя может быть
     * много ролей.
     *
     * {@link JoinColumn} показывает,
     * по какому полю идет связь. Обычно
     * это ключевое поле (primary key).
     * В нашем случае так и есть.
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", role=" + role
                +
                '}';
    }
}
