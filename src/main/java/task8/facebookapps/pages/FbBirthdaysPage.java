package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FbBirthdaysPage extends FbEventsPage {

    By upcomingBirthdaysCardBy = By.id("birthdays_upcoming_card");

    By birthdaysBlocksBy = By.cssSelector("._tzh ul");

    public FbBirthdaysPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        driver.navigate().to("https://www.facebook.com/events/birthdays/");

        isPageLoaded(upcomingBirthdaysCardBy);

    }

    public List<String> getTodayBirthdayProfiles() {
        List<String> todayBirthdaysProfiles = new ArrayList<>();

        WebElement todayBirthdaysBlock = driver.findElements(birthdaysBlocksBy).get(0);//get first block for today birthdays

        for (WebElement todayBirthdaysProfileElement : todayBirthdaysBlock.findElements(By.cssSelector("li a"))) {
            todayBirthdaysProfiles.add(todayBirthdaysProfileElement.getAttribute("href"));//get links to profiles
        }

        return todayBirthdaysProfiles;
    }
}
