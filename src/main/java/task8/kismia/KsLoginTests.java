package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.pages.*;
import task8.kismia.pages.fakepersongenerator.FakePerson;
import task8.kismia.pages.fakepersongenerator.FakePersonGeneratorHomePage;
import task8.kismia.pages.tempail.TempailHomePage;
import task8.kismia.pages.tempail.TempailMessage;
import task8.kismia.pages.tempail.TempailMessagePage;

import java.util.List;

public class KsLoginTests extends KsBaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com registration process screen")
    public void kismiaRegistrationTest(@Optional("teste@test.com") String username,
                                       @Optional("test123!Z") String password) {

        KsLoginPage loginPage = new KsLoginPage(driver);
        loginPage.goToPage();

        //open tempail in a new window
        String kismiaWindowHandle = driver.getWindowHandle();
        TempailHomePage tempailHomePage = new TempailHomePage(switchToNewWindow());
        String tempailWindowHandle = driver.getWindowHandle();

        tempailHomePage.goToPage();
        String tempEmailAddress = tempailHomePage.getEmailAddress();
        String tempPassword = getRandomPassword(10);

        //open Fakepersongenerator in a new window
        FakePersonGeneratorHomePage fakePersonGeneratorHomePage = new FakePersonGeneratorHomePage(switchToNewWindow());
        String fakePersonGeneratorWindowHandle = driver.getWindowHandle();

        fakePersonGeneratorHomePage.goToPage();
        //fakePersonGeneratorHomePage.generateNewPerson(Gender.FEMALE, 25, "Alabama", "");

        FakePerson fakePerson = fakePersonGeneratorHomePage.getFakePerson();
        //close FakePersonGenerator
        driver.close();

        fakePerson.setEmail(tempEmailAddress);//use tempail e-mail address

        //switch back to kismia window
        driver.switchTo().window(kismiaWindowHandle);

        loginPage.switchLoginPageView(KsLoginPageView.REGISTRATION);

        System.out.printf("Trying to register a new kismia account with email: %s and password: %s %n", fakePerson.getEmail(), tempPassword);
        KsRegistrationFormPage registrationFormPage = loginPage.startNewAccountRegistration(fakePerson.getGender(), Gender.FEMALE, fakePerson.getFirstName(), fakePerson.getEmail(), tempPassword);
        registrationFormPage.goToPage();

        registrationFormPage.selectBirthday(fakePerson.getBirthday());

        KsRegistrationUploadPhotoPage ksRegistrationUploadPhotoPage = registrationFormPage.submitRegistrationForm();
        ksRegistrationUploadPhotoPage.skipUploadPhoto();

        //switch to tempail window
        driver.switchTo().window(tempailWindowHandle);

        //check new mail
        tempailHomePage.refreshMessageList();

        List<TempailMessage> emails = tempailHomePage.getReceivedMessages();

        TempailMessagePage activationMessagePage = tempailHomePage.openTempailMessage(emails.get(0));//open last message

        String activationMessageContent = activationMessagePage.getMessageContent();
        String activationLink = getActivationLinkFromEmail(activationMessageContent);


        activationMessagePage.goToPage();
    }

    public String getActivationLinkFromEmail(String emailContent) {
        //getMessageContent()
        return null;
    }

    public static String getRandomPassword(int length) {
        final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int) (Math.random() * CHARSET.length());
            builder.append(CHARSET.charAt(character));
        }
        return builder.toString();
    }


    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com login screen")
    public void kismiaLoginTest(@Optional("teste@test.com") String username,
                                @Optional("test123!Z") String password) {

    }
}
