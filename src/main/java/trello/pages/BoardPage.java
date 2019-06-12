package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends TrelloBasePage {
    private By boardEditingBy = By.cssSelector(".js-board-editing-target");
    private By openMenuLinkBy = By.cssSelector(".js-show-sidebar");
    private By iconStarBy = By.cssSelector(".icon-star");

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isElementPresent(boardEditingBy, 5);
    }


    public void deleteBoard() {

        openMenu();

        BoardMenuPage boardMenuPage = new BoardMenuPage(driver);
        boardMenuPage.isOpened();
        boardMenuPage.clickMore();
        boardMenuPage.clickCloseBoard();
        boardMenuPage.clickConfirm();
        boardMenuPage.clickDelete();
        boardMenuPage.clickConfirm();

        isElementPresent(boardEditingBy, 5);
    }

    public boolean isMenuOpened() {
        return new BoardMenuPage(driver).isOpened();
    }

    public void openMenu() {
        if (!isMenuOpened())
            click(openMenuLinkBy);
    }

    public void clickStar() {
        click(iconStarBy);
    }
}
