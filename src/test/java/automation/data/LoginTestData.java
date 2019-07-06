package automation.data;

import org.testng.annotations.DataProvider;

import static com.skillup.automation.utils.StringRandomGenerator.getRandomEmail;

public class LoginTestData {

    @DataProvider(name = "dataLogin")
    public Object[][] getData() {
        Object[][] browserProperty = new Object[][]{
                {getRandomEmail(10), "", "Please enter a password."},
                {getRandomEmail(10), "___!a432sdfsdf", "Hmm, that's not the right password. Please try again or request a new one."}
        };

        return browserProperty;
    }

}
