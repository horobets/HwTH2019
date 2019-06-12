package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardsPage extends TrelloBasePage {

    private By createNewBoardBtn = By.cssSelector(".mod-add");
    private By boardTitleFld = By.cssSelector(".subtle-input");
    private By createBoardBtn = By.cssSelector(".primary");



    private String boardListItemXpathFormat = "//div[@class='board-tile-details-name']/div[text()='%s']";

    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(createNewBoardBtn, 5);
    }

    public BoardPage createBoard(String name) {
        click(createNewBoardBtn);
        type(boardTitleFld, name);
        click(createBoardBtn);

        BoardPage boardPage = new BoardPage(driver);
        boardPage.isOpened();
        return boardPage;
    }

    public BoardPage openBoard(String name) {

        By boardElement = By.xpath(String.format(boardListItemXpathFormat, name));
        find(boardElement).click();

        BoardPage boardPage = new BoardPage(driver);
        boardPage.isOpened();
        return boardPage;
    }


    public boolean isBoardListed(String name) {

        return isElementPresent(By.xpath(String.format(boardListItemXpathFormat, name)), 3);
    }

}
