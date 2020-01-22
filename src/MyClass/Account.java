package MyClass;

public class Account {
    public String login;
    public String password;
    public float money;

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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(login + " " + password + " " + money);
        return out.toString();
    }
}
