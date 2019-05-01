package task8.kismia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.KsBasePage;

public class KsMessagesPage extends KsBasePage {

    private By messagesThreadContainerBy = By.cssSelector(".js_fixedThreadContainer");

    public KsMessagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        driver.navigate().to("https://en.kismia.com/messages");

        isElementPresent(messagesThreadContainerBy, 5);
    }
}
