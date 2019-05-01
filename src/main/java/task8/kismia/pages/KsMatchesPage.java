package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
