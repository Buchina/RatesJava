package MyClass;

public class Account {
    public String login;
    public String password;
    public float money;
    public boolean Rates = true;
    public boolean tryRates=false;

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

    public String Rates(float moneyInput) {
        if ((money - moneyInput) < 0) {
            return ("На вашем счету недостаточно средств. Введите сумму не более "+getMoney());
        } else {
            money -= moneyInput;
            tryRates=true;
            return ("Отлично! На вашем счету " + getMoney() + " монет");
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(login + " " + password + " " + money);
        return out.toString();
    }
}
