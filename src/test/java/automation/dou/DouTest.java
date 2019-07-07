package automation.dou;

import com.skillup.automation.TestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DouTest extends TestRunner {



    @Test
    public void qaJobsTest() {
        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);

        douHomePage
                .open()
                .navigateToJobPage();

        douJobPage
                .chooseQaJobs();


        String vacancyNumber = douJobPage.getKievJobNumber();

        douJobPage
                .clickKievJobs()
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);
    }

    @DataProvider(name = "TestDP")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Kiev", "Lvov"},
                {"Kiev", "Odessa"},
        };
        return data;
    }

    @Test(dataProvider = "TestDP" )
    public void selectJobsTest() {


        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);

        douHomePage
                .open()
                .navigateToJobPage();

        douJobPage
                .chooseQaJobs()
                .selectJobCategory("Java");


        String vacancyNumber = douJobPage.getKievJobNumber();

        douJobPage
                .clickKievJobs()
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);

    }
}
