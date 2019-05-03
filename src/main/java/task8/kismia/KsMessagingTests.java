package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.credentialsstorage.Credentials;
import task8.kismia.credentialsstorage.CredentialsStorage;
import task8.kismia.pages.KsLoginPage;
import task8.kismia.pages.matches.KsMatchesPage;
import task8.kismia.pages.matches.KsSuitableListPage;
import task8.kismia.pages.messages.KsMessagesThreadPage;

public class KsMessagingTests extends KsBaseTest {

    @Parameters({"username", "password", "message"})
    @Test(description = "Test kismia.com private messaging")
    public void kismiaMessagingTest(@Optional("") String username,
                                    @Optional("") String password,
                                    @Optional("Hello!") String message) {

        //use credentialsstorage if no credentials provided
        if (username.isEmpty() || password.isEmpty()) {
            Credentials ksCredentials = (new CredentialsStorage(credentialsStorageFilePath)).getLastCredentials();
            username = ksCredentials.getUsername();
            password = ksCredentials.getPassword();
        }

        KsLoginPage loginPage = new KsLoginPage(driver);
        loginPage.goToPage();

        KsMatchesPage matchesPage = loginPage.loginToKismia(username, password);
        matchesPage.goToPage();

        KsSuitableListPage suitableListPage = matchesPage.openSuitableList();
        suitableListPage.goToPage();

        KsMessagesThreadPage threadPage = suitableListPage.openChat(0);//open chat with first person
        threadPage.goToPage();

        threadPage.sendMessage(message);

        System.out.println("Done");
    }
}

