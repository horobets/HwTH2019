package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ImdbCompareExample {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowserNavigation() {
        driver.get("https://www.imdb.com/chart/top");

        List<WebElement> titleElements = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        for (WebElement titleElement : titleElements) {
            System.out.println(titleElement.getText());
            System.out.println(titleElement.getAttribute("href"));

            // get rating score of the current movie
            String relativeHref = titleElement.getAttribute("pathname");
            String ratingXpath = String.format("//tr[td/a[contains(@href, '%s')]]/td[@class='ratingColumn imdbRating']/strong", relativeHref);
            WebElement ratingElement = driver.findElement(By.xpath(ratingXpath));
            System.out.printf("Rating: %s\n\n", ratingElement.getText());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}