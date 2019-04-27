package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FbMessengerPage extends FbBasePage {

    private String profileMessengerLink;

    private By messageTextField = By.cssSelector("[aria-label^='Type a message']");

    public FbMessengerPage(WebDriver driver) {
        super(driver);
    }

    public FbMessengerPage(WebDriver driver, String profileMessengerLink) {
        super(driver);
        this.profileMessengerLink = profileMessengerLink;
    }

    @Override
    public void goToPage() {

        if (!profileMessengerLink.isEmpty())
            driver.navigate().to(profileMessengerLink);
        else
            driver.navigate().to("https://www.facebook.com/messages/t");

        isPageLoaded(messageTextField);
    }

    public void sendMessage(String message) {
        WebElement messageTextFieldElement = driver.findElement(messageTextField);

        messageTextFieldElement.sendKeys(message);
        messageTextFieldElement.sendKeys(Keys.ENTER);
    }
}