package task8.kismia.pages.tempail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TempailMessagePage extends TempailBasePage {

    private TempailMessage tempailMessage;

    private By messageContentIframeBy = By.id("iframe");

    private String messageSenderXpathFormat = "//div[@class='mail-oku-gonderen' and contains(text(), '%s')]";


    public TempailMessagePage(WebDriver driver, TempailMessage tempailMessage) {
        super(driver);
        this.tempailMessage = tempailMessage;
    }

    @Override
    public void goToPage() {

        driver.navigate().to(tempailMessage.getLink());

        By messageSenderBy = By.xpath(String.format(messageSenderXpathFormat, tempailMessage.getSender()));
        isPageLoaded(messageSenderBy);
    }

    public String getMessageContent() {
        switchToFrame(messageContentIframeBy);
        String messageContent = driver.getPageSource();
        driver.switchTo().defaultContent();
        return messageContent;
    }
}
