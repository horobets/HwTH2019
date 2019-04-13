package task6.tictactoe;

public class CellNotEmptyException extends Exception {
    public CellNotEmptyException(String message, int cellLocation) {
        super(String.format("%s%nCell location: %s", message, cellLocation));
    }
}
