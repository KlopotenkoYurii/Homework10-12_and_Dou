package automation.login;

import com.skillup.automation.TestRunner;
import com.skillup.automation.data.ReadFromExcelProvider;
import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.WallPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestRunner {

    private LoginPage loginPage;
    private WallPage wallPage;

    @BeforeMethod
    public void before() {
        loginPage = new LoginPage(driver);
        wallPage = new WallPage(driver);
    }

    @Test(dataProvider = "dataLoginFromExcel", dataProviderClass = ReadFromExcelProvider.class)
    public void positiveLogin(String email, String password) {

        loginPage.open()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();

        wallPage.assertSearchInputPresent();
    }
}
