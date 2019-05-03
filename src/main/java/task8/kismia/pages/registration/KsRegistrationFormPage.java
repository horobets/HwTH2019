package task8.kismia.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import task8.kismia.pages.KsBasePage;

import java.time.LocalDate;
import java.util.List;

public class KsRegistrationFormPage extends KsBasePage {

    private By englishUIButton = By.cssSelector("[href='https://en.kismia.com/sign/application?change_language=1']");

    private By countryDropdownBy = By.id("country_id");
    private By cityBy = By.id("city_name");
    private By birthdayDayDropdownBy = By.id("bday_day");
    private By birthdayMonthDropdownBy = By.id("bday_month");
    private By birthdayYearDropdownBy = By.id("bday_year");
    private By searchAgeFromDropdownBy = By.id("search_age_from");
    private By searchAgeToDropdownBy = By.id("search_age_to");
    private By educationDropdownBy = By.cssSelector("[name='education']");
    private By positionDropdownBy = By.cssSelector("[name='position']");
    private By fieldOfActivityDropdownBy = By.cssSelector("[name='field_of_activity']");
    private String languagesSpokenXpathFormat = "//*[@name='foreign_languages']/following-sibling::label[text()='%s']";// //*[@name='foreign_languages']/following-sibling::label[text()='english']
    private By maritalStatusDropdownBy = By.cssSelector("[name='marital_status']");
    private By childrenDropdownBy = By.cssSelector("[name='children']");
    private By religionDropdownBy = By.cssSelector("[name='religion']");
    private By heightBy = By.xpath("//div[text()='Height']/following-sibling::div/div/input[@type='text']");
    private By weightBy = By.xpath("//div[text()='Weight']/following-sibling::div/div/input[@type='text']");
    private By bodytypeDropdownBy = By.cssSelector("[name='bodytype']");
    private By healthDropdownBy = By.cssSelector("[name='health']");
    private By lookDropdownBy = By.cssSelector("[name='look']");
    private By smokingDropdownBy = By.cssSelector("[name='smoking']");
    private By alcoholDropdownBy = By.cssSelector("[name='alcohol']");

    private By submitButtonBy = By.cssSelector("button[type='submit']");


    public KsRegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        //driver.navigate().to("https://en.kismia.com/sign/application?change_language=1");
        click(englishUIButton);

        isPageLoaded(countryDropdownBy);
    }

    public KsRegistrationUploadPhotoPage submitRegistrationForm() {
        click(submitButtonBy);
        return new KsRegistrationUploadPhotoPage(driver);
    }

    public void selectCountry(String country) {
        try {
            selectItem(countryDropdownBy, country);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", country);
        }
    }

    public void enterCity(String city) {
        writeText(cityBy, city);
    }

    public void selectBirthday(LocalDate birthdayDate) {
        selectBirthdayDay(birthdayDate.getDayOfMonth());
        selectBirthdayMonth(birthdayDate.getMonthValue());
        selectBirthdayYear(birthdayDate.getYear());
    }

    public void selectBirthdayDay(int birthdayDay) {
        try {
            selectItem(birthdayDayDropdownBy, Integer.toString(birthdayDay));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", Integer.toString(birthdayDay));
        }
    }

    public void selectBirthdayMonth(int birthdayMonth) {
        try {
            selectItem(birthdayMonthDropdownBy, birthdayMonth);//by index
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", birthdayMonth);
        }
    }

    public void selectBirthdayYear(int birthdayYear) {
        try {
            selectItem(birthdayYearDropdownBy, Integer.toString(birthdayYear));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", Integer.toString(birthdayYear));
        }
    }

    public void selectSearchAge(int minSearchAge, int maxSearchAge) {
        selectSearchAgeFrom(minSearchAge);
        selectSearchAgeFrom(maxSearchAge);
    }

    public void selectSearchAgeFrom(int searchAgeFrom) {
        try {
            selectItem(searchAgeFromDropdownBy, Integer.toString(searchAgeFrom));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", Integer.toString(searchAgeFrom));
        }
    }

    public void selectSearchAgeTo(int searchAgeTo) {
        try {
            selectItem(searchAgeToDropdownBy, Integer.toString(searchAgeTo));
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", Integer.toString(searchAgeTo));
        }
    }

    public void selectEducation(String education) {
        try {
            selectItem(educationDropdownBy, education);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", education);
        }
    }

    public void selectPosition(String education) {
        try {
            selectItem(positionDropdownBy, education);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", education);
        }
    }

    public void selectFieldOfActivity(String fieldOfActivity) {
        try {
            selectItem(fieldOfActivityDropdownBy, fieldOfActivity);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", fieldOfActivity);
        }
    }

    public void selectLanguages(List<String> languages) {
        for (String language : languages) {
            WebElement languageElement = driver.findElement(By.xpath(String.format(languagesSpokenXpathFormat, language.toLowerCase())));
            languageElement.click();
        }
    }

    public void selectMritalStatus(String maritalStatus) {
        try {
            selectItem(maritalStatusDropdownBy, maritalStatus);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", maritalStatus);
        }
    }

    public void selectChildren(String children) {
        try {
            selectItem(childrenDropdownBy, children);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", children);
        }
    }

    public void selectReligion(String religion) {
        try {
            selectItem(religionDropdownBy, religion);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", religion);
        }
    }

    public void enterHeight(String height) {
        writeText(heightBy, height);
    }

    public void enterWeight(String weight) {
        writeText(weightBy, weight);
    }

    public void selectBodytype(String odytype) {
        try {
            selectItem(bodytypeDropdownBy, odytype);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", odytype);
        }
    }

    public void selectHealth(String health) {
        try {
            selectItem(healthDropdownBy, health);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", health);
        }
    }

    public void selectLook(String look) {
        try {
            selectItem(lookDropdownBy, look);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", look);
        }
    }

    public void selectSmoking(String smoking) {
        try {
            selectItem(smokingDropdownBy, smoking);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", smoking);
        }
    }

    public void selectAlcohol(String alcohol) {
        try {
            selectItem(alcoholDropdownBy, alcohol);
        } catch (NoSuchElementException ex) {
            System.err.printf("Can't select an item: %s %n", alcohol);
        }
    }
}
