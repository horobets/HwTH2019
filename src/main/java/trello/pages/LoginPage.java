package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TrelloBasePage {

    private By emailFld = By.cssSelector("#user");
    private By passwordFld = By.cssSelector("#password");
    private By loginBth = By.cssSelector("#login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        driver.get("https://trello.com/login");
    }

    @Override
    public boolean isOpened() {
        return isElementPresent(loginBth, 10);
    }

    public void login(String email, String password) {

        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginBth).click();

    }
}
