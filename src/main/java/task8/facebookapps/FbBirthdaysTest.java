package task8.facebookapps;

import org.testng.annotations.Test;
import task8.facebookapps.pages.FbBirthdaysPage;
import task8.facebookapps.pages.FbLoginPage;
import task8.facebookapps.pages.FbProfilePage;

public class FbBirthdaysTest extends FbBaseTest {

    @Test(description = "Send message to friends having birthday today")
    public void facebookSendMessagesToFriendsHavingBirthdayTest() {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.goToPage();

        fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);

        FbBirthdaysPage fbBirthdaysPage = new FbBirthdaysPage(driver);
        fbBirthdaysPage.goToPage();

        for (String birthdayProfileLink : fbBirthdaysPage.getTodayBirthdayProfiles()) {

            FbProfilePage profilePage = new FbProfilePage(driver, birthdayProfileLink);
            profilePage.goToPage();

            profilePage.sendPersonalMessage(String.format("Congrats, %s", profilePage.getProfileFullname()));
        }
    }


    @Test(description = "List links to profiles having birthday today")
    public void facebookTodayBirthdaysListTest() {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.goToPage();

        fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);

        FbBirthdaysPage fbBirthdaysPage = new FbBirthdaysPage(driver);
        fbBirthdaysPage.goToPage();

        for (String birthdayProfileLink : fbBirthdaysPage.getTodayBirthdayProfiles())
            System.out.println(birthdayProfileLink);
    }
}
