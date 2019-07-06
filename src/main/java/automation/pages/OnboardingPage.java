package automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OnboardingPage extends CommonPage {
    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    public OnboardingPage assertInOnPage(String partOfUrl) {
        Assert.assertTrue(getUrl().contains(partOfUrl),
                String.format("%s expected, actual: %s", partOfUrl, getUrl()));
        return this;
    }
}
