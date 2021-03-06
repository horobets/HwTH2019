package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBoardPopupPage extends TrelloBasePage {

    private By boardNameImputBy = By.cssSelector(".subtle-input");

    public CreateBoardPopupPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return isElementPresent(boardNameImputBy, 5);
    }

    //public void createBoard(String boardName)
}
