package task4.akinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AkinatorPage extends BasePage {
    public AkinatorPage(WebDriver driver) {
        super(driver);
    }

    private By bubbleHomeBy = By.xpath("//div[contains(@class, 'bubble-home')]");

    private By startGameButtonBy = By.xpath("//a[@href='/game']");

    private By questionNumberBy = By.xpath("//p[@class='question-number']");
    private By questionTextBy = By.xpath("//p[@class='question-text']");

    private String answersXpath = "//div[@class='database-selection selector dialog-box']/ul/li/a";

    private By proposalDescriptionBy = By.xpath("//div[@class='sub-bubble-propose']");
    private By proposalTitleBy = By.xpath("//span[@class='proposal-title']");
    private By proposalSubtitleBy = By.xpath("//span[@class='proposal-subtitle']");

    private String proposalAnswersXpath = "//span[@class='proposal-answers']/a";

    private By winSentencesBy = By.xpath("//p[span[@class='win-sentence']]/span");

    private By inputNameTitle = By.xpath("//div[@class='col-md-12 page-formulaire soundlike3']/h1");
    private By inputNameLabel = By.xpath("//label[input[@name='name']]");
    private By inputNameBy = By.xpath("//input[@name='name']");
    private By inputNameSubmitButtonBy = By.id("input-soundlike-search");

    private By loaderSpinnerBy = By.id("div-overlay");

    public void goToPage() {
        driver.get("https://ru.akinator.com/");
        waitLoader();
    }

    public void waitLoader() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderSpinnerBy));
    }

    public void startGame() {
        click(startGameButtonBy);
    }


    ViewMode getCurrentViewMode() {
        //check if Akinator shows website home page
        if (driver.findElements(bubbleHomeBy).size() > 0) {
            return ViewMode.HOMEPAGE;
        }
        //check if Akinator shows question
        if (driver.findElements(questionNumberBy).size() > 0) {
            return ViewMode.QUESTION;
        }
        //check if Akinator shows proposal
        if (driver.findElements(proposalTitleBy).size() > 0) {
            return ViewMode.PROPOSAL;
        }
        //check if Akinator shows win page
        if (driver.findElements(winSentencesBy).size() > 0) {
            return ViewMode.WIN;
        }
        //check if Akinator asks to enter the correct name
        if (driver.findElements(inputNameBy).size() > 0) {
            return ViewMode.ENTERNAME;
        }

        return ViewMode.UNKNOWN;
    }


    public AkinatorQuestion getAkinatorQuestion() {
        int questionNumber = Integer.parseInt(readText(questionNumberBy));
        String questionText = readText(questionTextBy);
        List<String> answers = getAnswersToQuestion();

        AkinatorQuestion question = new AkinatorQuestion(questionNumber, questionText, answers);
        return question;
    }

    private List<String> getAnswersToQuestion() {
        By answersBy = By.xpath(answersXpath);
        List<WebElement> answerElements = driver.findElements(answersBy);

        List<String> answers = new ArrayList<>();
        for (WebElement answerElement : answerElements) {
            answers.add(answerElement.getText());
        }
        return answers;
    }

    public void sendAnswerToQuestion(int answerId) {
        String answerXpath = String.format("(%s)[%d]", answersXpath, answerId);
        By answerBy = By.xpath(answerXpath);

        click(answerBy);

        waitLoader();
    }


    public AkinatorProposal getAkinatorProposal() {
        String proposalDescription = readText(proposalDescriptionBy);
        String proposalTitle = readText(proposalTitleBy);
        String proposalSubtitle = readText(proposalSubtitleBy);
        List<String> proposalAnswers = getAnswersToProposal();

        AkinatorProposal proposal = new AkinatorProposal(proposalDescription, proposalTitle, proposalSubtitle, proposalAnswers);
        return proposal;
    }

    private List<String> getAnswersToProposal() {
        By answersBy = By.xpath(proposalAnswersXpath);
        List<WebElement> answerElements = driver.findElements(answersBy);

        List<String> answers = new ArrayList<>();
        for (WebElement answerElement : answerElements) {
            answers.add(answerElement.getText());
        }
        return answers;
    }

    public void sendAnswerToProposal(int answerId) {
        String answerXpath = String.format("(%s)[%d]", proposalAnswersXpath, answerId);
        By answerBy = By.xpath(answerXpath);

        click(answerBy);

        waitLoader();
    }


    public List<String> getWinSentences() {
        List<WebElement> winElements = driver.findElements(winSentencesBy);

        List<String> winSentences = new ArrayList<>();
        for (WebElement answerElement : winElements) {
            winSentences.add(answerElement.getText());
        }
        return winSentences;
    }

    public InputNameView getInputView() {
        String inputViewTitle = readText(inputNameTitle);
        String inputViewLabel = readText(inputNameLabel);

        return new InputNameView(inputViewTitle, inputViewLabel);
    }

    public void sendUsersName(String usersName) {
        writeText(inputNameBy, usersName);
        click(inputNameSubmitButtonBy);

        waitLoader();
    }


}
