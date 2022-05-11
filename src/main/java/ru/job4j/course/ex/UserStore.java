package ru.job4j.course.ex;

public class UserStore {
    /**
     * Метод проходит по списку и ищет пользователя.
     * @param users список юзеров
     * @param login имя юзера, которого нужно найти
     * @throws UserNotFoundException можно прописать вместо return, т.е.
     * return совсем не нужен.
     * В итоге получим: либо в списке мы находим юзера и он определяется/выводится,
     * либо вылетает исключение "User not found".
     */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    /**
     * Чтобы не городить false, достаточно использовать "!" здесь - !user.isValid().
     */
    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return true;
    }

    /**
     * Если классы находятся в одной ветки иерархии, то первый должен
     * обрабатываться самый нижний класс по иерархии. В нашем случае это UserInvalidException.
     * В большинстве случаев нам нет нужды ловить конкретные исключения.
     * В этом случае можно указать один блок catch с классом Exception.
     * Если мы оставим блок catch (Throwable th), то мы будем захватывать
     * RuntimeException тоже, а это не желательно.
     * Почему нежелательно отлавливать RuntimeException? Потому, что эти исключения относятся
     * к логическим ошибкам в коде и их нужно устранить за счет поиска ошибки в коде,
     * а не за счет обработки исключения.
     */
    public static void main(String[] args) {
        User[] users = {
                new User("Const", true),
                new User("Petr", true),
                new User("Mezenin", false)
        };
        try {
            User user = findUser(users, "Mezenin");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ia) {
            ia.printStackTrace();
        } catch (UserNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
