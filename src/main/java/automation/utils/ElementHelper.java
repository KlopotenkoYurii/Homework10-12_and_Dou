package automation.utils;

import org.openqa.selenium.WebElement;

public class ElementHelper {

    public void enterText(WebElement input, String text) {
        input.clear();
        input.sendKeys(text);
    }
}
