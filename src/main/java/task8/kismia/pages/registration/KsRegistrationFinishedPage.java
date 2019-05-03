package task8.kismia.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.KsBasePage;

public class KsRegistrationFinishedPage extends KsBasePage {

    private By emailInputBy = By.id("mail_input");
    private By sendAgainLinkBy = By.cssSelector(".sendAgainLink");

    public KsRegistrationFinishedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        isElementVisible(emailInputBy, 5);
    }

    public void clickResendEmail() {
        click(sendAgainLinkBy);
    }
}
