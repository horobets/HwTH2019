package task8.kismia.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class KsProfileSettingsBasePage extends KsAccountBasePage {

    private By profileTabSearchParameters = By.cssSelector(".js_settingsNav[data-tab='profileSearch']");
    private By profileTabPersonalInformation = By.cssSelector(".js_settingsNav[data-tab='profile']");

    private By saveButtonBy = By.cssSelector(".js_save");

    private String tabMenuItemCssFormat = ".js_settingsNav[data-tab='%s']";

    public KsProfileSettingsBasePage(WebDriver driver) {
        super(driver);
    }

    public <T extends KsProfileSettingsBasePage> T openTab(ProfileSettingsTab tab) {
        By objectTabBy = By.cssSelector(String.format(tabMenuItemCssFormat, tab.getTabId()));
        isElementVisible(objectTabBy, 5);

        click(objectTabBy);

        KsProfileSettingsBasePage profileSettingsBasePage = null;
        switch (tab) {
            case SEARCH: {
                profileSettingsBasePage = new KsProfileSettingsSearchPage(driver);
                break;
            }
            case PERSONAL: {
                profileSettingsBasePage = new KsProfileSettingsPersonalPage(driver);
                break;
            }
            // TODO for extra classes
        }
        profileSettingsBasePage.goToPage();

        return (T) profileSettingsBasePage;
    }

    public void clickSave() {
        click(saveButtonBy);
    }
}
