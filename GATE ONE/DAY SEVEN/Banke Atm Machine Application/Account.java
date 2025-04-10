public class Account {

    private final String firstName;
    private final String lastName;
    private String pin;
    private String accountNumber;
    private double balance;

    public Account(String firstName, String lastName, String pin, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Getters for account details
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    // Method to deposit money into the account
    public void deposit(String pin, double amount) {
        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Invalid pin.");
        }
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdrawMoney(String pin, double amount) {
        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Invalid pin.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        this.balance -= amount;
    }

    // Method to display balance
    public double displayBalance(String pin) {
        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Invalid pin.");
        }
        System.out.println("Oga Your Account balance is: " + balance);
        return 0;
    }

    // Method to transfer money from this account to another account
    public void transferMoney(String pin, double amount, Account recipientAccount) {
        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Invalid pin.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        this.balance -= amount;
        recipientAccount.balance += amount;
    }

    // Method to change the pin
    public void changePin(String oldPin, String newPin) {
        if (!this.pin.equals(oldPin)) {
            throw new IllegalArgumentException("Old pin does not match.");
        }
        if (!newPin.matches("^\\d{4}$")) {
            throw new IllegalArgumentException("New pin must be 4 digits.");
        }
        this.pin = newPin;
    }
}
