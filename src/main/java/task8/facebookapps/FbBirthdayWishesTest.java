package task8.facebookapps;

import org.testng.annotations.Test;
import task8.facebookapps.pages.FbBirthdaysPage;
import task8.facebookapps.pages.FbLoginPage;
import task8.facebookapps.pages.FbMessengerPage;
import task8.facebookapps.pages.FbProfilePage;

public class FbBirthdayWishesTest extends FbBaseTest {

    @Test(description = "Send message to friends having birthday today")
    public void facebookSendBirthdayWishesTest() {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.goToPage();

        fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);

        FbBirthdaysPage fbBirthdaysPage = new FbBirthdaysPage(driver);
        fbBirthdaysPage.goToPage();

        for (String birthdayProfileLink : fbBirthdaysPage.getTodayBirthdayProfiles()) {

            FbProfilePage profilePage = new FbProfilePage(driver, birthdayProfileLink);
            profilePage.goToPage();

            String randomWish = BirthdayWishes.getRandomWish();

            String message = String.format("Congrats, %s!\n%s", profilePage.getProfileFullname(), randomWish);

            sentPersonalMessage(birthdayProfileLink, message);
        }
    }

    private void sentPersonalMessage(String profileLink, String message) {
        FbProfilePage profilePage = new FbProfilePage(driver, profileLink);
        profilePage.goToPage();
        FbMessengerPage profileMessengerPage = profilePage.gotoMessenger();
        profileMessengerPage.sendMessage(message);
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
