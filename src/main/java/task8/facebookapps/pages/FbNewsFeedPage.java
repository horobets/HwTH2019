package task8.facebookapps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FbNewsFeedPage extends FbBasePage {
    public FbNewsFeedPage(WebDriver driver) {
        super(driver);
    }

    //private By hyperFeedItemsUserContentBy = By.cssSelector("div[id^='hyperfeed_story_id'] .userContent > div > p");
    private By hyperFeedItemsUserContentBy = By.cssSelector("div[id^='hyperfeed_story_id'] .userContent");

    public void goToPage() {
        driver.navigate().to("https://www.facebook.com/?sk=nf");

        isPageLoaded(hyperFeedItemsUserContentBy);
    }

    public List<String> getFbNewsFeedMessages(int max) {
        List<String> newsFeedMessages = new ArrayList<>();

        for (int i = 0; i < max; i++) {

            List<WebElement> userContentElements = driver.findElements(hyperFeedItemsUserContentBy);
            if (i < userContentElements.size()) {

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView();", userContentElements.get(i));

                newsFeedMessages.add(userContentElements.get(i).getText());
            } else {
                break;
            }
        }

        return newsFeedMessages;
    }

    public List<String> getFbMessagesFromVisibleElements() {
        List<String> messages = new ArrayList<>();

        for (WebElement visibleUserContentFeedElement : driver.findElements(hyperFeedItemsUserContentBy))
            messages.add(visibleUserContentFeedElement.getText());

        return messages;
    }
}