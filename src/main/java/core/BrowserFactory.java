package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BrowserFactory {
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


    //lesson11 drafts
    public void click(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static WebElement find(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void type(By by, String text) {
        find(by).clear();
        find(by).sendKeys(text);
    }

    public static void makeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("/Users/lolik/11zzzz1.png"));
    }

}