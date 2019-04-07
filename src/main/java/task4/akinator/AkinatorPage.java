package task4.akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AkinatorPage extends BasePage {
    public AkinatorPage(WebDriver driver) {
        super(driver);
    }

    private By startGameButtonBy = By.xpath("//a[@href='/game']");

    private By questionNumberBy = By.xpath("//p[@class='question-number']");
    private By questionTextBy = By.xpath("//p[@class='question-text']");

    //private By answersBy = By.xpath("//div[@class='database-selection selector dialog-box']/ul/li/a");
    private String answersXpath = "//div[@class='database-selection selector dialog-box']/ul/li/a";

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

    public void startGame() {
        click(startGameButtonBy);
    }

    public AkinatorQuestion getAkinatorQuestion() {
        int questionNumber = Integer.parseInt(readText(questionNumberBy));
        String questionText = readText(questionTextBy);
        List<String> answers = getAnswers();

        AkinatorQuestion question = new AkinatorQuestion(questionNumber, questionText, answers);
        return question;
    }

    private List<String> getAnswers() {
        By answersBy = By.xpath(answersXpath);
        List<WebElement> answerElements = driver.findElements(answersBy);

        List<String> answers = new ArrayList<>();
        for (WebElement answerElement : answerElements) {
            answers.add(answerElement.getText());
        }
        return answers;
    }

    public void sendAnswer(int answerId) {
        String answerXpath = String.format("(%s)[%d]", answersXpath, answerId + 1);
        By answerBy = By.xpath(answerXpath);

        click(answerBy);
    }
}
