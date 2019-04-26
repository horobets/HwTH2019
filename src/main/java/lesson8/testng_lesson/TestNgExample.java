package lesson8.testng_lesson;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(CustomListener.class)
public class TestNgExample {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
    }


    private String expectedTitle = "Save Time Editing PDF Documents Online For Free";
    @Test
    public void firstTestNgTest(){


        driver.get("http://www.pdffiller.com");



        WebElement titleElement = driver.findElement(By.xpath("//*[@class='page-title']")) ;


        WebElement homeElement = driver.findElement(By.xpath("//*[@class='g-mail-nav__link active']"));
        String actualHomeName = homeElement.getText();
        String actualTitle = titleElement.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTitle, actualTitle, "Title is incorrect");
        Assert.assertTrue(actualTitle.equals(expectedTitle), "sdfsdfsdfsdf");

        softAssert.assertAll();
    }
}
