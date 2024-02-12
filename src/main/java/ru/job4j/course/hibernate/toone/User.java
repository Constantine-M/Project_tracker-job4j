package ru.job4j.course.hibernate.toone;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
@AllArgsConstructor
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

    /**
     * Параметр cascade определяет стратегию
     * поведения каскадных операций. В нашем
     * случае, при удалении user удаляются все
     * закрепленные за ним мессенджеры.
     *
     * Для связи one-to-many обязательно нужно
     * указывать колонку для вторичного ключа.
     * Если это не сделать, то hibernate будет
     * создавать отдельную таблицу, а не
     * использовать нашу схему.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "j_user_id")
    private List<UserMessenger> messengers = new ArrayList<>();

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
