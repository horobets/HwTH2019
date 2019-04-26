package task7;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

// ref
// http://learn-automation.com/how-to-capture-screenshot-in-selenium-webdriver/
// https://www.guru99.com/take-screenshot-selenium-webdriver.html

public class CodingBatString1Screenshots {

    static WebDriver driver;

    static By tasksBy = By.xpath("//div[span[text()='String-1']]//td/a[@href]");
    static String taskXpathFormat = "(//div[span[text()='String-1']]//td/a[@href])[%d]";
    static By runTaskTestButtonBy = By.cssSelector(".go");
    static String screenshotsDir = "c:\\codingbat-screenshots\\";

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://codingbat.com/java/String-1");

        // wait until main page loads
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tasksBy));

        String screenshotMainPageFilePath = String.format("%sCodingBat_String-1.png", screenshotsDir);
        takeSnapShot(driver, screenshotMainPageFilePath);


        List<WebElement> tasksElements = driver.findElements(tasksBy);
        for(int i = 0; i< tasksElements.size(); i++){

            WebElement currentTaskElement = driver.findElement(By.xpath(String.format(taskXpathFormat, i+1)));

            String currentTaskName = currentTaskElement.getText();

            currentTaskElement.click();

            // wait until page loads
            (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ace_content']")));

            //run tests
            driver.findElement(runTaskTestButtonBy).click();
            // wait for tests to complete until page loads
            (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("center > img[src='/c2big.jpg']")));

            String screenshotFilePath = String.format("%sCodingBat_String-1_%d_%s.png", screenshotsDir, i+1,  currentTaskName);

            takeSnapShot(driver, screenshotFilePath);

            driver.navigate().back();
        }
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(fileWithPath);

        //Copy file at destination
        try {
        FileUtils.copyFile(SrcFile, DestFile);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
