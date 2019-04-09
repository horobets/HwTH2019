package task3.liniakinositscount;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class TiketsOrderPopup extends BasePage {
    public TiketsOrderPopup(WebDriver driver) {
        super(driver);
    }

    private By freeSeatsBy = By.xpath("//div[@class='seat seat-color1']");
    private By reservedSeatsBy = By.xpath("//div[@class='seat seat-occupied']");
    private By orderPopupCloseButtonBy = By.xpath("//div[@class='window-close arcticmodal-close']");

    private By orderPopupIframeBy = By.xpath("//*[@id='vkino-widget']/iframe");
    private By warningGlassesMessageboxCloseButtonBy = By.xpath("//div[@class='window-close arcticmodal-close']");

    public TiketsOrderPopup switchToFrame() {
        driver.switchTo().defaultContent();



        waitVisibility(orderPopupIframeBy);


        FluentWait fwait = new WebDriverWait(driver, 10)
                .withTimeout(ofSeconds(15)).pollingEvery(ofMillis(500))
                .ignoring(ElementNotVisibleException.class, NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(orderPopupIframeBy));

        WebElement seatsListFrame = driver.findElement(orderPopupIframeBy);
        driver.switchTo().frame(seatsListFrame);

        waitVisibility(orderPopupCloseButtonBy);//wait for popup to load
        return this;
    }

    public SeatsInfo getSeatsInfoOfLatestShowtime() {
        SeatsInfo seatsInfo = new SeatsInfo(getNumberOfFreeSeats(), getNumberOfReservedSeats());
        return seatsInfo;
    }

    public int getNumberOfFreeSeats() {
        return driver.findElements(freeSeatsBy).size();
    }

    public int getNumberOfReservedSeats() {
        return driver.findElements(reservedSeatsBy).size();
    }

    public void closeWarningGlasses()
    {
        isElementPresent(warningGlassesMessageboxCloseButtonBy, 5);

        wait.until(ExpectedConditions.elementToBeClickable(warningGlassesMessageboxCloseButtonBy));

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(warningGlassesMessageboxCloseButtonBy)).click().build().perform();
    }
}