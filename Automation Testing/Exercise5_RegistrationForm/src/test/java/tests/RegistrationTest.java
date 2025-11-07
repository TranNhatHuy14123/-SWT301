package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.RegistrationPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Registration Form Tests (DemoQA)")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTest extends BaseTest {

    static RegistrationPage registrationPage;
    static WebDriverWait wait;

    @BeforeAll
    static void initPage() {
        registrationPage = new RegistrationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    @DisplayName("Should submit form successfully with valid data")
    void testSuccessfulRegistration() {
        registrationPage.navigate();
        registrationPage.fillForm(
                "John",
                "Doe",
                "john.doe@example.com",
                "1234567890",
                "123 Main St"
        );
        registrationPage.submit();

        WebElement successModal = wait.until(ExpectedConditions
                .visibilityOfElementLocated(registrationPage.getSuccessModalHeaderLocator()));

        String headerText = successModal.getText();
        assertTrue(headerText.contains("Thanks for submitting the form"),
                "Modal header text is incorrect!");
    }

    @Test
    @Order(2)
    @DisplayName("Should show required message when fields are empty")
    void testEmptySubmission() {
        registrationPage.navigate();
        registrationPage.submit();

        boolean hasValidationMessage =
                registrationPage.isFieldRequiredMessageDisplayed("firstName") ||
                        registrationPage.isFieldRequiredMessageDisplayed("lastName") ||
                        registrationPage.isFieldRequiredMessageDisplayed("userEmail");

        assertTrue(hasValidationMessage, "Expected browser validation message when submitting empty form!");
    }

    @Test
    @Order(3)
    @DisplayName("Should show validation for invalid email format")
    void testInvalidEmailFormat() {
        registrationPage.navigate();
        registrationPage.fillForm(
                "Huy",
                "Nguyen",
                "invalidEmail",
                "0987654321",
                "HCMC"
        );
        registrationPage.submit();

        boolean isEmailInvalid = registrationPage.isEmailInvalid();
        assertTrue(isEmailInvalid, "Expected invalid email validation!");
    }

    @Test
    @Order(4)
    @DisplayName("Should show validation for short mobile number")
    void testInvalidMobileNumber() {
        registrationPage.navigate();
        registrationPage.fillForm(
                "Linh",
                "Tran",
                "linh.tran@example.com",
                "1234",
                "Hanoi"
        );
        registrationPage.submit();

        boolean isMobileInvalid = registrationPage.isMobileInvalid();
        assertTrue(isMobileInvalid, "Expected mobile field validation for short number!");
    }

    @Test
    @Order(5)
    @DisplayName("Should allow multiple hobby selections and submit")
    void testMultipleHobbiesSelection() {
        registrationPage.navigate();
        registrationPage.fillFormWithHobbies(
                "Mai",
                "Pham",
                "mai.pham@example.com",
                "0981234567",
                "English",
                "Da Nang",
                new String[]{"Sports", "Reading"}
        );
        registrationPage.submit();

        WebElement modal = wait.until(ExpectedConditions
                .visibilityOfElementLocated(registrationPage.getSuccessModalHeaderLocator()));
        assertEquals("Thanks for submitting the form", modal.getText());
    }

    @Test
    @Order(6)
    @DisplayName("Should scroll to Submit button before clicking")
    void testScrollToSubmitButton() {
        registrationPage.navigate();
        WebElement submitBtn = registrationPage.getSubmitButtonElement();
        registrationPage.scrollToElement(submitBtn);
        assertTrue(submitBtn.isDisplayed(), "Submit button should be visible after scroll!");
    }
}
