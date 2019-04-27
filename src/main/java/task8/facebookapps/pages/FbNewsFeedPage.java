package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbNewsFeedPage extends FbBasePage {
    public FbNewsFeedPage(WebDriver driver) {
        super(driver);
    }

    private By fbUsername = By.cssSelector("#email");
    //private By hyperFeedItemsBy = By.xpath("//div[contains(@id, 'hyperfeed_story')]");
    private By hyperFeedItemsBy = By.cssSelector("div[id^='hyperfeed_story_id']");
    private By hyperFeedItemsUserContentBy = By.cssSelector("div[id^='hyperfeed_story_id'] .userContent > div > p");

    public void goToPage() {
        driver.navigate().to("https://www.facebook.com/?sk=nf");

        isPageLoaded(fbUsername);
    }

    public int getPhraseOccurancesNumber(String phraseToSearch)
    {
        return 0;
    }
}
