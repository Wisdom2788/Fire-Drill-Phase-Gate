import java.util.Scanner;

public class MainBankeBank {

    public static void main(String[] args) 
        Scanner wisdom = new Scanner(System.in);
        BankeBank bank = new BankeBank();
        Scanner scanner = new Scanner(System.in);
        BankeBank bank = new BankeBank(); 
        Account userAccount = null;
        boolean accountCreated = false;

        while (true) {
            System.out.println("<<< WELCOME TO OGUNMEKPON AND SONS BANK / ATM >>>\n");
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Display Balance");
            System.out.println("7. Change Pin");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = wisdom.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = wisdom.next();
                    System.out.print("Enter last name: ");
                    String lastName = wisdom.next();
                    System.out.print("Enter pin (4 digits): ");
                    String pin = wisdom.next();
                    String accountNumber = bank.createAccount(firstName, lastName, pin);
                    userAccount = bank.findAccountByAccountNumber(accountNumber);
                    accountCreated = true;
                    System.out.println("Account created successfully. Account number: " + accountNumber);
                    break;

                case 2:
                    if (userAccount == null) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    userAccount.withdrawMoney(pin, 0); 
                    bank.closeAccount(userAccount.getAccountNumber());
                    userAccount = null;
                    accountCreated = false;
                    System.out.println("Account closed successfully.");
                    break;
                    
                case 3: 
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = wisdom.nextDouble();
                    userAccount.deposit(pin, depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 4:
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = wisdom.nextDouble();
                    try {
                        userAccount.withdrawMoney(pin, withdrawAmount);
                        System.out.println("Withdrawal successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: 
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = wisdom.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = wisdom.nextDouble();
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = wisdom.next();
                    Account recipientAccount = bank.findAccountByAccountNumber(recipientAccountNumber);
                    try {
                        userAccount.transferMoney(pin, transferAmount, recipientAccount);
                        System.out.println("Transfer successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: 
                    if (!accountCreated) {
                        System.out.println("No account created yet.");
                        break;
                    }
                    System.out.print("Enter pin: ");
                    pin = wisdom.next();
                    userAccount.displayBalance(pin);
                    break;

                case 7: 
                    if (!accountCreated) {
                        System.out.println("No account Has been created yet.");
                        break;
                    }
                    System.out.print("Enter old pin: ");
                    String oldPin = wisdom.next();
                    System.out.print("Enter new pin: ");
                    String newPin = wisdom.next();
                    try {
                        userAccount.changePin(oldPin, newPin);
                        System.out.println("\nOga Your Pin changed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("\nExiting...");
                    return;

                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
