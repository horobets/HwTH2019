package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbProfilePage extends FbBasePage {

    private String profileLink;

    private By profileNameBy = By.cssSelector("#fb-timeline-cover-name >a");

    private By messageButtonBy = By.cssSelector(".actions a[href^='/messages/t/']");

    public FbProfilePage(WebDriver driver, String profileLink) {
        super(driver);

        this.profileLink = "https://www.facebook.com/profile.php?id=100007696062119";// profileLink;
    }

    @Override
    public void goToPage() {


        driver.navigate().to(profileLink);

        isPageLoaded(profileNameBy);
    }

    public String getProfileFullname() {
        return driver.findElement(profileNameBy).getText();
    }

    public FbMessengerPage gotoMessenger() {
        String profileMessengerPageLink = driver.findElement(messageButtonBy).getAttribute("href");

        FbMessengerPage profileMessengerPage = new FbMessengerPage(driver, profileMessengerPageLink);
        profileMessengerPage.goToPage();

        return profileMessengerPage;
    }

}