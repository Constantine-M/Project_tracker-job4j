package ru.job4j.course.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Mezenin Konstantin Arkadevich");
        student.setGroup("321-B");
        student.setAdmission(LocalDate.of(2012, 9, 1));

        System.out.println(student.getName() + " зачислен в ВУЗ "
                + student.getAdmission() + " в группу " + student.getGroup());
    }
}
