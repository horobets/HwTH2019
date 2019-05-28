package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage extends TrelloBasePage {

    private By createNewBoardBtn = By.cssSelector(".mod-add");
    private By boardTitleFld = By.cssSelector(".subtle-input");
    private By createBoardBtn = By.cssSelector(".primary");

    private By userButtonBy = By.cssSelector(".member");
    private By logoutMenuitemBy = By.cssSelector(".js-logout");

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(createNewBoardBtn, 5);
    }

    public void createBoard(String name) {
        click(createNewBoardBtn);
        type(boardTitleFld, name);
        click(createBoardBtn);
    }

    public void deleteBoard(String name) {

    }

    public void logOut() {
        isElementPresent(userButtonBy, 5);
        click(userButtonBy);

        isElementPresent(logoutMenuitemBy, 5);
        click(logoutMenuitemBy);

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
