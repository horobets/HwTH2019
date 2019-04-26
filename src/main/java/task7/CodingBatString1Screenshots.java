package task7;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public static void main(String[] args) {

        By tasksBy = By.xpath("//div[span[text()='String-1']]//td/a[@href]");


        driver=new ChromeDriver();

        List<WebElement> tasksElements = driver.findElements(tasksBy);
        for(int i = 0; i< tasksElements.size(); i++){
            driver.get("https://codingbat.com/java/String-1/");
            tasksElements.get(i).click();


            // wait until page loads
            (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ace_content']")));

            String screenshotFilePath = String.format("c:\\codingbat-screenshots\\%d", i );

            takeSnapShot(driver, screenshotFilePath);
        }



        takeSnapShot(driver, "c://test.png") ;

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
