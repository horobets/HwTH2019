package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbEventsPage extends FbBasePage {

    By eventsDashboardTitleBy = By.id("events_dashboard_upcoming_events");


    public FbEventsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        driver.navigate().to("https://www.facebook.com/events/");

        isPageLoaded(eventsDashboardTitleBy);
    }
}
