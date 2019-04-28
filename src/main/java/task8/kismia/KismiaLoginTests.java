package task8.kismia;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KismiaLoginTests extends KismiaBaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Test kismia.com login screen")
    public void kismiaLoginTest(@Optional("teste@test.com") String username,
                                @Optional("test123!Z") String password) {

    }
}
