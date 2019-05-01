package task8.kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KsProfilePage extends KsBasePage {

    private By tutorialPopupBy = By.id("tutorial-template-step-1");
    private By tutorialCloseLinkBy = By.cssSelector(".js-close");

    private By editProfileLinkBy = By.cssSelector(".js-edit-profile");

    public KsProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        waitAndCloseTutorialPopup();
    }

    public void waitAndCloseTutorialPopup() {
        //wait for popup to appear and close it
        if (isElementPresent(tutorialPopupBy, 15))
            click(tutorialCloseLinkBy);
    }
}
