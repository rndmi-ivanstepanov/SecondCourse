package course2.hw_5.utility;

import course2.hw_5.exceptions.InvalidPasswordException;
import course2.hw_5.exceptions.WrongLoginException;
import course2.hw_5.exceptions.WrongPasswordException;

public class Validation {
    private static final int len = 20;
    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException, InvalidPasswordException {
        if (!login.matches("\\w+"))
            throw new WrongLoginException("Введенный пользователем логин содержит недопустимые символы");

        if (login.length() > len)
            throw new WrongLoginException("Введенный пользователем логин превышает максимальную длину");

        if (!password.matches("\\w+"))
            throw new WrongPasswordException("Введенный пользователем пароль содержит недопустимые символы");

        if (password.length() >= len)
            throw new WrongPasswordException("Введенный пользователем пароль превышает максимальную длину");

        if (!password.equals(confirmPassword))
            throw new InvalidPasswordException("Пользователь ввел неверный пароль");
    }
}
