package ru.job4j.course.hibernate.mapping;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static lombok.EqualsAndHashCode.*;

/**
 * Данный класс описывает мессенджеры
 * вроде Skype/Telegram/WhatsApp и пр.
 *
 * @author Constantine on 11.02.2024
 */
@Entity
@Table(name = "j_user_notification")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserMessenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String messenger;

    private String identify;

    public UserMessenger(int id, String messenger, String identify) {
        this.id = id;
        this.messenger = messenger;
        this.identify = identify;
    }
}
