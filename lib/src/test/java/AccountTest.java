import com.thoughtworks.bank.Account.Account;
import com.thoughtworks.bank.Account.InvalidAccountNumberException;
import com.thoughtworks.bank.Account.InvalidDebitAmountException;
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
    public void shouldGetBalance() {
        assertThat(account.getBalance(), is(2000.0));
    }
    @Test
    public void shouldGetAccountNumber() {
        assertThat(account.getAccountNumber(), is("1234-5678"));
    }
    @Test(expected = MinimumBalanceException.class)
    public void shouldThrowMinimumBalanceExceptionIfBalanceIsLessThanMinimum() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-4563",200);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInvaidAccountNumberExceptionForInvalidAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("123-1233",3000);
    }

    @Test
    public void shouldDebitAnAmountFromAccount() throws MinimumBalanceException, InvalidAccountNumberException, InvalidDebitAmountException {
        account = new Account("1234-5678",3000);
        assertThat(account.getBalance(),is(3000.0));
        account.debitAmount(1000);
        assertThat(account.getBalance(),is(2000.0));
    }

    @Test(expected = InvalidDebitAmountException.class)
    public void shouldThrowInvalidDebitAmountExceptionIfDebitIsInvalid() throws InvalidDebitAmountException {
        account.debitAmount(1000);
    }

    @Test
    public void shouldCreditAmountToAnAccount() {
        assertThat(account.getBalance(),is(2000.0));
        account.creditAmount(1000);
        assertThat(account.getBalance(),is(3000.0));
    }
}
