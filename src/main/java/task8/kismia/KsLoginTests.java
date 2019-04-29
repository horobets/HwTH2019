package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.pages.KsLoginPage;
import task8.kismia.pages.KsLoginPageView;
import task8.kismia.pages.fakepersongenerator.FakePerson;
import task8.kismia.pages.fakepersongenerator.FakePersonGeneratorHomePage;
import task8.kismia.pages.tempail.TempailHomePage;

public class KsLoginTests extends KsBaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com registration process screen")
    public void kismiaRegistrationTest(@Optional("teste@test.com") String username,
                                       @Optional("test123!Z") String password) {

        KsLoginPage loginPage = new KsLoginPage(driver);
        loginPage.goToPage();

        //open tempail in a new window
        String kismiaWindowHandle = driver.getWindowHandle();
        //switchToNewWindow().navigate().to("https://tempail.com");
        TempailHomePage tempailHomePage = new TempailHomePage(switchToNewWindow());
        String tempailWindowHandle = driver.getWindowHandle();

        tempailHomePage.goToPage();
        String tempEmailAddress = tempailHomePage.getEmailAddress();
        String tempPassword = getRandomPassword(10);

        //open Fakepersongenerator in a new window
        FakePersonGeneratorHomePage fakePersonGeneratorHomePage = new FakePersonGeneratorHomePage(switchToNewWindow());
        String fakePersonGeneratorWindowHandle = driver.getWindowHandle();

        fakePersonGeneratorHomePage.goToPage();
        //fakePersonGeneratorHomePage.generateNewPerson(Gender.FEMALE, 1, "Alabama", "");

        FakePerson fakePerson = fakePersonGeneratorHomePage.getFakePerson();
        //close FakePersonGenerator
        driver.close();

        //switch back to kismia window
        driver.switchTo().window(kismiaWindowHandle);

        loginPage.switchLoginPageView(KsLoginPageView.LOGIN);
        loginPage.switchLoginPageView(KsLoginPageView.REGISTRATION);
        loginPage.switchLoginPageView(KsLoginPageView.REGISTRATION);
        loginPage.switchLoginPageView(KsLoginPageView.LOGIN);
        loginPage.switchLoginPageView(KsLoginPageView.LOGIN);

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
