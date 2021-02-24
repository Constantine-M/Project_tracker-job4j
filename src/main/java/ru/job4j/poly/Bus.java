package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {

    }

    @Override
    public void getSeats(int passengers) {

    }

    @Override
    public int fuelPrice(int count) {
        return count * 50;
    }
}
