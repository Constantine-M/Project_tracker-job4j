package ru.job4j.ex;

public class UserStore {
    /**
     * Метод проходит по списку и ищет пользователя.
     * @param users список юзеров
     * @param login имя юзера, которого нужно найти
     * @throws UserNotFoundException выбрасывается, когда НЕ НАХОДИМ СОВСЕМ юзера
     */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                return users[i];
            } else if(users[i].getUsername() == null) {
                throw new UserNotFoundException("User not found");
            }
        }
        return null;
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
                new User(null, true),
                new User("Petr", true),
                new User("Mezenin", false)
        };
        try {
            User user = findUser(users, "Consta");
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
