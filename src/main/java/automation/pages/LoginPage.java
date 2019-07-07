package automation.pages;

import automation.configuration.Wait;
import com.skillup.automation.configuration.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static automation.configuration.Urls.LOGIN_URL;
import static com.skillup.automation.configuration.Urls.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage extends CommonPage {
    private static final String EMAIL_OR_PHONE_INPUT_XPATH_LOCATOR = "//input[@id='username']";
    private static final String PASSWORD_INPUT_XPATH_LOCATOR = "//input[@id='password']";
    private static final String PASSWORD_TOGGLE_XPATH_LOCATOR = "//span[@id='password-visibility-toggle']";
    private static final String SIGN_IN_BUTTON_XPATH_LOCATOR = "//*[@class = 'login__form']//button";
    private static final String FORGOT_PASSWORD_LINK_XPATH_LOCATOR = "//a[contains(@href, 'request-password-reset')]";
    private static final String JOIN_NOW_LINK_XPATH_LOCATOR = "//a[@href ='/start/join']";
    private static final String ERROR_PASSWORD_DIV_CSS_LOCATOR = "#error-for-password";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(LOGIN_URL);
        return this;
    }

    public LoginPage waitPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Wait.TEN_SECONDS);
        wait.until(presenceOfElementLocated(find(SIGN_IN_BUTTON_XPATH_LOCATOR)));

        return this;
    }

    public void open(String url) {
        driver.get(url);
    }

    public LoginPage enterEmail(String email) {
        enterText(EMAIL_OR_PHONE_INPUT_XPATH_LOCATOR, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(PASSWORD_INPUT_XPATH_LOCATOR, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(SIGN_IN_BUTTON_XPATH_LOCATOR);
        return this;
    }

    public LoginPage assertEmailErrorMessage(String expectedErrorMessage) {
        WebElement errorMessage = driver.findElement(By.cssSelector(LoginPage.ERROR_PASSWORD_DIV_CSS_LOCATOR));
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not match");
        return this;
    }

    public String getEmailErrorMessage() {
        WebElement errorMessage = driver.findElement(By.cssSelector(LoginPage.ERROR_PASSWORD_DIV_CSS_LOCATOR));
        return errorMessage.getText();
    }
}
