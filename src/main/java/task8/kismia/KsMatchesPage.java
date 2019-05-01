package task8.kismia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.KsBasePage;

public class KsMatchesPage extends KsBasePage {

    private By matchesHeaderBy = By.cssSelector(".js_matchesUserHead");
    private By profileLinkBy = By.cssSelector(".new-header-sub-menu__elem");
    private By messagesLinkBy = By.cssSelector(".new-header-main-nav__link--messages");

    public KsMatchesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        isElementPresent(matchesHeaderBy, 5);
    }
}
