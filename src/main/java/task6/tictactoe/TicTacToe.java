package task6.tictactoe;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe {
    public TicTacToe(Difficulty difficulty, Role playerRole) {
        this.difficulty = difficulty;
        this.playerRole = playerRole;
        runGame();
    }
    public TicTacToe(Difficulty difficulty) {
        this(difficulty, Role.X);
    }

    private Role[][] gameDataArray = new Role[3][3];
    private Difficulty difficulty;
    private Role playerRole;
    private GameStatus gameStatus;
    private Role turn = Role.X;
    private Role winner;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Role getPlayerRole() {
        return playerRole;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Role getTurn() throws InvalidGameActionException {

        if (gameStatus != GameStatus.PLAYER_TURN)
            throw new InvalidGameActionException("Can't get the next turn. Invalid game state.", gameStatus);

        return turn;
    }

    public Role getWinner() throws InvalidGameActionException {

        if (gameStatus != GameStatus.WIN)
            throw new InvalidGameActionException("Can't show the winner. Invalid game state.", gameStatus);

        return winner;
    }

    private void runGame() {
        gameStatus = GameStatus.PLAYER_TURN;

        checkTableStatus();
    }


    public void submitChoice(int location) throws InvalidGameActionException, CellNotEmptyException {

        if (gameStatus != GameStatus.PLAYER_TURN)
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
        turn = turn == Role.X ? Role.O : Role.X; //use different value for next turn

        checkTableStatus();
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
                this.winner = winningLine.getRole();
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


    private void computerChoice() {

        int locationToSubmitTo = 0;
        if (difficulty == Difficulty.NORMAL)//use ProTip for impossible
            locationToSubmitTo = getNextTurnLocationProTip();
        else//use random for Normal
            locationToSubmitTo = getRandomEmptyLocation();

        //submit random choice
        try {
            submitChoice(locationToSubmitTo);

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
        for (Role[] roles : gameDataArray) {
            for (int j = 0; j < roles.length; j++) {
                if (roles[j] == null) {
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
            if (winningLine.getRole() == turn) {//if it's our winning line, use it to win
                return winningLine.getEmptyCellLocation();
            }
        }

        //now check if there is a possible opponent's win and prevent it by filling their cell
        if(possibleWinningLines.size()>0)
            return possibleWinningLines.get(0).getEmptyCellLocation();

        //no pro tip - suggest random location
        return getRandomEmptyLocation();
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
            Role role = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int j = 0; j < gameDataArray[i].length; j++) {
                if (role == null) {
                    role = gameDataArray[i][j];
                }
                if (gameDataArray[i][j] != null) {
                    if (role == gameDataArray[i][j]) {
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
                possibleWinningLines.add(new WinningLine(WinningLineType.ROW, i, role, false, emptyCellLocation));//add this row to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray[i].length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.ROW, i, role, true));//this row WINS the round
            }
        }


        //try to find possible winning column
        for (int i = 0; i < gameDataArray.length; i++) {
            Role role = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int j = 0; j < gameDataArray[i].length; j++) {
                if (role == null) {
                    role = gameDataArray[j][i];
                }
                if (gameDataArray[j][i] != null) {
                    if (role == gameDataArray[j][i]) {
                        similarValsCount++;
                    } else {//row contains different values - cannot be a winning row
                        similarValsCount = 0;//reset to 0 to avoid false positives in case of 'X|X|0'
                        break;
                    }
                } else {
                    emptyCellLocation = indexesToNumericLocation(j, i);
                }
            }
            if (similarValsCount == gameDataArray.length - 1) {
                possibleWinningLines.add(new WinningLine(WinningLineType.COLUMN, i, role, false, emptyCellLocation));//add this row to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.COLUMN, i, role, true));//this row WINS the round
            }
        }


        //check the main diagonal for winning line
        {
            Role role = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int i = 0; i < gameDataArray.length; i++) {

                if (role == null) {
                    role = gameDataArray[i][i];
                }
                if (gameDataArray[i][i] != null) {
                    if (role == gameDataArray[i][i]) {
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
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 0, role, false, emptyCellLocation));//add this diagonal to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 0, role, true));//this diagonal WINS the round
            }
        }

        //check secondary diagonal
        {
            Role role = null;
            int similarValsCount = 0;
            int emptyCellLocation = 0;
            for (int i = 0; i < gameDataArray.length; i++) {


                if (role == null) {
                    role = gameDataArray[gameDataArray.length - 1 - i][i];
                }
                if (gameDataArray[gameDataArray.length - 1 - i][i] != null) {
                    if (role == gameDataArray[gameDataArray.length - 1 - i][i]) {
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
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 1, role, false, emptyCellLocation));//add this diagonal to the list of possible winning lines
            }
            if (similarValsCount == gameDataArray.length) {
                possibleWinningLines.add(new WinningLine(WinningLineType.DIAGONAL, 1, role, true));//this diagonal WINS the round
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

    public void printTable(boolean printLocatonsOnly) {

        WinningLine winningLine = getWinningLine();

        System.out.printf("%n%n");
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < gameDataArray[i].length; j++) {

                //check is current value is from winning line to mark it on UI
                boolean isWinningLineValue = false;
                if (winningLine != null) {
                    if (winningLine.getType() == WinningLineType.ROW && winningLine.getLineIndex() == i)
                        isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.COLUMN && winningLine.getLineIndex() == j)
                        isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.DIAGONAL && winningLine.getLineIndex() == 0)
                        if (i == j)
                            isWinningLineValue = true;
                    if (winningLine.getType() == WinningLineType.DIAGONAL && winningLine.getLineIndex() == 1)//secondary diagonal winning value
                        if (i == gameDataArray.length - 1-j)
                            isWinningLineValue = true;
                }

                String valueToDisplay = String.format("\t%s\t", gameDataArray[i][j] == null ? " " : gameDataArray[i][j].toString());

                if(printLocatonsOnly)
                    valueToDisplay = String.format("\t%s\t", indexesToNumericLocation(i,j));

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
                System.out.printf("%n_________________________%n");
            }
        }
        System.out.printf("%n");
    }

}