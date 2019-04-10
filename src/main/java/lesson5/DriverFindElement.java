package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverFindElement extends BrowserFactory{

    @Test
    public void tryFindElement()
    {
        driver.get("http://www.imdb.com/chart/top");
        driver.findElement(By.xpath("//noElement"));
    }

    public void tryFindElements()
    {


        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://eee.");
    }

}
