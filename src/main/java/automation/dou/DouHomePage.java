package automation.dou;

import com.skillup.automation.configuration.Urls;
import com.skillup.automation.pages.CommonPage;
import org.openqa.selenium.WebDriver;

public class DouHomePage extends CommonPage {
    private static final String JOB_PAGE_LINK = "header a[href='https://jobs.dou.ua/']";

    public DouHomePage(WebDriver driver) {
        super(driver);
    }

    public DouHomePage open() {
        driver.get(Urls.DOU_URL);
        return this;
    }

    public DouJobPage navigateToJobPage() {
        click(JOB_PAGE_LINK);

        return new DouJobPage(driver);
    }
}
