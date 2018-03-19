import com.thoughtworks.bank.Account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("1234-5678", 2000);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(2000.0));
    }
}
