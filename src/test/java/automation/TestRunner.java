package automation;

import automation.pages.LoginPage;
import automation.pages.OnboardingPage;
import automation.pages.SignUpPage;
import automation.pages.WallPage;
import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.OnboardingPage;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.pages.WallPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static automation.configuration.Wait.FIVE_SECONDS;
import static com.skillup.automation.configuration.Wait.FIVE_SECONDS;

public class TestRunner {
    protected WebDriver driver = null;
    protected LoginPage loginPage;
    protected WallPage wallPage;
    protected SignUpPage signUpPage;
    protected OnboardingPage onboardingPage;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        String property = System.getProperty("user.dir") + "/ChromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FIVE_SECONDS, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        wallPage = new WallPage(driver);
        onboardingPage = new OnboardingPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void closeNotUsedTabs() {
        String currentTab = driver.getWindowHandle();
        List<String> allTabs = new ArrayList<String>(driver.getWindowHandles());

        for (int i = 0; i < allTabs.size(); i++) {
            String tab = allTabs.get(i);
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                driver.close();
            }
        }

        driver.switchTo().window(currentTab);
    }

}
