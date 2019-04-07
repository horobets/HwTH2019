package task4.akinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class AkinatorGame {

    protected static WebDriver driver;

    public static void main(String[] args) {

        System.out.println("Initializing...");
        setUp();

        AkinatorPage akinatorPage = new AkinatorPage(driver);
        akinatorPage.goToPage();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Start new game? (y/n) ");
            char answerChar = scanner.next().charAt(0);
            if (answerChar != 'y' && answerChar != 'Y')
                break;

            akinatorPage.startGame();

            while (true) {
                akinatorPage.getAkinatorQuestion();
            }

        }

        System.out.println("Thanks for playing!");
        driver.quit();
    }

    public static void printQuestion(AkinatorQuestion question) {
        System.out.printf("Question %d: %n", question.getQuestionNumber());
        System.out.printf("Akinator asks: %n %s %n", question.getQuestionText());
    }

    public static void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
    }
}