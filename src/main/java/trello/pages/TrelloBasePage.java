package trello.pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class TrelloBasePage extends BasePage {


    private By userButtonBy = By.cssSelector(".member");
    private By logoutMenuitemBy = By.cssSelector(".js-logout");

    public TrelloBasePage(WebDriver driver) {
        super(driver);
    }


    public void logOut() {
        isElementPresent(userButtonBy, 5);
        click(userButtonBy);

        isElementPresent(logoutMenuitemBy, 5);
        click(logoutMenuitemBy);

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
