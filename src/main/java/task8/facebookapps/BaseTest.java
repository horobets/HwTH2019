package task8.facebookapps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        //driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}