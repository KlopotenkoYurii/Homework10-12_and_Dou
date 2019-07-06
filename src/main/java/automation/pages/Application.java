package automation.pages;

import org.openqa.selenium.WebDriver;

//класс Application представляет собой класс, который хранит все страницы сайта
//В этом классе, пейджы инициализуруются и создаются к ним доступ через getter методы
//Это один из вариантов где страницы создавать - вместо того чтобы создавать в TestRunner классе
public class Application {

    private WebDriver driver;
    private LoginPage loginPage;
    private WallPage wallPage;
    private SignUpPage signUpPage;
    private OnboardingPage onboardingPage;

    public Application(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        wallPage = new WallPage(driver);
        onboardingPage = new OnboardingPage(driver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public WallPage getWallPage() {
        return wallPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public OnboardingPage getOnboardingPage() {
        return onboardingPage;
    }
}
