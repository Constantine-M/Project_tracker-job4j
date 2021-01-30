package ru.job4j.inheritance;

/**Сделаем класс ToyCat на основании класса Cat.
 * Чтобы наследовать один класс от другого,
 * нужно после имени класса написать ключевое слово extends
 * и далее указать, какой класс нужно наследовать.
 */
public class ToyCat extends Cat {
    public boolean canBeWashByWashMachine() {
        return true;
    }

    /**Создадим объекты.
     * Объект toy имеет два метода:
     * canPurr, который наследовался от Cat.
     * canBeWashByWashMachine, который объявлен в самом классе ToyCat.
     * Это возможно за счет наследования.
     * Класс ToyCat унаследовал метод purr() от родителя - класса Cat.
     */
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.canPurr());;
        ToyCat toy = new ToyCat();
        System.out.println(toy.canPurr());
        System.out.println(toy.canBeWashByWashMachine());
    }
}
