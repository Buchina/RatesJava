package MyClass;

public class Dialog {
    public void greeting() {
        System.out.println("Добро пожаловать на гонку \"ГлобалЭнималРэйс\"!\nСкорее регистрируйтесь, " +
                "выбирайте бегуна и вносите сумму! \nСамые высокие коэффициенты гарантированы.\n\n" +
                "У Вас уже имеется аккаунт? 1-да, 0-нет");
    }

    public void inform(Account current) {
        System.out.println("\nЗдравствуй, " + current.getLogin() + "!" + " У вас на счету "
                + current.getMoney() + " монет.\n");
    }
}
