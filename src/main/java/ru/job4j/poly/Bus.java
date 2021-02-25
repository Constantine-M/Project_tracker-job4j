package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Go to Sartavala.");
    }

    @Override
    public void getSeats(int passengers) {
        System.out.println("There are " + passengers + " seats in our transport.");
    }

    @Override
    public int fuelPrice(int count) {
        return count * 50;
    }
}
