package exam2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertDemo {


    @Test
    public void AlertTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com");

        Alert alert = driver.switchTo().alert();

        String message = driver.switchTo().alert().getText();

        System.out.println(message);
        alert.accept();
    }
}