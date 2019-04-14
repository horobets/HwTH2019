package task6.tictactoe;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe {
    public TicTacToe(Difficulty difficulty, CellValue playerRole) {
        this.difficulty = difficulty;
        this.playerRole = playerRole;
        runGame();
    }

    private CellValue[][] gameDataArray = new CellValue[3][3];
    private Difficulty difficulty;
    private CellValue playerRole;
    private GameStatus gameStatus;
    private CellValue turn = CellValue.X;
    private CellValue winner;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public CellValue getPlayerRole() {
        return playerRole;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public CellValue getTurn() throws InvalidGameActionException {

        if (gameStatus != GameStatus.TURN)
            throw new InvalidGameActionException("Can't get the next turn. Invalid game state.", gameStatus);

        return turn;
    }

    public CellValue getWinner() throws InvalidGameActionException {

        if (gameStatus != GameStatus.WIN)
            throw new InvalidGameActionException("Can't show the winner. Invalid game state.", gameStatus);

        return winner;
    }

    private void runGame() {
        gameStatus = GameStatus.TURN;
    }

    private void computerChoice() {

        //find possible winning lines to win or to prevent loose
        List<WinningLine> possibleWinningLines = findPossibleWinningLines();
        for (WinningLine possibleWinningLine : possibleWinningLines) {
            System.out.printf("Winning Line Type: %s, Line: %s %n", possibleWinningLine.getType(), possibleWinningLine.getLineIndex());
        }

        //submit random choice
        try {
            submitChoice(getRandomEmptyLocation());

        } catch (InvalidGameActionException | CellNotEmptyException ex) {
            System.err.printf("Computer Choice Critical Error: %s", ex);
        }
    }

    private int getRandomEmptyLocation() {
        int[] emptyCellsLocations = getEmptyCellsLocations();

        Random rnd = new Random();

        return emptyCellsLocations[rnd.nextInt(emptyCellsLocations.length)];//return random index of empty cells
    }

    private int[] getEmptyCellsLocations() {
        List<Integer> emptyCellsLocations = new ArrayList<>();

        int currentLocation = 1;//numeric cell location
        for (CellValue[] cellValues : gameDataArray) {
            for (int j = 0; j < cellValues.length; j++) {
                if (cellValues[j] == null) {
                    emptyCellsLocations.add(currentLocation);//add numeric location (1-9) to the list
                }
                currentLocation++;
            }
        }

        return emptyCellsLocations.stream().mapToInt(i -> i).toArray();
    }

    public int getNextTurnLocationProTip() {

        List<WinningLine> possibleWinningLines = findPossibleWinningLines();

        //first, check if there is a way to win right now
        for (WinningLine winningLine : possibleWinningLines) {
            if (winningLine.getCellValue() == turn) {//if it's our winning line, use it to win
                return winningLine.getEmptyCellLocation();
            }
        }

        //now check if there is a possible opponent's win and prevent it by filling their cell
        for (WinningLine winningLine : possibleWinningLines) {
            return winningLine.getEmptyCellLocation();
        }

        //no pro tip - suggest random location
        return getRandomEmptyLocation();
    }


    public void submitChoice(int location) throws InvalidGameActionException, CellNotEmptyException {

        if (gameStatus != GameStatus.TURN)
            throw new InvalidGameActionException("Can't do the requested action. Invalid game state.", gameStatus);

        if (location < 1 || location > 9)
            throw new IllegalArgumentException(String.format("Invalid location provided: %d. Acceptable values 1 - 9.", location));


        //convert user location (1-9) to to array indexes '[1][2]'
        int[] locationIndexes = locationToIndexes(location);

        //update cell if it is empty
        if (gameDataArray[locationIndexes[1]][locationIndexes[0]] == null) {
            gameDataArray[locationIndexes[1]][locationIndexes[0]] = turn;
        } else
            throw new CellNotEmptyException("This cell is not empty", location);


        //swap next turn value
        turn = turn == CellValue.X ? CellValue.O : CellValue.X; //use different value for next turn

        checkTableStatus();
    }

    /**
     * Convert user numericLocation (1-9) to to array indexes '[1][2]'
     *
     * @param numericLocation
     * @return
     */
    private int[] locationToIndexes(int numericLocation) {
        numericLocation--;//start from 0, not 1

        int[] indexes = new int[2];

        // counter for indexes array
        int i = 0;
        while (numericLocation > 0) {
            // storing remainder in indexes array
            indexes[i] = numericLocation % 3;
            numericLocation = numericLocation / 3;
            i++;
        }

        return indexes;
    }

    /**
     * Convert indexes '[1][2]' to user numericLocation (1-9)
     */
    private int indexesToNumericLocation(int rowIndex, int columnIndex) {
        int num = rowIndex * 10 + columnIndex;
        int numericLocation = 0;

        int base = 1;
        int temp = num;
        while (temp != 0) {

            // Extracting last digit
            int last_digit = temp % 10;
            temp = temp / 10;

            // Multiplying last digit with appropriate
            // base value and adding it to dec_value
            numericLocation += last_digit * base;

            base = base * 3;
        }

        numericLocation++;//location starts with 1, not 0

        return numericLocation;
    }

    private List<WinningLine> findPossibleWinningLines() {

        List<WinningLine> possibleWinningLines = new ArrayList<>();

        //try to find possible winning row
        for (int i = 0; i < gameDataArray.length; i++) {
            CellValue cellValue = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int j = 0; j < gameDataArray[i].length; j++) {
                if (cellValue == null) {
                    cellValue = gameDataArray[i][j];
                }
                if (gameDataArray[i][j] != null) {
                    if (cellValue == gameDataArray[i][j]) {
                        similarValsCount++;
                    } else {//row contains different values - cannot be a winning row
                        similarValsCount = 0;//reset to 0 to avoid false positives in case of 'X|X|0'
                        break;
                    }
                } else {
                    emptyCellLocation = indexesToNumericLocation(i, j);
                }

            }
            if (similarValsCount == gameDataArray[i].length - 1) {
                possibleWinningLines.add(new WinningLine(WinningLineType.ROW, i, cellValue, false, emptyCellLocation));//add this row to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray[i].length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.ROW, i, cellValue, true));//this row WINS the round
            }
        }


        //try to find possible winning column
        for (int i = 0; i < gameDataArray.length; i++) {
            CellValue cellValue = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int j = 0; j < gameDataArray[i].length; j++) {
                if (cellValue == null) {
                    cellValue = gameDataArray[j][i];
                }
                if (gameDataArray[j][i] != null) {
                    if (cellValue == gameDataArray[j][i]) {
                        similarValsCount++;
                    } else {//row contains different values - cannot be a winning row
                        similarValsCount = 0;//reset to 0 to avoid false positives in case of 'X|X|0'
                        break;
                    }
                } else {
                    emptyCellLocation = indexesToNumericLocation(i, j);
                }
            }
            if (similarValsCount == gameDataArray.length - 1) {
                possibleWinningLines.add(new WinningLine(WinningLineType.COLUMT, i, cellValue, false, emptyCellLocation));//add this row to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.COLUMT, i, cellValue, true));//this row WINS the round
            }
        }


        //check the main diagonal for winning line
        {
            CellValue cellValue = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int i = 1; i < gameDataArray.length; i++) {

                if (cellValue == null) {
                    cellValue = gameDataArray[i][i];
                }
                if (gameDataArray[i][i] != null) {
                    if (cellValue == gameDataArray[i][i]) {
                        similarValsCount++;
                    } else {//diagonal contains different values - cannot be a winning one
                        similarValsCount = 0;//reset to 0 to avoid false positives in case of 'X|X|0'
                        break;
                    }
                } else {
                    emptyCellLocation = indexesToNumericLocation(i, i);
                }

            }
            if (similarValsCount == gameDataArray.length - 1) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 0, cellValue, false, emptyCellLocation));//add this diagonal to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 0, cellValue, true));//this diagonal WINS the round
            }
        }

        //check secondary diagonal
        {
            CellValue cellValue = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int i = 1; i < gameDataArray.length; i++) {


                if (cellValue == null) {
                    cellValue = gameDataArray[gameDataArray.length - 1 - i][i];
                }
                if (gameDataArray[gameDataArray.length - 1 - i][i] != null) {
                    if (cellValue == gameDataArray[gameDataArray.length - 1 - i][i]) {
                        similarValsCount++;
                    } else {//diagonal contains different values - cannot be a winning one
                        similarValsCount = 0;//reset to 0 to avoid false positives in case of 'X|X|0'
                        break;
                    }
                } else {
                    emptyCellLocation = indexesToNumericLocation(gameDataArray.length - 1 - i, i);
                }


            }
            if (similarValsCount == gameDataArray.length - 1) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 1, cellValue, false, emptyCellLocation));//add this diagonal to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 1, cellValue, true));//this diagonal WINS the round
            }
        }

        return possibleWinningLines;
    }

    private WinningLine getWinningLine()
    {
        List<WinningLine> possibleWinningLines = findPossibleWinningLines();
        for (WinningLine possibleWinningLine : possibleWinningLines) {
            if (possibleWinningLine.isCompletelyFilled()) {
                return possibleWinningLine;
            }
        }
        return null;
    }

    private void checkTableStatus() {
        if (getEmptyCellsLocations().length == 0) {//TIE
            gameStatus = GameStatus.TIE;
            return;
        }

        //try to find a winner
        List<WinningLine> winningLines = findPossibleWinningLines();

        for (WinningLine winningLine : winningLines) {
            if (winningLine.isCompletelyFilled()) {//winner found
                gameStatus = GameStatus.WIN;
                this.winner = winningLine.getCellValue();
                return;
            }
        }

        //no tie, no winner. continue game
        nextStep();
    }


    private void nextStep() {
        if (difficulty != Difficulty.FRIEND && turn != playerRole) {//computer turn
            computerChoice();
        }
    }

    public void printTable() {

        WinningLine winningLine = getWinningLine();
        if (winningLine != null) {

        }

        System.out.printf("%n");
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < gameDataArray[i].length; j++) {

                //check is current value is from winning line to mark it on UI
                boolean isWinningLineValue = false;
                if (winningLine != null) {
                    if (winningLine.getType() == WinningLineType.ROW && winningLine.getLineIndex() == i)
                        isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.COLUMT && winningLine.getLineIndex() == j)
                        isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.DIAGONAL && winningLine.getLineIndex() == 0)
                        if (i == j)
                            isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.DIAGONAL && winningLine.getLineIndex() == 1)//secondary diagonal winning value
                        if (i == j + gameDataArray.length - 1)
                            isWinningLineValue = true;
                }

                String valueToDisplay = String.format("\t%s\t", gameDataArray[i][j] == null ? " " : gameDataArray[i][j].toString());

                if (isWinningLineValue) {//display winning line values in reg (using err output)
                    System.err.printf(valueToDisplay);
                } else {
                    System.out.printf(valueToDisplay);
                }

                if (j < gameDataArray[j].length - 1) {//don't print line after last val
                    System.out.printf("|");
                }
            }
            if (i < gameDataArray[i].length - 1) {//don't print line after last val
                System.out.printf("%n__________________________%n");
            }
        }
        System.out.printf("%n");
    }
}