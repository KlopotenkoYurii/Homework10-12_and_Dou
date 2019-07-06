package automation.pages;

import com.skillup.automation.configuration.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//класс предок для всех страниц
//в этом классе мы создаем общие методы которые будут полезные для работы с элементами на всех страницах
public class CommonPage {
    protected WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    //метод который вводит текст
    public void enterText(String locator, String text) {
        WebElement input = driver.findElement(find(locator));
        input.clear();
        input.sendKeys(text);
    }



    public void selectFromDown(String locator, String value){

        WebElement element = driver.findElement(find(locator));
        Select select = new Select(element);
        select.selectByValue(value);
    }



    public void click(String locator) {
        driver.findElement(find(locator)).click();
    }

    //Находим есть ли элемент через findElements()
    //findElements() - не ожидает появления элемента на странице
    //возвразащет значение мгновенно
    public boolean isElementPresent(String locator) {
        List<WebElement> foundElements = driver.findElements(find(locator));
        return !foundElements.isEmpty();
    }

    //возвращаем текст html элемента,
    //предварительно очистив его от проблелов в начале и конце
    protected String getText(String locator) {
        return driver.findElement(find(locator)).getText().trim();
    }

    protected boolean waitTillElementPresent(String locator) {
        return waitTillElementVisible(locator, Wait.FIVE_SECONDS);
    }

    //общий метод который говорит присутсвует элемент на странице или нет
    //используется explicit wait
    //если выбрасывается исключение - то при перехвати исключения - влзвращаем false
    // значит элемент не был найден за условленное время
    protected boolean waitTillElementPresent(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(find(locator)));
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }

    protected boolean waitTillElementClickable(String locator) {
        return waitTillElementClickable(locator, Wait.FIVE_SECONDS);
    }

    protected boolean waitTillElementClickable(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(find(locator)));
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }

    protected boolean waitTillElementVisible(String locator) {
        return waitTillElementVisible(locator, Wait.FIVE_SECONDS);
    }

    protected boolean waitTillElementVisible(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(find(locator)));
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }

    //метод который определяет как находятся элементы
    //такая реализация возможно ибо принято решение писать локаторы только через XPATH or CSS
    protected By find(String locator) {
        if (locator.startsWith("//") || locator.startsWith("./")) {
            return By.xpath(locator);
        }

        return By.cssSelector(locator);
    }
}
