package automation.signup;

import com.skillup.automation.TestRunner;
import org.testng.annotations.Test;

import static com.skillup.automation.utils.StringRandomGenerator.generateString;
import static com.skillup.automation.utils.StringRandomGenerator.getRandomEmail;

public class SignUpTest extends TestRunner {

    @Test(description = "My test does")
    public void signupTest() {
        String email = getRandomEmail(10);

        signUpPage
                .open()
                .enterFirstName("firstName")
                .enterLastName("lastName")
                .enterEmail(email)
                .enterPassword(generateString())
                .clickJoinButton();

        onboardingPage.assertInOnPage("/onboarding");
    }
}
