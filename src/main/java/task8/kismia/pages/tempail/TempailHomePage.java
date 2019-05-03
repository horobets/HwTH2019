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

    private By messageSenderBy = By.cssSelector(".gonderen");
    private String messageSenderXpathFormat = "//div[@class='gonderen' and contains(text(), '%s')]";
    private By messageSubjectBy = By.cssSelector(".baslik");
    private String messageSubjectXpathFormat = "//div[@class='baslik' and contains(text(), '%s')]";
    private String messageXpathFormat = "//*[@class='mail ']/a[div[@class='gonderen' and contains(text(), '%s')] and div[@class='baslik' and contains(text(), '%s')]]";

    public TempailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        driver.navigate().to("https://tempail.com/en/");

        isPageLoaded(emailAddressLabelBy);
    }

    public String getEmailAddress() {
        return driver.findElement(emailAddressLabelBy).getAttribute("value");
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
            String messageSender = messageElement.findElement(messageSenderBy).getText();
            String messageSubject = messageElement.findElement(messageSubjectBy).getText();
            String messageLink = messageElement.findElement(By.cssSelector("a")).getAttribute("href");

            receivedMessages.add(new TempailMessage(messageSender, messageSubject, messageLink));
        }
        return receivedMessages;
    }

    public TempailMessage findMessage(String fromEmail, String subjectPart) {
        for (TempailMessage message : getReceivedMessages())
            if (message.getSender().contains(fromEmail) && message.getSubject().contains(subjectPart))
                return message;
        return null;
    }

    public TempailMessage waitForMessage(String fromEmail, String subjectPart, int waitSeconds) {

        By messageToFindBy = By.xpath(String.format(messageXpathFormat, fromEmail, subjectPart));
        if (isElementPresent(messageToFindBy, waitSeconds))
            return findMessage(fromEmail, subjectPart);
        else
            return null;
    }

    public TempailMessagePage openTempailMessage(TempailMessage tempailMessage) {
        return new TempailMessagePage(driver, tempailMessage);
    }

}
