package task8.kismia;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.credentialsstorage.Credentials;
import task8.kismia.credentialsstorage.CredentialsStorage;
import task8.kismia.fakepersongenerator.FakepersongeneratorTests;
import task8.kismia.pages.KsLoginPage;
import task8.kismia.pages.KsLoginPageView;
import task8.kismia.pages.fakepersongenerator.FakePerson;
import task8.kismia.pages.profile.Gender;
import task8.kismia.pages.profile.KsProfilePage;
import task8.kismia.pages.registration.KsRegistrationFormPage;
import task8.kismia.pages.registration.KsRegistrationUploadPhotoPage;
import task8.kismia.pages.tempail.TempailHomePage;
import task8.kismia.pages.tempail.TempailMessage;
import task8.kismia.pages.tempail.TempailMessagePage;

import static task8.kismia.RegexMatches.getRegexMatches;

public class KsRegistrationTests extends KsBaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com registration process screen")
    public void kismiaRegistrationTest(@Optional("teste@test.com") String username,
                                       @Optional("test123!Z") String password) {

        KsLoginPage loginPage = new KsLoginPage(driver);
        loginPage.goToPage();

        //remember kismia browser window handle
        String kismiaWindowHandle = driver.getWindowHandle();

        //generate fake person in a new browser window and close it
        FakePerson fakePerson = FakepersongeneratorTests.generateFakePerson(switchToNewWindow());
        driver.close();

        //switch back to kismia window
        driver.switchTo().window(kismiaWindowHandle);

        //open tempail in a new window
        TempailHomePage tempailHomePage = new TempailHomePage(switchToNewWindow());
        String tempailWindowHandle = driver.getWindowHandle();

        tempailHomePage.goToPage();
        String tempEmailAddress = tempailHomePage.getEmailAddress();
        String tempPassword = getRandomPassword(10);

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

        //write new account credentials to local storage for future use
        if ((new CredentialsStorage(credentialsStorageFilePath)).saveCredentials(new Credentials(fakePerson.getEmail(), tempPassword)))
            System.out.printf("Credentials saved to local storage.");

        //switch to tempail window
        driver.switchTo().window(tempailWindowHandle);

        //wait for kismia activation email
        TempailMessage activationMessage = tempailHomePage.waitForMessage("donotreply@mailfier.com", "Your story of unforgettable meetings begins now", 180);
        Assert.assertNotNull(activationMessage, "Activation Email was not found in the mailbox");

        //open message
        TempailMessagePage activationMessagePage = new TempailMessagePage(driver, activationMessage);
        activationMessagePage.goToPage();
        String activationMessageContent = activationMessagePage.getMessageContent();

        String activationLink = getActivationLinkFromEmail(activationMessageContent);

        //close tempail window - no longer needed
        driver.close();

        //switch back to kismia window
        driver.switchTo().window(kismiaWindowHandle);

        //open activation link to confirm e-mail address
        driver.navigate().to(activationLink);

        KsProfilePage profilePage = new KsProfilePage(driver);
        profilePage.goToPage();


        System.out.println("Done");
    }

    public String getActivationLinkFromEmail(String emailContent) {

        String activationLinkRegex = "http:\\/\\/n\\.kismia\\.com\\/link\\/\\?p=1.+s=0";

        String activationLink = getRegexMatches(emailContent, activationLinkRegex).get(2);//get third link match for activation
        activationLink = activationLink.replaceAll("&amp;", "&");

        return activationLink;
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

}