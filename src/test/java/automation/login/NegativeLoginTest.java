package automation.login;

import com.skillup.automation.TestRunner;
import com.skillup.automation.data.LoginTestData;
import com.skillup.automation.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestRunner {
    private static final String EXPECTED_ERROR_MESSAGE = "Please enter a password.";

    private LoginPage loginPage;

    @BeforeMethod
    public void before() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void wrongEmailTest() {
        loginPage
                .open()
                .waitPageToLoad()
                .enterEmail("myemail@email.com")
                .enterPassword("")
                .clickLoginButton()
                .assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);
    }

    @Test(dataProvider = "dataLogin", dataProviderClass = LoginTestData.class)
    public void ddtLoginTest(String email, String pass, String expectedError) {
        loginPage
                .open()
                .enterEmail(email)
                .enterPassword(pass)
                .clickLoginButton()
                .assertEmailErrorMessage(expectedError);
    }
}
