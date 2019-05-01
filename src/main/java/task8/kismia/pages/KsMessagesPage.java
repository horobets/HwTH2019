package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KsMessagesPage extends KsAccountBasePage {

    private By messagesThreadContainerBy = By.cssSelector(".js_fixedThreadContainer");

    public KsMessagesPage(WebDriver driver) {
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
