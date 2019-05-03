package task8.kismia.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.KsBasePage;
import task8.kismia.pages.matches.KsSuitableListPage;
import task8.kismia.pages.messages.KsMessagesListPage;

public abstract class KsAccountBasePage extends KsBasePage {

    private By profileMenuBy = By.cssSelector(".js_headerSubMenu");

    private By profileLinkBy = By.cssSelector(".new-header-sub-menu__elem");
    private By messagesLinkBy = By.cssSelector(".new-header-main-nav__link--messages");

    private By suitableMenuitemBy = By.cssSelector(".right-side-menu__link--suitable");

    public KsAccountBasePage(WebDriver driver) {
        super(driver);

        isElementPresent(profileLinkBy, 5);
    }

    public KsMessagesListPage openMessages() {
        click(messagesLinkBy);
        return new KsMessagesListPage(driver);
    }

    public KsProfilePage openProfile() {
        click(profileLinkBy);
        return new KsProfilePage(driver);
    }

    public KsSuitableListPage openSuitableList() {
        click(suitableMenuitemBy);
        return new KsSuitableListPage(driver);
    }


    public KsProfilePage openProfileSettings() {
        click(profileLinkBy);
        return new KsProfilePage(driver);
    }


    public KsProfileSettingsSearchPage openEditProfile() {

        click(profileMenuBy);
        By profileLinkMenuitem = By.xpath("//a[contains(@href, '/profile/settings')]");
        click(profileLinkMenuitem);

        return new KsProfileSettingsSearchPage(driver);
    }
}
