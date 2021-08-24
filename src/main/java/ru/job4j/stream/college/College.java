package ru.job4j.stream.college;

import java.util.Map;
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
    public Student findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    /**
     * Данный метод находит оценку по предмету.
     * В метод передаем идентификатор и
     * наименование предмета.
     * @param account идентификаторю
     * @param name имя предмета.
     * @return оценка по предмету.
     */
    public Subject findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            return students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ));
        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Subject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}
