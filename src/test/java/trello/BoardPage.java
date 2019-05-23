package trello;

import org.openqa.selenium.By;
import trello.pages.TrelloBasePage;

import static core.BrowserFactory.driver;

public class BoardPage extends TrelloBasePage {

    private By createNewBoardBtn = By.cssSelector(".mod-add");
    private By boardTitleFld = By.cssSelector(".subtle-input");
    private By createBoardBtn = By.cssSelector(".primary");

    @Override
    public void goToPage() {

    }

    public boolean isOpened() {
        return isElementPresent(createNewBoardBtn, 5);

    }


    public void createBoard(String name) {
        driver.findElement(createNewBoardBtn).click();
        driver.findElement(boardTitleFld).clear();
        driver.findElement(boardTitleFld).sendKeys(name);
        driver.findElement(createBoardBtn).click();
    }
}
