package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    /**Объект phonograph класса Jukebox обращается к методу music,
     * который имеет некоторые входные параметры - position.
     * В зависимости от position объект играет ту или иную мелодию.
     */
    public static void main(String[] args) {
    Jukebox phonograph = new Jukebox();
    phonograph.music(1);
    phonograph.music(2);
    phonograph.music(3);
    }
}
