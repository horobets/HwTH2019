package trello.pages;

import org.openqa.selenium.By;

import static core.BrowserFactory.driver;

public class LoginPage extends TrelloBasePage {

    private By emailFld = By.cssSelector("#user");
    private By passwordFld = By.cssSelector("#password");
    private By loginBth = By.cssSelector("#login");

    @Override
    public void goToPage() {
        driver.get("https://trello.com/login");
    }

    public void login(String email, String password) {

        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginBth).click();

    }
}
