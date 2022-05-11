package ru.job4j.course.oop.updowncastparttwo;

public class PolyUsage {
    /**
     * В чем же еще практическая польза всего ниже изложенного?
     * А в том, что мы можем все что мы писали в этом задании переписать
     * на интерфейс Animal, в который мы вынесем метод, который будет доступен всем животным,
     * однако для каждого он будет иметь собственную реализацию.
     * При этом мы избавимся от промежуточных классов DomesticAnimal и Pet.
     * Я специально здесь все оставил как есть, чтобы логика объяснения материала
     * осталась.
     * В другом классе с методом main будет отображена реализация интерфейса.
     */
    public static void main(String[] args) {
        Animal animal = new Animal();
        /**
         * Декларируем переменную типа Animal, но присваиваем ей объект класса DomesticAnimal.
         * Здесь мы объект рассматриваем как его родителя.
         * И теперь переменная domesticAnimal будет иметь методы только те,
         * которые присущи классу Animal.
         */
        Animal domesticAnimal = new DomesticAnimal();
        /**Ниже все то же самое.*/
        Animal cow = new Cow();
        Animal goose = new Goose();
        Animal pet = new Pet();
        Animal dog = new Dog();
        Animal guineaPig = new GuineaPig();
        /**
         * Мы привели объекты всех классов к более общему типу.
         * Поэтому мы можем их всех добавить в массив и вызвать у каждого метод.
         * Но при этом метод у всех будет одинаков - sound(),
         * потому что у класса Animal только один метод - sound().
         */
        Animal[] animals = new Animal[] {animal, domesticAnimal, cow, goose, pet, dog, guineaPig};
        for (Animal anim : animals) {
            anim.sound();
        }
    }
}
