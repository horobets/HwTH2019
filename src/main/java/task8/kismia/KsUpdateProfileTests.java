package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.credentialsstorage.Credentials;
import task8.kismia.credentialsstorage.CredentialsStorage;
import task8.kismia.pages.*;

import java.time.LocalDate;

public class KsUpdateProfileTests extends KsBaseTest {
    @Parameters({"username", "password"})
    @Test(description = "Test updating personal information on kismia.com")
    public void kismiaUpdateProfileTest(@Optional("") String username,
                                        @Optional("") String password) {

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

        KsProfileSettingsSearchPage profileSettingsSearchPage = matchesPage.openEditProfile();
        profileSettingsSearchPage.goToPage();

        KsProfileSettingsPersonalPage profileSettingsPersonalPage = profileSettingsSearchPage.openTab(ProfileSettingsTab.PERSONAL);
        profileSettingsPersonalPage.goToPage();

        LocalDate newBirthdate = LocalDate.of(1984, 3, 2);
        Gender newGender = Gender.FEMALE;
        profileSettingsPersonalPage.selectBirthday(newBirthdate);
        profileSettingsPersonalPage.setGender(newGender);

        profileSettingsPersonalPage.clickSave();

        System.out.println("Done");
    }
}