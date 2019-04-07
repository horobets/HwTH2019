package task3.liniakinositscount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TiketsOrderPopup extends BasePage {
    public TiketsOrderPopup(WebDriver driver) {
        super(driver);
    }

    private By freeSeatsBy = By.xpath("//div[@class='seat seat-color1']");
    private By reservedSeatsBy = By.xpath("//div[@class='seat seat-occupied']");
    private By warningPopupCloseButtonBy = By.xpath("//div[@class='window-close arcticmodal-close']");


    public TiketsOrderPopup switchToFrame() {
        driver.switchTo().defaultContent();

        WebElement seatsListFrame = driver.findElement(By.xpath("//iframe[contains(@src, 'bilet.vkino.com.ua')]"));
        driver.switchTo().frame(seatsListFrame);

        waitVisibility(warningPopupCloseButtonBy);//wait for popup to load
        return this;
    }

    public SeatsInfo getSeatsInfoOfLatestShowtime() {
        SeatsInfo seatsInfo = new SeatsInfo(getNumberOfFreeSeats(), getNumberOfReservedSeats());
        return seatsInfo;
    }

    int getNumberOfFreeSeats() {
        return driver.findElements(freeSeatsBy).size();
    }

    int getNumberOfReservedSeats() {
        return driver.findElements(reservedSeatsBy).size();
    }
}