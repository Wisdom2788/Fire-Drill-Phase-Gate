import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankeBankTest {

    @Test
    public void testUserCanCreateAccountWithFirstNameLastNameAndPin() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        assertNotNull(accountNumber);
        assertFalse(bank.isEmpty()); 
    }

    @Test
    public void testUserCanDepositMoney() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        assertEquals(20000, account.getBalance()); 
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
            account.withdrawMoney("1234", 25000);
        });
        assertEquals("Insufficient Balance", errorMessage.getMessage());
    }

    @Test
    public void testAccountCanDisplayBalance() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.deposit("1234", 20000);
        assertEquals(20000, account.displayBalance("1234"));
    }

    @Test
    public void testThatUserAccountHasAnAccountNumber() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        assertEquals(accountNumber, account.getAccountNumber());
    }

    @Test
    public void testAccountCanMakeTransfer() {
        BankeBank bank = new BankeBank();
        String accountNumber1 = bank.createAccount("Wisdom", "Uzoma", "1234");
        String accountNumber2 = bank.createAccount("Prince", "Uzoma", "5678");

        Account account1 = bank.findAccountByAccountNumber(accountNumber1);
        Account account2 = bank.findAccountByAccountNumber(accountNumber2);

        account1.deposit("1234", 20000);
        account1.transferMoney("1234", 5000, account2);

        assertEquals(15000, account1.getBalance());
        assertEquals(5000, account2.getBalance());
    }

    @Test
    public void testUserCanChangePin() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);
        account.changePin("1234", "5678");
        assertEquals("5678", account.getPin());
    }

    @Test
    public void testAccountCanClose() {
        BankeBank bank = new BankeBank();
        String accountNumber = bank.createAccount("Wisdom", "Uzoma", "1234");
        Account account = bank.findAccountByAccountNumber(accountNumber);

        bank.closeAccount(accountNumber);
        assertNull(bank.findAccountByAccountNumber(accountNumber));
    }
}
