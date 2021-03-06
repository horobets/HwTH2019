package task8.kismia.pages.messages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.profile.KsAccountBasePage;

public class KsMessagesListPage extends KsAccountBasePage {

    private By messagesThreadContainerBy = By.cssSelector(".js_fixedThreadContainer");

    public KsMessagesListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        driver.navigate().to("https://en.kismia.com/messages");

        isElementPresent(messagesThreadContainerBy, 5);
    }

    public KsMessagesThreadPage openMessagingThread(int index) {
        return new KsMessagesThreadPage(driver);
    }
}
