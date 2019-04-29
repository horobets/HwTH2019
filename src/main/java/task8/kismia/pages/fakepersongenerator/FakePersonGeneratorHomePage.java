package task8.kismia.pages.fakepersongenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import task8.kismia.pages.Gender;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public Date getBirthday() {
        String birthdayStr = readText(birthdayBy);
        Date birthday = null;
        try {
            //DateFormat birthdayStrFormat = new SimpleDateFormat("dd MMMM yyyy '(USA)'", Locale.US);
            DateFormat birthdayStrFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
            birthday = birthdayStrFormat.parse(birthdayStr);
        } catch (ParseException ex) {
            System.out.printf("Error: Invalid birthday datetime format: %s\n", birthdayStr);
        }
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

    public void generateNewPerson(Gender gender, int age, String state, String City) {
        //preferred gender
        Select genderDropdown = new Select(driver.findElement(generateGenderDropdownBy));
        try {
            genderDropdown.selectByVisibleText(gender.toString());
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", gender.toString());
        }

        //preferred age
        Select ageDropdown = new Select(driver.findElement(generateAgeDropdownBy));
        try {
            ageDropdown.selectByVisibleText(Integer.toString(age));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", gender.toString());
        }

        //preferred State
        Select stateDropdown = new Select(driver.findElement(generateStateDropdownBy));
        try {
            stateDropdown.selectByVisibleText(state);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", state);
        }

        //preferred City
        writeText(generateCityTextboxBy, City);

        generateNewPerson();
    }

    public void generateNewPerson() {
        click(generateButtonBy);
        isElementVisible(nameLabelBy, 5);//wait for page to reload
    }
}
