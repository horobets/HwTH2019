package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.credentialsstorage.Credentials;
import task8.kismia.credentialsstorage.CredentialsStorage;
import task8.kismia.pages.KsLoginPage;
import task8.kismia.pages.KsLoginPageView;
import task8.kismia.pages.matches.KsMatchesPage;

public class KsLoginTests extends KsBaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com login screen")
    public void kismiaLoginTest(@Optional("") String username,
                                @Optional("") String password) {

        //use credentialsstorage if no credentials provided
        if (username.isEmpty() || password.isEmpty()) {
            Credentials ksCredentials = (new CredentialsStorage(credentialsStorageFilePath)).getLastCredentials();
            username = ksCredentials.getUsername();
            password = ksCredentials.getPassword();
        }

        KsLoginPage loginPage = new KsLoginPage(driver);
        loginPage.goToPage();

        //make sure we are on the Login page view
        loginPage.switchLoginPageView(KsLoginPageView.LOGIN);

        KsMatchesPage matchesPage = loginPage.loginToKismia(username, password);
        matchesPage.goToPage();


        System.out.println("Done");
    }
}

