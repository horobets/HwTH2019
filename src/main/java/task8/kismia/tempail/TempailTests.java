package task8.kismia.tempail;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.pages.tempail.TempailHomePage;
import task8.kismia.pages.tempail.TempailMessage;
import task8.kismia.pages.tempail.TempailMessagePage;

public class TempailTests extends TempailBaseTest {
    @Parameters({"expectedMessageSender", "expectedMessageSubject", "waitSeconds"})
    @Test(description = "Wait and Find a message")
    public void tempailFindMessageTest(@Optional("r.team") String expectedMessageSender,
                                       @Optional("test") String expectedMessageSubject,
                                       @Optional("45") int waitSeconds) {

        TempailHomePage tempailHomePage = new TempailHomePage(driver);

        tempailHomePage.goToPage();

        TempailMessage tempailMessage = tempailHomePage.waitForMessage(expectedMessageSender, expectedMessageSubject, waitSeconds);

        Assert.assertNotNull(tempailMessage);

        //open message in a new window
        String tempailListWindowHandle = driver.getWindowHandle();

        TempailMessagePage messagePage = new TempailMessagePage(switchToNewWindow(), tempailMessage);
        messagePage.goToPage();
        String messageWindowHandle = driver.getWindowHandle();

        String messageContent = messagePage.getMessageContent();

        System.out.println("Done");

    }
}
