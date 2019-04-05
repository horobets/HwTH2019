package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class facebookRegistrationPage {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation() {

        driver.get("http://facebook.com/");

        /*
        //*[@id="u_0_n"]
        //*[@id="u_0_p"]
        //*[@id="u_0_s"]
        //*[@id="u_0_z"]
//bd
        //*[@id="month"]
        //*[@id="day"]
        //*[@id="year"]

//sx
        //*[@id="u_0_9"]
        //*[@id="u_0_a"]

//*[@id="u_0_15"]

         */

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



