package ru.job4j.ex;

public class Find {
    /**
     * В данном методе мы избавляемся от паразитной конструкции  if-else-throw.
     * Поэтому я ПАРАЗИТНУЮ ЗАКОММЕНТИРУЮ и рядом укажу, как правильно нужно сделать.
     * Этот вариант сделает код меньше и понятнее.
     */
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }

        /**if (index >= 0 && index < data.length) {
            return data[index];
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }*/

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        System.out.println(Find.get(data, 3));
    }
}
