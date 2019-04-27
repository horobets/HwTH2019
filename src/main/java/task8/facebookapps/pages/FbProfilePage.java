package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FbProfilePage extends FbBasePage {

    private String profileLink;

    private By profileNameBy = By.cssSelector("#fb-timeline-cover-name >a");

    private By messageButtonBy = By.id("u_0_1f");

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

    public void sendPersonalMessage(String messageText) {
        driver.findElement(messageButtonBy).click();

        WebElement messageEditor = driver.findElement(By.id("cch_f3ce01ba31d4aec"));
        messageEditor.sendKeys(messageText);

        //WebElement sendMessageButton = driver.findElement(By.id("js_426"));
    }

}
