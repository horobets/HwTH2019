package task8.facebookapps;

import org.testng.annotations.BeforeClass;

public class FbBaseTest extends BaseTest {

    String TestFbUsername;
    String TestFbPassword;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();

        //external storage for fb credentials
        CredentialsProvider fbCredentials = new CredentialsProvider();
        TestFbUsername = fbCredentials.getFbUsername();
        TestFbPassword = fbCredentials.getFbPassword();
    }
}
