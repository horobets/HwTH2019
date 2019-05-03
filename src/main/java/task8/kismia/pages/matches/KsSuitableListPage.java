package task8.kismia.pages.matches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.messages.KsMessagesThreadPage;
import task8.kismia.pages.profile.KsAccountBasePage;

public class KsSuitableListPage extends KsAccountBasePage {

    String suitableListItemMenuXpath = "//*[contains(@class,'js_moreOptionsTrigger')]";


    public KsSuitableListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {


        isElementPresent(By.xpath(suitableListItemMenuXpath), 5);
    }

    //open chat thread with person by index
    public KsMessagesThreadPage openChat(int index) {
        By personToOpenChatWith = By.xpath(String.format("%s[%d]", suitableListItemMenuXpath, index + 1));
        click(personToOpenChatWith);//open menu

        By openChatMenuItem = By.cssSelector(".icon--action-option-message");
        click(openChatMenuItem);

        return new KsMessagesThreadPage(driver);
    }
}
