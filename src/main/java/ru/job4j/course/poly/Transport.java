package ru.job4j.course.poly;

/**
 * Интерфейс будет определять любой вид транспорта.
 */
public interface Transport {
    public void go();

    public void getSeats(int passengers);

    /**
     * Метод показывает, сколько стоит топливо.
     * @return стоимость в зависимости от кол-ва литров
     */
    public int fuelPrice(int count);
}
