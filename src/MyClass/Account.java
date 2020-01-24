package MyClass;

public class Account {
    public String login;
    public String password;
    public float money;
    public boolean tryRates = false;

    public Account(String login, String password, float money) {
        this.login = login;
        this.password = password;
        this.money = money;
    }

    public String getLogin() {
        return login;
    }

    public float getMoney() {
        return money;
    }

    public boolean checkNewLogin(String loginInput) {
        if (loginInput.equals(login)) return false;
        else return true;
    }

    public boolean enter(String loginInput, String passwordInput) {
        if ((loginInput.equals(login)) && (passwordInput.equals(password))) return true;
        else return false;
    }

    public void Rates(float moneyInput) {
        tryRates = false;
        if ((money - moneyInput) < 0) {
            System.out.println("На вашем счету недостаточно средств. Введите сумму не более " + getMoney());
        } else {
            tryRates = true;
            money -= moneyInput;
            System.out.println("Отлично! На вашем счету " + getMoney() + " монет");
        }
    }

    public void addMoney(float add) {
        money += add;
    }

    public boolean checkAcc() {
        if (money == 0) {
            System.out.println("Участвовать в ставках вы не можете:(\nСпасибо за игру, до свидания!");
            return false;
        } else return true;

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(login + " " + password + " " + money);
        return out.toString();
    }
}
