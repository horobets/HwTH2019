package trello.pages;

import org.openqa.selenium.By;

public class LoggedOutPage extends TrelloBasePage {

    private By loginButtonBy = By.cssSelector("[href='/login']");


    @Override
    public void goToPage() {

    }

    public boolean isOpened() {
        return isElementPresent(loginButtonBy, 5);
    }
}
