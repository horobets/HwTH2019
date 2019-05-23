package trello;

import core.BrowserFactory;
import core.credentialsstorage.Credentials;
import core.credentialsstorage.CredentialsStorage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.LoginPage;

public class LoginTest extends BrowserFactory {


    protected final String credentialsStorageFilePath = "c:\\credentials\\trellocredentials.txt";

    @Parameters({"username", "password"})
    @Test(description = "Test trello login screen")
    public void login(@Optional("") String username,
                      @Optional("") String password) {

        //use credentialsstorage if no credentials provided
        if (username.isEmpty() || password.isEmpty()) {
            Credentials ksCredentials = (new CredentialsStorage(credentialsStorageFilePath)).getLastCredentials();
            username = ksCredentials.getUsername();
            password = ksCredentials.getPassword();
        }

        LoginPage loginPage = new LoginPage();
        loginPage.goToPage();
        loginPage.login(username, password);
        Assert.assertTrue(new BoardPage().isOpened(), "Board page was not found");

    }
}
