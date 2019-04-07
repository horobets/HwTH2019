package task4.akinator;

import java.util.List;

public class AkinatorQuestion {
    public AkinatorQuestion(int questionNumber, String questionText, List<String> answers) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.answers = answers;
    }

    private int questionNumber;
    private String questionText;
    private List<String> answers;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
