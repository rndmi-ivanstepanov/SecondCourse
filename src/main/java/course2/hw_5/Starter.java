package course2.hw_5;

import course2.hw_5.exceptions.InvalidPasswordException;
import course2.hw_5.exceptions.WrongLoginException;
import course2.hw_5.exceptions.WrongPasswordException;
import course2.hw_5.utility.Validation;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        String password = sc.nextLine();
//        String confirmPassword = sc.nextLine();

        try {
            Validation.check(login, password, password);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            System.out.println("Ошибка, введенный вами логин не отвечает установленным требованиям");
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            System.out.println("Ошибка, введенный вами пароль не отвечает установленным требованиям");
        } catch (InvalidPasswordException e) {
            e.printStackTrace();
            System.out.println("Ошибка, вы ввели неверный пароль");
        } finally {
            System.out.println("Метод завершил свою работу");
        }
    }
}
