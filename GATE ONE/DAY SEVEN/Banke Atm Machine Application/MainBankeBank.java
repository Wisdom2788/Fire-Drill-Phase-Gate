import java.util.Scanner;

public class MainBankeBank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner to take user input
        BankeBank bank = new BankeBank(); // Instance of the bank
        Account userAccount = null;
        boolean accountCreated = false;

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Display Balance");
            System.out.println("7. Change Pin");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Create account
                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter pin (4 digits): ");
                    String pin = scanner.next();
                    String accountNumber = bank.createAccount(firstName, lastName, pin);
                    userAccount = bank.findAccountByAccountNumber(accountNumber);
                    accountCreated = true;
                    System.out.println("Account created successfully. Account number: " + accountNumber);
                    break;

                case 2: // Close account
                    if (userAccount == null) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    userAccount.withdrawMoney(pin, 0); // To check if pin is correct before closing
                    bank.closeAccount(userAccount.getAccountNumber());
                    userAccount = null;
                    accountCreated = false;
                    System.out.println("Account closed successfully.");
                    break;

                case 3: // Deposit
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(pin, depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 4: // Withdraw
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        userAccount.withdrawMoney(pin, withdrawAmount);
                        System.out.println("Withdrawal successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // Transfer
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.next();
                    Account recipientAccount = bank.findAccountByAccountNumber(recipientAccountNumber);
                    try {
                        userAccount.transferMoney(pin, transferAmount, recipientAccount);
                        System.out.println("Transfer successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: // Display Balance
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    userAccount.displayBalance(pin);
                    break;

                case 7: // Change Pin
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter old pin: ");
                    String oldPin = scanner.next();
                    System.out.print("Enter new pin: ");
                    String newPin = scanner.next();
                    try {
                        userAccount.changePin(oldPin, newPin);
                        System.out.println("Pin changed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
