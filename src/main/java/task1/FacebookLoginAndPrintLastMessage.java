package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginAndPrintLastMessage {
    private static WebDriver driver;

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

        driver = new ChromeDriver(options);

        loginToFacebook("test@facebook.com", "TestPassword123!");

        String lastMessage = getLastFacebookMessage();

        System.out.printf("Last message: %s", lastMessage);

        driver.quit();
    }

    private static void loginToFacebook(String username, String password) {
        driver.get("https://www.facebook.com/");

        //WebElement fbLogin = driver.findElement(By.id("email"));

        // wait until Facebook Login page loads
        WebElement fbLogin = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

        WebElement fbPassword = driver.findElement(By.id("pass"));

        fbLogin.clear();
        fbLogin.sendKeys(username);
        fbPassword.clear();
        fbPassword.sendKeys(password);
        fbPassword.sendKeys(Keys.ENTER);
    }

    private static String getLastFacebookMessage() {

        openFacebookMessenger();

        // wait until Facebook Messenger UI loads
        WebElement fbMessageElement = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_aok']")));

        /* // display all messages from current conversation
        for(WebElement webElement : driver.findElements(By.xpath("//div[@class='_aok']/span")))
            System.out.println(webElement.getText());
        */

        String lastMessage = driver.findElement(By.xpath("//div[@class='_aok']/span[last()]")).getText();
        return lastMessage;
    }

    private static void openFacebookMessenger() {

        // wait until Facebook Main UI loads
        WebElement fbMessagesButton = (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[a[@data-testid='left_nav_item_Messenger']]")));
        fbMessagesButton.click();
    }
}
