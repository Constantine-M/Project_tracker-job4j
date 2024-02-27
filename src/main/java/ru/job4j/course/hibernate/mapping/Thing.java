package ru.job4j.course.hibernate.mapping;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Это должен был быть класс Item, но
 * он уже есть в нашей БД и на нем
 * построено целое приложение.
 * Лишние связи, которые используеются
 * для изучения Hibernate, поломают
 * существующее приложение и тесты.
 *
 * Поэтому изучаем и экспериментируем на
 * классе Thing.
 *
 * @author Constantine on 14.02.2024
 */
@Entity
@Table(name = "things")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String name;

    private LocalDateTime created;

    /**
     * name - указывает на таблицу, где идет связь вторичных ключей
     * joinColumns -    указывает на колонку в таблице participates,
     *                  на которую будет мапиться наш объект {@link Thing}.
     *                  Эта сущность будет главной между двумя сущностями
     *                  - {@link Thing} и {@link User}.
     *                  По сути это родитель.
     * inverseJoinColumns - указывает на колонку в таблице
     *                      participates, в которую мы хотим присоединить
     *                      наше поле List<User> participates.
     *                      По сути это бъект, который мы загружаем в
     *                      родительский объект.
     */
    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = { @JoinColumn(name = "thing_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participates = new ArrayList<>();
}
