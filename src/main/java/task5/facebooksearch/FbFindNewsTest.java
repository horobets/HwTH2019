package task5.facebooksearch;

import org.testng.annotations.Test;

public class FbFindNewsTest extends BaseTest {

    @Test
    public void printTiketsInfo() {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);

        String TestFbUsername = "";
        String TestFbPassword = "";

        FbNewsFeedPage fbNewsFeedPage = fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);
    }
}
