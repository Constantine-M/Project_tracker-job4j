package ru.job4j.oop;

public class Battery {
    /**Создал поле load класса Battery.
     * Поле будет заполнено значением заряда батареи.
     */
    private int load;

    /**Создал конструктор, в котором описал класс Battery.
     * Теперь у объектов класса Battery имеется определенный заряд батареи.
     */
    public Battery(int size) {
        this.load = size;
    }

    /**Создал метод, который будет принимать объект типа Battery.
     * С помощью метода exchange мы будем обращаться к тому или иному объекту класса Battery.
     * А потом разряжать первый объект и заряжать второй.
     */
    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery powerBank = new Battery(28);
        Battery battery = new Battery(72);
        System.out.println("Battery charge: " + powerBank.load
                + ". Phone battery: " + battery.load);
        powerBank.exchange(battery);
        System.out.println("Battery charge: " + powerBank.load
                + ". Phone battery: " + battery.load);
    }
}
