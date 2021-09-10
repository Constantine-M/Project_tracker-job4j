package ru.job4j.stream.attestation;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2. Аттестация.
 * Данный класс получает статистику
 * по аттестатам.
 */
public class Analyze {
    /**
     * Данный метод вычисляет общий средний балл.
     * @param stream поток учеников с именами и их предметами.
     * @return общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Данный метод вычисляет средний
     * балл ученика по его предметам.
     * @param stream поток учеников с
     *               именами и их предметами.
     * @return список, содержащий в себе
     * информацию вида "предмет/балл".
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Данный метод вычисляет средний балл
     * по всем предметам для каждого ученика.
     * 1.flatMap() для преобразования в поток объектов Subject;
     * 2.промежуточный пункт - сбор данных
     * в карту с помощью метода {@code groupingBy()}.
     * Этот метод как раз возвращает карту {@link Map},
     * где ключ - это имя предмета, а значение -
     * это средний балл по этому предмету для каждого ученика.
     * 3.Чтобы пройтись по {@link Map} используем
     * метод {@code entrySet()}. Он возвращает
     * набор ключ-значений.
     * 4.Открываем поток.
     * 5.Чтобы получить новый поток объектов {@link Tuple},
     * используем метод {@code map()} для
     * преобразования текущего потока.
     * В лямбду передаем {@code entry} a.k.a {@code Map.entry()},
     * чтобы получить ключи и значения карты.
     * 6.Собираем в список.
     * @param stream поток учеников с
     *               именами и их предметами.
     * @return список, содержащий в себе
     * информацию вида "предмет/балл".
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Данный метод возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream поток учеников с
     *               именами и их предметами.
     * @return лучший ученик.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .mapToDouble(Subject::getScore)
                                .sum()))
                .max((left, right) -> left.getScore() > right.getScore() ? 1 : -1)
                .orElse(null);

    }

    /**
     * Данный метод определяет предмет
     * с наибольшим баллом для всех студентов.
     * В методе структура Comparator.comparing()
     * предназначена для использования с объектами
     * с несколькими полями, поэтому вы можете
     * извлечь нужное поле, которое будет
     * использоваться в качестве ключа.
     * @param stream поток учеников с
     *               именами и их предметами.
     * @return объект {@link Tuple}
     * (имя предмета, сумма баллов каждого
     * ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
