package task8.kismia.pages.messages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.profile.KsAccountBasePage;

public class KsMessagesThreadPage extends KsAccountBasePage {

    private By messageTextAreaBy = By.cssSelector(".chat-controls__textarea");
    private By messageSubmitButtonBy = By.cssSelector(".chat-controls__button-submit");//chat-controls__button-submit js_formComposeSubmit

    public KsMessagesThreadPage(WebDriver driver) {
        super(driver);

        isElementPresent(messageSubmitButtonBy, 5);
    }

    @Override
    public void goToPage() {

    }

    public void sendMessage(String message) {
        typeMessage(message);
        submitMessage();
    }

    public void typeMessage(String message) {
        writeText(messageTextAreaBy, message);
    }

    public void submitMessage() {
        click(messageSubmitButtonBy);
    }
}
