package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedOutPage extends TrelloBasePage {

    private By loginButtonBy = By.cssSelector("[href='/login']");

    public LoggedOutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(loginButtonBy, 5);
    }
}
