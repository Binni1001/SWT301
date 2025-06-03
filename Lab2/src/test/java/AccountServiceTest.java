import kietdt.example.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    @DisplayName("isValidEmail returns true for valid email")
    void testValidEmail() {
        assertTrue(accountService.isValidEmail("john@example.com"));
        assertTrue(accountService.isValidEmail("carol@domain.com"));
    }

    @Test
    @DisplayName("isValidEmail returns false for invalid email")
    void testInvalidEmail() {
        assertFalse(accountService.isValidEmail("bobmail.com"));
        assertFalse(accountService.isValidEmail(""));
        assertFalse(accountService.isValidEmail(null));
    }

    @Test
    @DisplayName("registerAccount succeeds with valid inputs")
    void testRegisterAccountSuccess() {
        assertTrue(accountService.registerAccount("john123", "password123", "john@example.com"));
        assertTrue(accountService.registerAccount("carol", "password123", "carol@domain.com"));
    }

    @Test
    @DisplayName("registerAccount throws exception for null username")
    void testRegisterAccountNullUsername() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.registerAccount(null, "password123", "john@example.com"));
    }

    @Test
    @DisplayName("registerAccount throws exception for empty username")
    void testRegisterAccountEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.registerAccount("", "password123", "john@example.com"));
    }

    @Test
    @DisplayName("registerAccount throws exception for short password")
    void testRegisterAccountShortPassword() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.registerAccount("alice", "short", "alice@mail.com"));
    }

    @Test
    @DisplayName("registerAccount throws exception for invalid email")
    void testRegisterAccountInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.registerAccount("bob123", "password123", "bobmail.com"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Parameterized test for registerAccount with CSV data")
    void testRegisterAccountFromCsv(String username, String password, String email, boolean expected) {
        if (expected) {
            assertTrue(accountService.registerAccount(username, password, email));
        } else {
            assertThrows(IllegalArgumentException.class, () ->
                    accountService.registerAccount(username, password, email));
        }
    }

    @Test
    @DisplayName("isStrongPassword returns true for strong password")
    void testStrongPassword() {
        assertTrue(accountService.isStrongPassword("Pass123!"));
        assertTrue(accountService.isStrongPassword("Secure#2025"));
    }

    @Test
    @DisplayName("isStrongPassword returns false for weak password")
    void testWeakPassword() {
        assertFalse(accountService.isStrongPassword("password"));
        assertFalse(accountService.isStrongPassword("Pass123"));
        assertFalse(accountService.isStrongPassword("pass123!"));
        assertFalse(accountService.isStrongPassword(null));
    }

    @Test
    @DisplayName("resetPassword succeeds with strong password")
    void testResetPasswordSuccess() {
        accountService.resetPassword("oldPass123!", "NewPass123!");
        // No exception means success
    }

    @Test
    @DisplayName("resetPassword throws exception for null password")
    void testResetPasswordNull() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.resetPassword("oldPass123!", null));
        assertThrows(IllegalArgumentException.class, () ->
                accountService.resetPassword(null, "NewPass123!"));
    }

    @Test
    @DisplayName("resetPassword throws exception for weak new password")
    void testResetPasswordWeak() {
        assertThrows(IllegalArgumentException.class, () ->
                accountService.resetPassword("oldPass123!", "weak"));
    }
}