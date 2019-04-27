package task8.facebookapps;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.facebookapps.pages.FbLoginPage;
import task8.facebookapps.pages.FbNewsFeedPage;

import java.util.List;

public class FbFindNewsTest extends FbBaseTest {

    @Parameters({"firstStringToCount", "secondStringToCount", "maxNewsToRead"})
    @Test(description = "Compare occurrences of two strings in Facebook news feed")
    public void facebookCompareOccurrencesInNewsTest(@Optional("ze") String firstStringToCount, @Optional("roshen") String secondStringToCount, @Optional("50") int maxNewsToRead) {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.goToPage();

        FbNewsFeedPage fbNewsFeedPage = fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);

        fbNewsFeedPage.goToPage();

        List<String> fbNewsFeedMessages = fbNewsFeedPage.getFbNewsFeedMessages(maxNewsToRead);

        int firstStringCount = getStringOccurrencesInTextsListCount(fbNewsFeedMessages, firstStringToCount);
        int secondStringCount = getStringOccurrencesInTextsListCount(fbNewsFeedMessages, secondStringToCount);

        System.out.printf("String %s was found %d times;\nString %s was found %d times.",
                firstStringToCount, firstStringCount, secondStringToCount, secondStringCount);
    }

    private int getStringOccurrencesInTextsListCount(List<String> texts, String stringToFind) {
        int occurrencesCount = 0;
        for (String text : texts) {
            if (text.contains(stringToFind))
                occurrencesCount++;
        }
        return occurrencesCount;
    }

    @Parameters({"maxNewsToRead"})
    @Test(description = "Read and print news feed from facebook")
    public void facebookReadNewsFeedTest(@Optional("50") int maxNewsToRead) {

        FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.goToPage();

        FbNewsFeedPage fbNewsFeedPage = fbLoginPage.loginToFacebook(TestFbUsername, TestFbPassword);

        fbNewsFeedPage.goToPage();

        for (String visibleMessage : fbNewsFeedPage.getFbNewsFeedMessages(20))
            System.out.printf("%s %n%n", visibleMessage);
    }
}
