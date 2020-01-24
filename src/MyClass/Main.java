package MyClass;

import MyException.BadAnswerException;
import MyException.BadMoneyException;
import MyException.BadNumberException;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] argv) throws IOException, BadAnswerException, InputMismatchException, BadMoneyException {
        Utils util = new Utils();
        String login;
        String password;
        float money;
        String loginInput = "";
        String passwordInput;
        Account current = new Account("0", "0", 0);
        ArrayList<Account> accounts = new ArrayList<Account>();
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
            accounts.add(person);
            buf = in.readLine();
        }
        in.close();
        System.out.println("Добро пожаловать на гонку \"ГлобалЭнималРэйс\"!\nСкорее регистрируйтесь, " +
                "выбирайте бегуна и вносите сумму! \nСамые высокие коэффициенты гарантированы.\n\n" +
                "У Вас уже имеется аккаунт? 1-да, 0-нет");
        Scanner sc = new Scanner(System.in);
        try {
            int answer = sc.nextInt();
            if ((answer != 0) && (answer != 1)) throw new BadAnswerException();
            if (answer == 1) {
                boolean correctAcc = false;
                while (!correctAcc) {
                    System.out.println("Введите логин:");
                    loginInput = sc.next();
                    System.out.println("Введите пароль:");
                    passwordInput = sc.next();
                    for (int i = 0; i < accounts.size(); i++) {
                        correctAcc = accounts.get(i).enter(loginInput, passwordInput);
                        if (correctAcc) {
                            current = accounts.get(i);
                            break;
                        }
                    }
                    if (!correctAcc)
                        System.out.println("Ошибка! Проверьте правильность ввода данных.\nПопробуйте еще раз.\n");
                }
            } else if (answer == 0) {
                boolean newAcc = false;
                System.out.println("Придумайте логин:");
                while (!newAcc) {
                    loginInput = sc.next();
                    for (int i = 0; i < accounts.size(); i++) {
                        newAcc = accounts.get(i).checkNewLogin(loginInput);
                        if (!newAcc) break;
                    }
                    if (!newAcc) System.out.println("Такой логин уже есть:( Придумайте другой логин:");
                }
                System.out.println("Придумайте пароль:");
                passwordInput = sc.next();
                out.write("\n" + loginInput + " " + passwordInput + " " + "1000");
                out.close();
                current = new Account(loginInput, passwordInput, 1000);
                accounts.add(current);
            }
            System.out.println("\nЗдравствуй, " + current.getLogin() + "!" + " У вас на счету "
                    + current.getMoney() + " монет.\n");
            if (!current.checkAcc()) return;
            while (current.getMoney() != 0) {
                float moneyRate = 0;
                while (!current.tryRates) {
                    System.out.println("Сколько монет ваша ставка?");
                    moneyRate = sc.nextFloat();
                    if (moneyRate <= 0) throw new BadMoneyException();
                    current.Rates(moneyRate);
                }
                current.tryRates = false;
                util.rewriteFile(accounts);
                PlayRates match = new PlayRates();
                System.out.println("В гонке участвуют:\n");
                Participant member1 = new Participant(new HorseFactory());
                Participant member2 = new Participant(new DonkeyFactory());
                Participant member3 = new Participant(new CamelFactory());
                Participant member4 = new Participant(new GiraffeFactory());
                Participant[] members = {member1, member2, member3, member4};
                float[] membersCof = new float[4];
                match.preGame(members, membersCof);
                System.out.println("На кого из участников будет ваша ставка?");
                int choice = sc.nextInt();
                if ((choice <= 0) || (choice >= 4)) throw new BadNumberException();
                int win = match.Winner();
                System.out.println("Победитель забега участник №" + (win + 1) + ".\n");
                float addMoney = match.Reward(win, choice - 1, moneyRate, membersCof);
                current.addMoney(addMoney);
                util.rewriteFile(accounts);
                System.out.println("У вас на счету " + current.getMoney() + " монет.\n");
                if (!current.checkAcc()) return;
                System.out.println("Желаете продолжить? 1-да, 0-нет");
                int resume = sc.nextInt();
                if ((resume != 0) && (resume != 1)) throw new BadAnswerException();
                if (resume == 0) {
                    System.out.println("Спасибо за игру, до свидания!");
                    return;
                }
            }
        } catch (BadAnswerException e) {
            System.out.println(e.getMessage());
            return;
        } catch (InputMismatchException e) {
            System.out.println("Но ведь это даже не цифра...Попробуйте еще раз.");
            return;
        } catch (BadMoneyException e) {
            System.out.println(e.getMessage());
            return;
        } catch (BadNumberException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Какие-то пролемы с файлом.");
            return;
        }
    }
}

