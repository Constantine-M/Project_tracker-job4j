package ru.job4j.course.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    /**
     * Метод, в который мы передаем двумерный массив, возвращает список.
     * Используется вложенный цикл for-each.
     * В первом цикле мы проходимся по строкам, поэтому указано int[] row.
     * А во втором цикле мы проходимся по ячейкам одномерного массива int[] row.
     * В теле  цикла добавляем ячейку в список.
     * @param array двумерный массив.
     * @return список с данными, которые записали из ячеек массива.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
