package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHelloWorld {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[name='q']")).clear();
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Hello, world!");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".g h3")).click();

        Thread.sleep(1000);

        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.quit();
    }
}
