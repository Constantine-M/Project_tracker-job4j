package ru.job4j.pojo;

import java.time.LocalDate;

/**Модель данных - это объект, который используется,
 * как контейнер для примитивных или ссылочных типов данных.
 */
public class Student {
    private String name;
    private String group;
    private LocalDate admission;

    /**Генерируем методы get и set.
     * Эти методы еще называются аксессоры ( От анг. аccess - доступ).
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getAdmission() {
        return admission;
    }

    public void setAdmission(LocalDate admission) {
        this.admission = admission;
    }
}
