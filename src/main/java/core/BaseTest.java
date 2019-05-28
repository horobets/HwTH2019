package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {

        //System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();


        //driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver = new EventFiringWebDriver(driver).register(new DriverEventListener());
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public static void makeScreenshot() throws IOException {
        TakeScreenshot.takeScreenshot(driver, "/Users/lolik/11zzzz1.png");
    }


}