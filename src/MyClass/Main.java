package MyClass;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] argv) throws Exception {
        String login;
        String password;
        float money;
        String loginInput = "";
        String passwordInput;
        Account current = new Account("0", "0", 0);
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
        //System.out.println(a)); // вывод всех аккаунтов
        System.out.println("Добро пожаловать на гонку \"ГлобалЭнималРэйс\"!\nСкорее регистрируйтесь, " +
                "вносите сумму и выбирайте спортсмена! \nСамые высокие коэффициенты гарантированы.\n\n" +
                "У Вас уже имеется аккаунт? 1-да, 0-нет");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == 1) {
            boolean hasAcc = false;
            while (!hasAcc) {
                System.out.println("Введите логин:");
                loginInput = sc.next();
                System.out.println("Введите пароль:");
                passwordInput = sc.next();
                for (int i = 0; i < a.size(); i++) {
                    hasAcc = a.get(i).enter(loginInput, passwordInput);
                    if (hasAcc) {
                        current = a.get(i);
                        break;

                    }
                }
                if (!hasAcc) System.out.println("Ошибка! Проверьте правильность ввода данных.\nПопробуйте еще раз.\n");
            }


        } else if (answer == 0) {
            boolean isAcc = false;
            System.out.println("Придумайте логин:");
            while (!isAcc) {
                loginInput = sc.next();
                for (int i = 0; i < a.size(); i++) {
                    isAcc = a.get(i).checkNewLogin(loginInput);
                    if (!isAcc) break;
                }
                if (!isAcc) System.out.println("Такой логин уже есть:( Придумайте другой логин:");
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
        System.out.println("\nЗдравствуй, " + current.getLogin() + "!" + " У вас на счету "
                + current.getMoney() + " монет.\n");

        if (current.getMoney()==0) { //пожалуй надо запихать в цикл
            System.out.println("К сожалению участвовать в ставках вы больше не можете:(");
            return;
        }


        while (!current.tryRates) {
            System.out.println("Сколько монет ваша ставка?");
            float moneyRate = sc.nextFloat();
            System.out.println(current.Rates(moneyRate));
        }
       FileWriter reOut = new FileWriter("src/MyClass/Accounts.txt", false);
        for (int i = 0; i < a.size(); i++) {
            reOut.write(a.get(i)+"\n");
        }
        reOut.close();


//        System.out.println("Сегодня в гонке участвуют:\n");
//        Participant member1 = new Participant(new HorseFactory());
//        System.out.println("№1" + num1.toString());
//        Participant member2 = new Participant(new DonkeyFactory());
//        System.out.println("№2" + num2.toString());
    }
}

