import DE180675_Tran_Nhat_Huy.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @ParameterizedTest(name = "Test {index}: username={0}, password={1}, email={2} => expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result,
                () -> " Failed for: username=" + username + ", password=" + password + ", email=" + email);
    }
}
