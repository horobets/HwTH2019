package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LiniakinoMovies {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowserNavigation() {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        List<WebElement> movies = driver.findElements(By.xpath("//li[@class='showtime-movie']/h1/a"));
        for (WebElement movie : movies) {
            System.out.println(movie.getText());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}