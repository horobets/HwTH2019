package task8.kismia.fakepersongenerator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.kismia.pages.Gender;
import task8.kismia.pages.fakepersongenerator.FakePerson;
import task8.kismia.pages.fakepersongenerator.FakePersonGeneratorHomePage;

import java.time.LocalDate;
import java.time.Period;

public class FakepersongeneratorTests extends FakepersongeneratorBaseTest {
    @Parameters({"prefererredGender", "preferredAge", "preferredState", "preferredCity"})
    @Test(description = "Generate Fake Person")
    public void FakepersongeneratorCreatePersonTest(@Optional("FEMALE") Gender prefererredGender,
                                                    @Optional("25") int preferredAge,
                                                    @Optional("Alabama") String preferredState,
                                                    @Optional("") String preferredCity) {

        /*FakePersonGeneratorHomePage fakePersonGeneratorHomePage = new FakePersonGeneratorHomePage(driver);
        fakePersonGeneratorHomePage.goToPage();
        FakePerson fakePerson = fakePersonGeneratorHomePage.generateNewPerson(prefererredGender, preferredAge, preferredState, preferredCity);
        */
        FakePerson fakePerson = generateFakePerson(driver, prefererredGender, preferredAge, preferredState, preferredCity);

        Assert.assertNotNull(fakePerson);

        Period agePeriod = Period.between(fakePerson.getBirthday(), LocalDate.now());
        Assert.assertTrue(agePeriod.getYears() >= preferredAge - 1 && agePeriod.getYears() <= preferredAge + 1);//check age in range +-1yr

        Assert.assertTrue(fakePerson.getState().contains(preferredState));//check state

        System.out.println(fakePerson);

        System.out.println("Done");

    }

    public static FakePerson generateFakePerson(WebDriver driver, Gender prefererredGender, int preferredAge, String preferredState, String preferredCity) {
        return openFakepersongeneratorHomePage(driver).generateNewPerson(prefererredGender, preferredAge, preferredState, preferredCity);
    }

    public static FakePerson generateFakePerson(WebDriver driver) {
        return openFakepersongeneratorHomePage(driver).generateNewPerson();
    }

    public static FakePersonGeneratorHomePage openFakepersongeneratorHomePage(WebDriver driver) {
        FakePersonGeneratorHomePage fakePersonGeneratorHomePage = new FakePersonGeneratorHomePage(driver);
        fakePersonGeneratorHomePage.goToPage();
        return fakePersonGeneratorHomePage;
    }
}
