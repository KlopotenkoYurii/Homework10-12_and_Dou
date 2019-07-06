package automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WallPage extends CommonPage {
    private static final String SEARCH_INPUT = "#global-nav-typeahead input";

    public WallPage(WebDriver driver) {
        super(driver);
    }

    public void assertIsOnPage(String expectedUrl) {
        Assert.assertTrue(getUrl().contains(expectedUrl));
    }

    public void assertSearchInputPresent() {
        Assert.assertTrue(waitTillElementPresent(SEARCH_INPUT));
    }

}
