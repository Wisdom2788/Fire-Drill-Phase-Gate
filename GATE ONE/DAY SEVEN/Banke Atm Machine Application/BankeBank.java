import java.util.ArrayList;
import java.util.Random;

public class BankeBank {

    private ArrayList<Account> accountInformations = new ArrayList<>();

    
    public String createAccount(String firstName, String lastName, String pin) {
        if (!firstName.matches("[a-zA-Z\\s\\-']+")) {
            throw new IllegalArgumentException("First Name should be alphabetic");
        }
        if (!lastName.matches("[a-zA-Z\\s\\-']+")) {
            throw new IllegalArgumentException("Last Name should be alphabetic");
        }
        if (!pin.matches("^\\d{4}$")) {
            throw new IllegalArgumentException("Invalid pin. Pin must be 4 digits.");
        }

        Random numberGenerator = new Random();
        String accountNumber = String.valueOf(numberGenerator.nextInt(100000000));
        Account userAccount = new Account(firstName, lastName, pin, accountNumber);
        accountInformations.add(userAccount);
        return accountNumber;
    }

    public boolean isEmpty() {
        return accountInformations.isEmpty();
    }
    
    public Account findAccountByAccountNumber(String accountNumber) {
        for (Account account : accountInformations) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public void closeAccount(String accountNumber) {
        Account account = findAccountByAccountNumber(accountNumber);
        accountInformations.remove(account);
    }
}
