package task8.kismia.pages.tempail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TempailHomePage extends TempailBasePage {

    private By emailAddressLabelBy = By.id("eposta_adres");

    private By reloadButtonBy = By.cssSelector(".fa-reload");
    private By deleteEmailButtonBy = By.cssSelector(".fa-trashcan");

    private By messageBy = By.cssSelector(".mail");

    public TempailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        driver.navigate().to("https://tempail.com/en/");

        isPageLoaded(emailAddressLabelBy);
    }

    public String getEmailAddress() {
        return readText(emailAddressLabelBy);
    }

    public void deleteEmail() {
        click(deleteEmailButtonBy);
    }

    public void refreshMessageList() {
        click(reloadButtonBy);
    }

    public List<TempailMessage> getReceivedMessages() {
        List<TempailMessage> receivedMessages = new ArrayList<>();
        for (WebElement messageElement : driver.findElements(messageBy)) {
            String messageSender = messageElement.findElement(By.cssSelector(".gonderen")).getText();
            String messageSubject = messageElement.findElement(By.cssSelector(".baslik")).getText();
            String messageLink = messageElement.findElement(By.cssSelector("a")).getAttribute("href");

            receivedMessages.add(new TempailMessage(messageSender, messageSubject, messageLink));
        }
        return receivedMessages;
    }

    public TempailMessagePage openTempailMessage(TempailMessage tempailMessage) {
        return new TempailMessagePage(driver, tempailMessage);
    }
}
