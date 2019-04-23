package lesson8.testng_lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralTest {

    static WebDriver driver;

    public static void main(String[] args) {

        //System.setProperty("webdriver.chromedriver", );

        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
