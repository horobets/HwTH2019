package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class KsAccountBasePage extends KsBasePage {

    private By profileLinkBy = By.cssSelector(".new-header-sub-menu__elem");
    private By messagesLinkBy = By.cssSelector(".new-header-main-nav__link--messages");

    public KsAccountBasePage(WebDriver driver) {
        super(driver);

        isElementPresent(profileLinkBy, 5);
    }

    public KsMessagesPage openMessages() {
        click(messagesLinkBy);
        return new KsMessagesPage(driver);
    }


    public KsProfilePage openProfile() {
        click(profileLinkBy);
        return new KsProfilePage(driver);
    }
}
