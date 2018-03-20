import com.thoughtworks.bank.Account.Account;
import com.thoughtworks.bank.Account.InvalidAccountNumberException;
import com.thoughtworks.bank.Account.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1234-5678", 2000);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(), is(2000.0));
    }
    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(), is("1234-5678"));
    }
    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-4563",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void validateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("123-1233",3000);
    }

    @Test
    public void checkDebitAmount() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1234-5678",3000);
        assertThat(account.getBalance(),is(3000.0));
        account.debitAmount(1000);
        assertThat(account.getBalance(),is(2000.0));
    }
}
