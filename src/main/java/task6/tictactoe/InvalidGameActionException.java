package task6.tictactoe;

public class InvalidGameActionException extends Exception {
    public InvalidGameActionException(String message, GameStatus gameStatus) {
        super(String.format("%s%nCurrent game status: %s", message, gameStatus));
    }
}
