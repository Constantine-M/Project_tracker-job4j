package ru.job4j.course.collection.list;

import java.util.List;

/**
 * Данный класс соответствует уроку "Конвертация ArrayList в двухмерный массив".
 */
public class ConvertList2Array {
    /**
     * С помощью метода Math.ceil мы можем округлять в большую сторону.
     * Результат метода возвращает тип double, а нам нужен int, поэтому произвели явное приведение.
     * @param list список.
     * @param cells кол-во ячеек в двухмерном массиве.
     * @return
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        System.out.println(groups);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    /**
     * В первой строке создали из набора элементов (1, 2, 3...)
     * объект List с помощью метода List.of.
     */
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + "");
            }
            System.out.println();
        }
    }
}
