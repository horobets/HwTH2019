package task8.kismia;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;


public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
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
    }


    protected WebDriver switchToNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        String newWindowHandle = windowHandles.get(windowHandles.size() - 1);//last windowhandle should be the new window

        return driver.switchTo().window(newWindowHandle);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}