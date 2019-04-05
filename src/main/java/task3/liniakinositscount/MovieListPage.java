package task3.liniakinositscount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieListPage extends BasePage {
    public MovieListPage(WebDriver driver) {
        super(driver);
    }

        By showTimeBy = By.xpath("(//li[h1/a[@href='/movies/?id=7531']]//li[@class='showtime-item']/a)[1]");

    public void goToPage() {
        driver.get("http://liniakino.com/showtimes/aladdin/");
    }

    public TiketsOrderPopup openOrderPage()
    {
        click(showTimeBy);
        TiketsOrderPopup orderPopup = new TiketsOrderPopup(driver);
        orderPopup.switchToFrame();

        orderPopup.closeGlassesWarningPopup();
        return orderPopup;
    }
}