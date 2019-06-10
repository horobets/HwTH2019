package trello.pages;

import org.openqa.selenium.WebDriver;

public class BoardPage extends TrelloBasePage {
    public BoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
