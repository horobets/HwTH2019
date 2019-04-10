package task5.facebooksearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FbLoginPage extends BasePage {
    public FbLoginPage(WebDriver driver) {
        super(driver);
    }

    private By fbUsername = By.cssSelector("#email");
    private By fbPassword = By.cssSelector("#pass");

    public void goToPage() {
        driver.navigate().to("https://www.facebook.com");

        isPageLoaded(fbUsername);
    }


    public FbNewsFeedPage loginToFacebook(String username, String password) {

        driver.findElement(fbUsername).clear();
        driver.findElement(fbUsername).sendKeys(username);

        driver.findElement(fbPassword).clear();
        driver.findElement(fbPassword).sendKeys(password);

        driver.findElement(fbPassword).sendKeys(Keys.ENTER);

        return new FbNewsFeedPage(driver);
    }
}
