package automation.pages;

import automation.utils.ElementHelper;
import com.skillup.automation.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static automation.configuration.Urls.SIGN_UP_URL;
import static com.skillup.automation.configuration.Urls.SIGN_UP_URL;

public class SignUpPage {
    private static final String FIRST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='first-name']";
    private static final String LAST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='last-name']";
    private static final String EMAIL_INPUT_XPATH_LOCATOR = "//input[@name='emailAddress']";
    private static final String PASSWORD_INPUT_XPATH_LOCATOR = "//li[contains(@class, 'password-field')]//input";
    private static final String JOIN_BUTTON_XPATH_LOCATOR = "//*[contains(@class, 'join-btn')]";
    private static final String FACEBOOK_BUTTON_XPATH_LOCATOR = "//*[@class = 'fb-btn']";
    private static final String SIGN_IN_BUTTON__CSS_LOCATOR  = ".signin-link > a";
    private static final String ERROR_ALERT_MESSAGE_CSS_LOCATOR = ".uno-alert strong";

    private WebDriver driver;
    private ElementHelper helper = new ElementHelper();

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage enterFirstName(String name) {
        WebElement input = driver.findElement(By.xpath(FIRST_NAME_INPUT_XPATH_LOCATOR));
        helper.enterText(input, name);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        WebElement input = driver.findElement(By.xpath(LAST_NAME_INPUT_XPATH_LOCATOR));
        helper.enterText(input, lastName);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        WebElement input = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH_LOCATOR));
        helper.enterText(input, password);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        WebElement input = driver.findElement(By.xpath(EMAIL_INPUT_XPATH_LOCATOR));
        helper.enterText(input, email);
        return this;
    }

    public SignUpPage clickJoinButton() {
        WebElement button = driver.findElement(By.xpath(JOIN_BUTTON_XPATH_LOCATOR));
        button.click();
        return this;
    }

    public SignUpPage open() {
        driver.get(SIGN_UP_URL);
        return this;
    }
}
