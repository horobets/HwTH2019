package task8.kismia.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.KsBasePage;

public class KsRegistrationUploadPhotoPage extends KsBasePage {

    private By uploadPhotoButtonBy = By.id("btn_add_photo");
    private By skipLinkBy = By.cssSelector(".js-skip-upload-photo-step");

    public KsRegistrationUploadPhotoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        isElementVisible(uploadPhotoButtonBy, 5);
    }

    public void skipUploadPhoto() {
        click(skipLinkBy);
    }
}
