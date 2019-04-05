package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheck {
    public static void main(String[] args) throws InterruptedException {

        /*
        //MacOS / Ubuntu
        System.setProperty("webdriver.chrome.driver", "/Users/lolik/webDrivers/chromedriver");
        //Windows (.exe)
        System.setProperty("webdriver.chrome.driver", "C:/webDrivers/chromedriver.exe");

        gs: or just project dir
        */

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();

    }
}
