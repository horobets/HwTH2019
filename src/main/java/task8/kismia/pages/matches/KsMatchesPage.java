package task8.kismia.pages.matches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.profile.KsAccountBasePage;

public class KsMatchesPage extends KsAccountBasePage {

    private By matchesHeaderBy = By.cssSelector(".js_matchesUserHead");

    public KsMatchesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        isElementPresent(matchesHeaderBy, 5);
    }
}
