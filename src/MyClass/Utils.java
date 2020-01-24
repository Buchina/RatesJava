package MyClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public void rewriteFile(ArrayList<Account> accounts) throws IOException {
        FileWriter reOut = new FileWriter("src/MyClass/Accounts.txt", false);
        for (int i = 0; i < accounts.size(); i++) {
            reOut.write(accounts.get(i) + "\n");
        }
        reOut.close();
    }
}
