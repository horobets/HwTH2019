package task8.kismia.pages.fakepersongenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import task8.kismia.pages.profile.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakePersonGeneratorHomePage extends FakePersonGeneratorBasePage {

    private By nameLabelBy = By.cssSelector(".text-center.name");

    private By genderBy = By.xpath("//p[text()='Gender: ']/b[1]");
    private By birthdayBy = By.xpath("//p[text()='Birthday: ']/b[1]");
    private By telephoneBy = By.xpath("//p[text()='Telephone: ']/b[1]");
    private By emailBy = By.xpath("//div[span[text()='Email']]/following-sibling::div[1]/input");
    private By streetBy = By.xpath("//p[text()='Street: ']/b[1]");
    private By cityStateZipBy = By.xpath("//p[text()='City, State, Zip: ']/b[1]");
    private By countryBy = By.xpath("//div[span[text()='Country']]/following-sibling::div[1]/input");
    private By sSNBy = By.xpath("//div[span[text()='Social Security Number']]/following-sibling::div[1]/input");

    private By generateButtonBy = By.id("generate");
    private By generateGenderDropdownBy = By.cssSelector("[name='gender']");
    private By generateAgeDropdownBy = By.cssSelector("[name='age']");
    private By generateStateDropdownBy = By.cssSelector("[name='state']");
    private By generateCityTextboxBy = By.cssSelector("[name='city']");


    public FakePersonGeneratorHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        driver.navigate().to("https://www.fakepersongenerator.com/");

        isPageLoaded(nameLabelBy);
    }

    public FakePerson getFakePerson() {
        FakePerson fakePerson = new FakePerson();

        fakePerson.setFirstName(getFirstName());
        fakePerson.setLastName(getLastName());
        fakePerson.setGender(getGender());
        fakePerson.setBirthday(getBirthday());
        fakePerson.setPhone(getPhone());
        fakePerson.setEmail(getEmail());
        fakePerson.setStreet(getStreet());
        fakePerson.setCity(getCity());
        fakePerson.setState(getState());
        fakePerson.setZip(getZip());
        fakePerson.setCountry(getCountry());
        fakePerson.setSSN(getSSN());

        return fakePerson;
    }

    public String getFirstName() {
        return getFullNameStrs()[0].trim();
    }

    public String getLastName() {
        return getFullNameStrs()[2].trim();
    }

    private String[] getFullNameStrs() {
        String fullName = readText(nameLabelBy);
        return fullName.split(" ");
    }

    public Gender getGender() {
        String genderStr = readText(genderBy);
        //capitalize the first letter of a String ('Male is displayed as 'male' on the page)
        genderStr = genderStr.substring(0, 1).toUpperCase() + genderStr.substring(1);
        return Gender.get(genderStr);
    }

    public LocalDate getBirthday() {
        String birthdayStr = readText(birthdayBy);
        LocalDate birthday = null;

        //https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        birthday = LocalDate.parse(birthdayStr, formatter);

        return birthday;
    }

    public String getPhone() {
        return readText(telephoneBy);
    }

    public String getEmail() {
        return driver.findElement(emailBy).getAttribute("value");
    }

    public String getStreet() {
        return readText(streetBy);
    }

    public String getCity() {
        return getCityStateZipStrs()[0].trim();
    }

    public String getState() {
        return getCityStateZipStrs()[1].trim();
    }

    public String getZip() {
        return getCityStateZipStrs()[2].trim();
    }

    private String[] getCityStateZipStrs() {
        return readText(cityStateZipBy).split(", ");
    }

    public String getCountry() {
        return driver.findElement(countryBy).getAttribute("value");
    }

    public String getSSN() {

        return driver.findElement(sSNBy).getAttribute("value");
    }

    public FakePerson generateNewPerson(Gender gender, int age, String state, String City) {

        //preferred gender
        try {
            selectItem(generateGenderDropdownBy, gender.toString());
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", gender.toString());
        }

        //preferred age
        try {
            selectItem(generateAgeDropdownBy, Integer.toString(age));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", Integer.toString(age));
        }

        //preferred state
        try {
            selectItem(generateStateDropdownBy, state);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", state);
        }

        //preferred City
        writeText(generateCityTextboxBy, City);

        return generateNewPerson();
    }

    public FakePerson generateNewPerson() {
        click(generateButtonBy);
        isElementVisible(nameLabelBy, 5);//wait for page to reload

        return getFakePerson();
    }
}
