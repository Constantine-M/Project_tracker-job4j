package ru.job4j.stream.college;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 6. Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.
 * Данный класс описывает различные методы поиска.
 */
public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> student) {
        this.students = student;
    }

    /**
     * Данный метод находит студента
     * по его идентификатору.
     * Метод написан с использованием
     * Stream API, в котором задействованы
     * методы
     * {@code findFirst()} - возвращает
     * Optional - является контейнером (оберткой)
     * для значений, который также может
     * безопасно содержать null. В нашем
     * случае вернет объект Student.
     * {@code orElse()} - возвращает
     * значение, если таковое есть, а
     * если нет, то возвращает то, что
     * мы указали в скобках (null).
     * @param account идентификатор.
     * @return студент.
     */
    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst();
    }

    /**
     * Данный метод находит оценку по предмету.
     * В метод передаем идентификатор и
     * наименование предмета.
     * P.S.Все переписали на Optional.
     * 1.При нахождении студента возвращаем
     * {@link Optional}, у которого есть
     * метод {@code get()}. Этот метод
     * возвращает значение {@link Optional},
     * т.е. в нашем случае объект {@link Student}.
     * 2.Проверяем, что наш {@link Optional}
     * не пустой. Если так, то начинаем проход
     * по коллекции студентов
     * {@code students.get(optStudent.get())}.
     * 3.Фильтруем по имени.
     * 4.Возвращаем первое совпадаение.
     * Метод {@code findFirst()}
     * возвращает {@link Optional}.
     * @param account идентификаторю
     * @param name имя предмета.
     * @return оценка по предмету.
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> optStudent = findByAccount(account);
        if (optStudent.isPresent()) {
            return students.get(optStudent.get())
                    .stream()
                    .filter(stud -> stud.getName().equals(name))
                    .findFirst();
        }
        return Optional.empty();
    }
}
