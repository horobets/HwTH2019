package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
