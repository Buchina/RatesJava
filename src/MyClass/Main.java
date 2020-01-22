package MyClass;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] argv) throws Exception {
        String login;
        String password;
        float money;
        String loginInput;
        String passwordInput;
        Account current=new Account("0","0",0);
        ArrayList<Account> a = new ArrayList<Account>();
        BufferedReader in = new BufferedReader(new FileReader("src/MyClass/Accounts.txt"));
        FileWriter out = new FileWriter("src/MyClass/Accounts.txt", true);
        String buf = in.readLine();
        if (buf == null) return;
        while (buf != null) {
            String[] array = buf.trim().split(" +");
            login = array[0];
            password = array[1];
            money = Float.parseFloat(array[2]);
            Account person = new Account(login, password, money);
            // System.out.println(person.toString()); //вывод объекта аккаунт
            a.add(person);
            buf = in.readLine();
        }
        in.close();
//        System.out.println(a); // вывод всех аккаунтов
        System.out.println("Добро пожаловать на гонку \"ГлобалЭнималРэйс\"!\nСкорее регистрируйтесь, " +
                "вносите сумму и выбирайте спортсмена! \nСамые высокие коэффициенты гарантированы.\n\n" +
                "У Вас уже имеется аккаунт? 1-да, 0-нет");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Введите логин:");
            loginInput = sc.next();
            System.out.println("Введите пароль:");
            passwordInput = sc.next();
            boolean has = false;
            for (int i = 0; i < a.size(); i++) {
                has = a.get(i).enter(loginInput, passwordInput);
                if (has) {
                    current = a.get(i);
                    break;
                }
            }
            while (!has) {
                System.out.println("Ошибка! Проверьте правильность ввода данных.\nПопробуйте еще раз.\n");
                System.out.println("Введите логин:");
                loginInput = sc.next();
                System.out.println("Введите пароль:");
                passwordInput = sc.next();
                for (int i = 0; i < a.size(); i++) {
                    has = a.get(i).enter(loginInput, passwordInput);
                    if (has) {
                        current = a.get(i);
                        break;
                    }
                }
            }

        } else if (answer == 0) {
            boolean is = false;
            System.out.println("Придумайте логин:");
            loginInput = sc.next();
            for (int i = 0; i < a.size(); i++) {
                is = a.get(i).checkNewLogin(loginInput);
                if (!is) break;
            }
            while (!is) {
                System.out.println("Такой логин уже есть:( Придумайте другой логин:");
                loginInput = sc.next();
                for (int i = 0; i < a.size(); i++) {
                    is = a.get(i).checkNewLogin(loginInput);
                    if (!is) break;
                }
            }
            System.out.println("Придумайте пароль:");
            passwordInput = sc.next();
            out.write("\n" + loginInput + " " + passwordInput + " " + "1000");
            out.close();
            current = new Account(loginInput, passwordInput, 1000);
            a.add(current);
        } else {
            System.out.println(":(");
            return;
        }
        System.out.println("Здравствуй, " + current.getLogin()+ "!"+"\nНа вашем счету "
                +current.getMoney()+" монет");
    }
}

