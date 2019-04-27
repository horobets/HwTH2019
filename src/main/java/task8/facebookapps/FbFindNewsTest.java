package task8.facebookapps;

import task8.facebookapps.pages.FbLoginPage;
import task8.facebookapps.pages.FbNewsFeedPage;

public class FbFindNewsTest extends FbBaseTest {

    FbLoginPage fbLoginPage = new FbLoginPage(driver);

    String TestFbUsername = "";
    String TestFbPassword = "";

    FbNewsFeedPage fbNewsFeedPage = fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);
}
