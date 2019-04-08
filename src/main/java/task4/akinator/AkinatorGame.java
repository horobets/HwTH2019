package task4.akinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Scanner;

public class AkinatorGame {

    protected static WebDriver driver;

    public static void main(String[] args) {

        System.out.println("Initializing...");
        setUp();

        AkinatorPage akinatorPage = new AkinatorPage(driver);

        endlessGame:
        while (true) {

            //check the currently displayed page type
            switch (akinatorPage.getCurrentViewMode()) {

                case HOMEPAGE: {
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Start new game? (y/n) ");
                    char answerChar = scanner.next().toLowerCase().charAt(0);
                    if (answerChar != 'y') {
                        break endlessGame;
                    }
                    akinatorPage.startGame();
                }
                break;
                case QUESTION: {//Akinator shows question

                    AkinatorQuestion question = akinatorPage.getAkinatorQuestion();

                    int answer = askUserQuestion(question);
                    akinatorPage.sendAnswerToQuestion(answer);
                }
                break;
                case PROPOSAL: {//Akinator shows proposal

                    AkinatorProposal proposal = akinatorPage.getAkinatorProposal();

                    int answer = askUserPropose(proposal);
                    akinatorPage.sendAnswerToProposal(answer);
                }
                break;
                case WIN: {//Akinator shows congratulations page
                    showWinSentences(akinatorPage.getWinSentences());
                    akinatorPage.goToPage();//go to homepage after winning
                }
                break;
                case ENTERNAME: {//Akinator offers to enter your own character name
                    String usersEnteredname = sendUsersName(akinatorPage.getInputView());
                    akinatorPage.sendUsersName(usersEnteredname);
                }
                break;
                default://other pages - redirect to Home
                    akinatorPage.goToPage();
                    break;
            }
        }

        System.out.println("Thanks for playing!");
        driver.quit();
    }

    private static String sendUsersName(InputNameView inputNameView) {
        System.out.printf("%n%s%n %s ", inputNameView.getInputNameTitle(), inputNameView.getInputNameLabel());

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private static void showWinSentences(List<String> winSentences) {
        System.out.printf("%nCongratulations!%n");
        for (String winSentence : winSentences) {
            System.out.println(winSentence);
        }
    }

    private static int askUserPropose(AkinatorProposal proposal) {

        //Print proposal
        System.out.printf("%n%s%n %s %n %s %n", proposal.getProposalDescription(), proposal.getProposalTitle(), proposal.getProposalSubtitle());

        //Print answers

        List<String> answers = proposal.getProposalAnswers();
        for (int i = 1; i <= answers.size(); i++)
            System.out.printf("[%d] %s %n", i, answers.get(i - 1));

        // Ask user and return selected option number
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.next());
    }

    private static int askUserQuestion(AkinatorQuestion question) {

        //Print Question
        System.out.printf("%nQuestion %d:%n %s %n", question.getQuestionNumber(), question.getQuestionText());

        //Print answers

        List<String> answers = question.getAnswers();
        for (int i = 1; i <= answers.size(); i++)
            System.out.printf("[%d] %s %n", i, answers.get(i - 1));

        // Ask user and return selected option number
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.next());
    }


    public static void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:/gswebDrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
    }
}