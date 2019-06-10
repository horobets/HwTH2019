package trello;

import core.credentialsstorage.Credentials;
import core.credentialsstorage.CredentialsStorage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.BoardsPage;
import trello.pages.LoggedOutPage;
import trello.pages.LoginPage;

public class LoginTests extends TrelloBaseTest {


    protected final String credentialsStorageFilePath = "c:\\credentials\\trellocredentials.txt";

    @Parameters({"username", "password"})
    @Test(description = "Test trello login screen", priority = 1/*, dataProvider = "TestDataProvider"-*/)
    public void login(@Optional("") String username,
                      @Optional("") String password) {

        //use credentialsstorage if no credentials provided
        if (username.isEmpty() || password.isEmpty()) {
            Credentials trelloCredentials = (new CredentialsStorage(credentialsStorageFilePath)).getLastCredentials();
            username = trelloCredentials.getUsername();
            password = trelloCredentials.getPassword();
        }

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.goToPage();
        loginPage.login(username, password);
        Assert.assertTrue(new BoardsPage(getDriver()).isOpened(), "Board page was not found");

    }


    @Test(description = "Test trello logout screen", dependsOnMethods = "login", priority = 9)
    public void logout() {

        BoardsPage boardsPage = new BoardsPage(getDriver());

        boardsPage.logOut();

        Assert.assertTrue(new LoggedOutPage(getDriver()).isOpened(), "Logged Out page was not found");


    }
}
