import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankeBankTest {

    @Test
    public void testUserCanCreateAccountWithFirstNameLastNameAndPin() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        assertNotNull(accountNumber); // Ensure account number is not null when account is created
        assertFalse(bank.isEmpty()); // Ensure bank is not empty after account creation
    }

    @Test
    public void testUserCanDepositMoney() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        assertEquals(20000, account.getBalance()); // Check if the deposit was successful
    }

    @Test
    public void testUserCanWithdrawMoney() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        account.withdrawMoney("1234", 5000);
        assertEquals(15000, account.getBalance()); // Ensure balance is correct after withdrawal
    }

    @Test
    public void testAccountCanDisplayInsufficientBalanceErrorMessage() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        IllegalArgumentException errorMessage = assertThrows(IllegalArgumentException.class, () -> {
            account.withdrawMoney("1234", 25000); // Trying to withdraw more than available balance
        });
        assertEquals("Insufficient Balance", errorMessage.getMessage()); // Check if the error is thrown
    }

    @Test
    public void testAccountCanDisplayBalance() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        assertEquals(20000, account.displayBalance("1234")); // Check if balance is displayed correctly
    }

    @Test
    public void testThatUserAccountHasAnAccountNumber() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        assertEquals(accountNumber, account.getAccountNumber()); // Ensure the account number matches
    }

    @Test
    public void testAccountCanMakeTransfer() {
        BankeBank bank = new BankeBank();
        String accountNumber1 = bank.createAccount("Wisdom", "Uzoma", "1234");
        String accountNumber2 = bank.createAccount("Prince", "Uzoma", "5678");

        Account account1 = bank.findAccountByAccountNumber(accountNumber1);
        Account account2 = bank.findAccountByAccountNumber(accountNumber2);

        account1.deposit("1234", 20000);
        account1.transferMoney("1234", 5000, account2); // Transfer money from account1 to account2

        assertEquals(15000, account1.getBalance()); // Ensure account1 balance is updated
        assertEquals(5000, account2.getBalance()); // Ensure account2 balance is updated
    }

    @Test
    public void testUserCanChangePin() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.changePin("1234", "5678"); // Change pin from 1234  to 5678
        assertEquals("5678", account.getPin()); // Ensure the pin was changed successfully
    }

    @Test
    public void testAccountCanClose() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);

        bank.closeAccount(accountNumber); // Close the account
        assertNull(bank.findAccountByAccountNumber(accountNumber)); // Ensure the account is deleted
    }
}
