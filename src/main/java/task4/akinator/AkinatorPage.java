package task4.akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AkinatorPage extends BasePage {
    public AkinatorPage(WebDriver driver) {
        super(driver);
    }

    private By startGameButtonBy = By.xpath("//a[@href='/game']");

    private By questionTextBy = By.xpath("//p[@class='question-text']");

    private By answerYesBy = By.id("a_yes");
    private By answerNoBy = By.id("a_no");
    private By answerDontknowBy = By.id("a_dont_know");
    private By answerProbablyBy = By.id("a_probably");
    private By answerProbablynotBy = By.id("a_probaly_not");

    private By proposalTitleBy = By.xpath("//span[@class='proposal-title']");
    private By proposalSubtitleBy = By.xpath("//span[@class='proposal-subtitle']']");
    private By proposeYesBy = By.id("a_propose_ues");
    private By proposeNoBy = By.id("a_propose_no");

    private By proposeContinueYesBy = By.id("a_continue_yes");
    private By proposeContinueNoBy = By.id("a_continue_no");

    public void goToPage() {
        driver.get("https://ru.akinator.com/");
    }
}
