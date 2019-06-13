package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends TrelloBasePage {
    private By boardEditingBy = By.cssSelector(".js-board-editing-target");
    private By openMenuLinkBy = By.cssSelector(".js-show-sidebar");
    private By iconStarBy = By.cssSelector(".icon-star");
    private By visibilityMenuButtonBy = By.cssSelector("#permission-level");
    private By visibilityMenuitemPublicBy = By.cssSelector(".pop-over-list [name='public']");
    private By visibilityMenuitemPrivateBy = By.cssSelector(".pop-over-list [name='private']");
    private By visibilityPublicConfirmationPopupButtonBy = By.cssSelector(".make-public-confirmation-button");

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

    public void changeVisibility(BoardVisibility boardVisibility) {

        openVisibilityMenu();
        switch (boardVisibility) {
            case PUBLIC:
                click(visibilityMenuitemPublicBy);
                click(visibilityPublicConfirmationPopupButtonBy);
                break;
            case PRIVATE:
                click(visibilityMenuitemPrivateBy);
                break;
        }
    }

    public void openVisibilityMenu() {
        click(visibilityMenuButtonBy);
    }
}
