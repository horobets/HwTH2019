package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KismiaLoginPage extends KismiaBasePage {

    private By switchLoginRegisterViewBy = By.cssSelector(".screen__greeting__button__inner--up");

    private By ksUsernameBy = By.cssSelector(".js_signInForm .js_emailField");
    private By ksPasswordBy = By.cssSelector(".js_signInForm .js_passwordField");

    private By ksRegisterNameBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_nameField");
    private By ksRegisterSearchGenderBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_genderField[value='m']");
    private By ksRegisterUsernameBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_secondStep .js_emailField");
    private By ksRegisterPasswordBy = By.cssSelector(".screen_sign-form .js_signUpForm .js_secondStep .js_passwordField");

    public KismiaLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        driver.navigate().to("https://www.kismia.com");

        isPageLoaded(ksUsernameBy);
    }


    public void loginToKismia(String username, String password) {

        driver.findElement(ksUsernameBy).clear();
        driver.findElement(ksUsernameBy).sendKeys(username);

        driver.findElement(ksPasswordBy).clear();
        driver.findElement(ksPasswordBy).sendKeys(password);

        driver.findElement(ksPasswordBy).sendKeys(Keys.ENTER);

        //return new FbNewsFeedPage(driver);
    }
}
