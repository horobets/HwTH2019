package task8.kismia.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KsProfileSettingsSearchPage extends KsProfileSettingsBasePage {

    private By profileTabBy = By.cssSelector("//div[@class='settings-nav__elem js_settingsNav active' and @data-tab='profileSearch']");


    public KsProfileSettingsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        isElementPresent(profileTabBy, 5);
    }


}
