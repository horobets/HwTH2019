package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KsLoginPage extends KsBasePage {

    //private By switchLoginRegisterViewBy = By.cssSelector(".screen__greeting__button__inner--up");
    private By switchToLoginViewButtonBy = By.cssSelector(".screen__greeting--sign-in .js-switchSignPage");
    private By switchToRegistrationViewButtonBy = By.cssSelector(".screen__greeting--sign-up .js-switchSignPage");

    private By ksUsernameBy = By.cssSelector(".js_signInForm .js_emailField");
    private By ksPasswordBy = By.cssSelector(".js_signInForm .js_passwordField");

    private By ksRegisterGenderMaleBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_genderField[value='m']");
    private By ksRegisterGenderFemaleBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_genderField[value='f']");
    private By ksRegisterSearchForGenderMaleBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_searchGenderField[value='m']");
    private By ksRegisterSearchForGenderFemaleBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_searchGenderField[value='f']");
    private By ksRegisterNameBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_nameField");

    private By ksRegisterEmailBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_secondStep .js_emailField");
    private By ksRegisterPasswordBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_secondStep .js_passwordField");

    public KsLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        driver.navigate().to("https://www.kismia.com");

        isPageLoaded(ksUsernameBy);
    }


    public void loginToKismia(String username, String password) {

        switchLoginPageView(KsLoginPageView.LOGIN);

        driver.findElement(ksUsernameBy).clear();
        driver.findElement(ksUsernameBy).sendKeys(username);

        driver.findElement(ksPasswordBy).clear();
        driver.findElement(ksPasswordBy).sendKeys(password);

        driver.findElement(ksPasswordBy).sendKeys(Keys.ENTER);

        //return new FbNewsFeedPage(driver);
    }

    public void registerNewAccount(Gender gender, Gender searchGender, String name, String email, String password) {

        //switchLoginPageView(KsLoginPageView.REGISTRATION);

        //register as gender
        switch (gender) {
            case MALE:
                click(ksRegisterGenderMaleBy);
                break;
            case FEMALE:
                click(ksRegisterGenderFemaleBy);
                break;
            default:
                System.err.printf("Unknown gender: %s %n", gender);
                return;
        }

        //search for gender
        switch (searchGender) {
            case MALE:
                click(ksRegisterSearchForGenderMaleBy);
                break;
            case FEMALE:
                click(ksRegisterSearchForGenderFemaleBy);
                break;
            default:
                System.err.printf("Unknown search gender: %s %n", gender);
                return;
        }

        //register name
        driver.findElement(ksRegisterNameBy).clear();
        driver.findElement(ksRegisterNameBy).sendKeys(name);

        //click Enter to switch to the next step
        driver.findElement(ksPasswordBy).sendKeys(Keys.ENTER);

        isElementVisible(ksRegisterEmailBy, 5);

        driver.findElement(ksRegisterEmailBy).clear();
        driver.findElement(ksRegisterEmailBy).sendKeys(email);

        driver.findElement(ksRegisterPasswordBy).clear();
        driver.findElement(ksRegisterPasswordBy).sendKeys(password);

        //submit the registration form
        driver.findElement(ksRegisterPasswordBy).sendKeys(Keys.ENTER);

        //return new FbNewsFeedPage(driver);
    }

    public void switchLoginPageView(KsLoginPageView homePageView) {
        //We are already on the requested view - don't switch
        if (homePageView == getCurrentView())
            return;

        switch (homePageView) {
            case LOGIN:
                driver.findElement(switchToLoginViewButtonBy).click();
                break;
            case REGISTRATION:
                driver.findElement(switchToRegistrationViewButtonBy).click();
                break;
            default:
                System.err.printf("Unsupported KsLoginPageView: %s %n", homePageView);
                return;
        }
        //check successful switch
        if (homePageView != getCurrentView())
            System.err.printf("Failed to switch to %s %n", homePageView);

    }

    public KsLoginPageView getCurrentView() {
        //visible SwitchToRegistrationView button means we are on the LoginView
        if (isElementVisible(switchToRegistrationViewButtonBy, 3))
            return KsLoginPageView.LOGIN;

        //visible SwitchToLoginView button means we are on the RegistrationView
        if (isElementVisible(switchToLoginViewButtonBy, 3))
            return KsLoginPageView.REGISTRATION;

        return null;//unknown view
    }

}
