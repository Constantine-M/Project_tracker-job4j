package ru.job4j.course.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    /**
     * В данном методе мы конвертируем список массивов в список.
     * В отличие от прошлого задания мы первым циклом проходимся по списку (а не по массиву),
     * но в качестве переменной внутри цикла используется одномерный массив.
     * Вторым циклом мы проходимся по значениям в этом одномерном массиве.
     * @param list список массивов.
     * @return список.
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                result.add(cell);
            }
        }
        return result;
    }
}
