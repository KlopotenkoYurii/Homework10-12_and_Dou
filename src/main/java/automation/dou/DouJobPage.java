package automation.dou;

import com.skillup.automation.configuration.Wait;
import com.skillup.automation.pages.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static automation.configuration.Wait.TWO_SECONDS;
import static com.skillup.automation.configuration.Wait.TWO_SECONDS;
import static sun.rmi.rmic.Main.getText;

public class DouJobPage extends CommonPage {
    private static final String QA_JOBS_LINK ="a[href*='category=QA']";
    private static final String KIEV_JOB_LINK = "//a[contains(text(), 'Киев')]";
    private static final String KIEV_JOB_NUMBER = "//a[contains(text(), 'Киев')]//following-sibling::em";
    private static final String MORE_JOBS_BUTTON = ".more-btn a";
    private static final String ALL_JOBS_LINKS = "#vacancyListId li.l-vacancy";
    private static final String SELECT_JOB_CATEGORY = "[name='category']";

    public DouJobPage(WebDriver driver) {
        super(driver);
    }

    public DouJobPage chooseQaJobs() {
        click(QA_JOBS_LINK);
        return this;
    }
    public DouJobPage selectJobCategory(String category){
        selectFromDown(SELECT_JOB_CATEGORY, category);
        Wait.waitFor(1);
        return this;
    }

    public DouJobPage clickKievJobs() {
        click(KIEV_JOB_LINK);
        return this;
    }

    public String getKievJobNumber() {
        return getText(KIEV_JOB_NUMBER);
    }

    public DouJobPage clickTillMoreJobsButtonExists() {
        while (waitTillElementClickable(MORE_JOBS_BUTTON, TWO_SECONDS)) {
            click(MORE_JOBS_BUTTON);
            Wait.waitFor(Wait.ONE_SECOND);//HARDCODED but leave it as it is
        }

        return this;
    }

    public DouJobPage assertVacancyNumber(String expectedNumber) {
        List<WebElement> allVacancies = driver.findElements(find(ALL_JOBS_LINKS));
        String actualNumber = String.valueOf(allVacancies.size());

        Assert.assertEquals(actualNumber, expectedNumber, "Number of jobs is incorrect");
        return this;
    }
}
