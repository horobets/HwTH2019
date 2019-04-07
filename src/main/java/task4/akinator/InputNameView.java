package task4.akinator;

public class InputNameView {
    public InputNameView(String inputNameTitle, String inputNameLabel) {
        this.inputNameTitle = inputNameTitle;
        this.inputNameLabel = inputNameLabel;
    }

    private String inputNameTitle;
    private String inputNameLabel;

    public String getInputNameTitle() {
        return inputNameTitle;
    }

    public String getInputNameLabel() {
        return inputNameLabel;
    }
}
