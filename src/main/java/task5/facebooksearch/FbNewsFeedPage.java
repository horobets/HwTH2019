package task5.facebooksearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbNewsFeedPage extends BasePage {
    public FbNewsFeedPage(WebDriver driver) {
        super(driver);
    }

    private By fbUsername = By.cssSelector("#email");

    public void goToPage() {
        driver.navigate().to("https://www.facebook.com/?sk=nf");

        isPageLoaded(fbUsername);
    }

    public int getPhraseOccurancesNumber(String phraseToSearch)
    {
return 0;
    }
}
