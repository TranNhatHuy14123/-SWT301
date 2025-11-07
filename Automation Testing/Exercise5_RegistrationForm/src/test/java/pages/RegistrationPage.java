package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    private final String URL = "https://demoqa.com/automation-practice-form";

    // Các locator
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("//label[text()='Male']");
    private final By mobile = By.id("userNumber");
    private final By subjectInput = By.id("subjectsInput");
    private final By hobbiesWrapper = By.id("hobbiesWrapper");
    private final By address = By.id("currentAddress");
    private final By submitButton = By.id("submit");
    private final By successModalHeader = By.id("example-modal-sizes-title-lg");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
    }

    public void fillForm(String first, String last, String emailValue, String mobileValue, String addressValue) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(email).sendKeys(emailValue);
        driver.findElement(genderMale).click();
        driver.findElement(mobile).sendKeys(mobileValue);
        driver.findElement(address).sendKeys(addressValue);
    }

    public void fillFormWithHobbies(String first, String last, String emailValue,
                                    String mobileValue, String subject, String addressValue, String[] hobbies) {
        fillForm(first, last, emailValue, mobileValue, addressValue);
        WebElement subjectInputEl = driver.findElement(subjectInput);
        subjectInputEl.sendKeys(subject);
        subjectInputEl.sendKeys(Keys.ENTER);
        for (String hobby : hobbies) {
            WebElement hobbyEl = driver.findElement(By.xpath("//label[text()='" + hobby + "']"));
            hobbyEl.click();
        }
    }

    public void submit() {
        scrollToElement(driver.findElement(submitButton));
        driver.findElement(submitButton).click();
    }

    public By getSuccessModalHeaderLocator() {
        return successModalHeader;
    }

    public WebElement getSubmitButtonElement() {
        return driver.findElement(submitButton);
    }

    public boolean isFieldRequiredMessageDisplayed(String fieldId) {
        WebElement field = driver.findElement(By.id(fieldId));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String message = (String) js.executeScript("return arguments[0].validationMessage;", field);
        return message != null && !message.isEmpty();
    }

    public boolean isEmailInvalid() {
        WebElement field = driver.findElement(email);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        return !valid;
    }

    public boolean isMobileInvalid() {
        WebElement field = driver.findElement(mobile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        return !valid;
    }

    public void scrollToElement(WebElement element) {
        super.scrollToElement(element);
    }

}
