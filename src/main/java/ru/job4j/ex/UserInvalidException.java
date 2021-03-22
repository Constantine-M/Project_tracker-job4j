package ru.job4j.ex;

import ru.job4j.tracker.UserInputException;

public class UserInvalidException extends UserNotFoundException {
    public UserInvalidException(String message) {
        super(message);
    }
}
