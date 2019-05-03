package task8.kismia.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class KsProfileSettingsPersonalPage extends KsProfileSettingsBasePage {

    private By ksGenderMaleBy = By.xpath("//input[@name='gender' and @type='radio' and @value='m']");
    private By ksGenderFemaleBy = By.xpath("//input[@name='gender' and @type='radio' and @value='f']");
    private By birthdayDayDropdownBy = By.id("day");
    private By birthdayMonthDropdownBy = By.id("month");
    private By birthdayYearDropdownBy = By.id("year");

    private By profileTabBy = By.cssSelector("//div[@class='settings-nav__elem js_settingsNav active' and @data-tab='profile']");

    public KsProfileSettingsPersonalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

        isElementPresent(profileTabBy, 5);
    }

    public void setGender(Gender gender) {
        switch (gender) {
            case MALE:
                driver.findElement(ksGenderMaleBy).click();
                break;
            case FEMALE:
                driver.findElement(ksGenderFemaleBy).click();
                break;
            default:
                System.err.printf("Unknown gender: %s %n", gender);
                return;
        }
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

}
