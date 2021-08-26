package ru.job4j.stream.builder;

/**
 * 9. Шаблоны проектирования в Stream API.
 * В данном классе мы реализуем шаблон
 * проектирования "Строитель".
 */
public class User {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;

    @Override
    public String toString() {
        return "Builder{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", activated=" + activated
                + ", gender='" + gender + '\''
                + '}';
    }

    /**
     * Данный класс описывает строителя.
     * 1.Добавляем вложенный статический класс
     * Builder (такое именование является
     * общепринятой практикой).
     * 2.Копируем в наш вложенный класс поля,
     * которые объявлены внутри класса User.
     * 3.Ниже добавим методы, которые будут
     * инициализировать поля, объявленные
     * внутри вложенного класса и при этом
     * возвращать тип Builder.
     */
    public static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Данный метод является завершающим
         * этапом реализации шаблона Строитель.
         * Когда мы вызываем поля User -
         * мы вызываем объект {@link Builder}.
         * @return экземпляр готового объекта
         */
        User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.login = login;
            user.password = password;
            user.activated = activated;
            user.gender = gender;
            return user;
        }
    }

    public static void main(String[] args) {
        User user = new Builder()
                .buildName("Name")
                .buildSurname("Surname")
                .buildAge((byte) 32)
                .buildLogin("Login")
                .buildPassword("Password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);
    }
}
