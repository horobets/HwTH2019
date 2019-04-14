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

        if(gameStatus != GameStatus.TURN)
            throw new InvalidGameActionException("Can't get the next turn. Invalid game state.", gameStatus);

        return turn;
    }

    public CellValue getWinner() throws InvalidGameActionException {

        if(gameStatus != GameStatus.WIN)
            throw new InvalidGameActionException("Can't show the winner. Invalid game state.", gameStatus);

        return winner;
    }

    private void runGame()
    {
        gameStatus = GameStatus.TURN;
    }

    private void computerChoice() {

        //submit random choice
        try {
            submitChoice(getRandomEmptyLocation());

        } catch (InvalidGameActionException | CellNotEmptyException ex) {
            System.err.printf("Computer Choice Critical Error: %s", ex);
        }
    }

    private int getRandomEmptyLocation()
    {
        int[] emptyCellsLocations =getEmptyCellsLocations();

        Random rnd = new Random();

        return emptyCellsLocations[rnd.nextInt(emptyCellsLocations.length)];//return random index of empty cells
    }

    private int[] getEmptyCellsLocations()
    {
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

    public void submitChoice(int location) throws InvalidGameActionException, CellNotEmptyException {

        if(gameStatus != GameStatus.TURN)
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


    private void checkPossibleWinningLine() {
        //try to find possible winning row
        for (int i = 0; i < gameDataArray.length; i++) {
            CellValue cellValue = null;
            int simularValsCount = 0;
            for (int j = 0; j < gameDataArray[i].length; j++) {

                if (cellValue == null) {
                    cellValue = gameDataArray[i][j];
                }

                if (gameDataArray[i][j] != null) {
                    if (cellValue == gameDataArray[i][j]) {
                        simularValsCount++;
                    } else {//row contains different values - cannot be a winning row
                        break;
                    }
                }

                if (simularValsCount == gameDataArray[i].length - 1 - 1) {
                    System.err.println("FOUND POSSIBLE WINNING ROW");
                }

/*
                if(gameDataArray[i][0] != gameDataArray[i][j] || gameDataArray[i][j] == null)
                    break;//skip current row if on first found difference
                if(j==gameDataArray[i].length-1){//winning row found
                    setWinningStatus(gameDataArray[i][0]);
                    return;
                }*/
            }
        }

    }

    private void checkTableStatus()
    {
        if(getEmptyCellsLocations().length==0){//TIE
            setTieStatus();
            return;
        }

        //try to find the winner

        //try to find the winning row
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 1; j < gameDataArray[i].length; j++) {
                if(gameDataArray[i][0] != gameDataArray[i][j] || gameDataArray[i][j] == null)
                    break;//skip current row if on first found difference
                if(j==gameDataArray[i].length-1){//winning row found
                    setWinningStatus(gameDataArray[i][0]);
                    return;
                }
            }
        }

        //try to find the winning column
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 1; j < gameDataArray[i].length; j++) {
                if(gameDataArray[0][i] != gameDataArray[j][i] || gameDataArray[j][i] == null)
                    break;//skip current column if on first found difference
                if(j==gameDataArray.length-1){//winning column found
                    setWinningStatus(gameDataArray[j][0]);
                    return;
                }
            }
        }

        //check main diagonal
        for (int i = 1; i < gameDataArray.length; i++) {
            if (gameDataArray[0][0] != gameDataArray[i][i] || gameDataArray[i][i] == null)
                break;//skip current column if on first found difference
            if (i == gameDataArray.length - 1) {//winning
                setWinningStatus(gameDataArray[i][i]);
                return;
            }
        }

        //check secondary diagonal
        for (int i = 1; i < gameDataArray.length; i++) {
            if (gameDataArray[gameDataArray.length-1][0] != gameDataArray[gameDataArray.length-1-i][i] || gameDataArray[gameDataArray.length-1-i][i] == null)
                break;//skip current column if on first found difference
            if (i == gameDataArray.length - 1) {//winning
                setWinningStatus(gameDataArray[gameDataArray.length-1-i][i]);
                return;
            }
        }


        //no tie, no winner. continue game
        nextStep();
    }

    private void setWinningStatus(CellValue winner)
    {
        gameStatus = GameStatus.WIN;
        this.winner = winner;
    }
    private void setTieStatus()
    {
        gameStatus = GameStatus.TIE;
    }

    private void nextStep()
    {
        if(difficulty != Difficulty.FRIEND && turn != playerRole){//computer turn
            computerChoice();
        }
    }

    public void printTable() {

        System.out.printf("%n");
        for (int i = 0; i < gameDataArray.length; i++) {
            for (int j = 0; j < gameDataArray[i].length; j++) {
                System.out.printf("\t%s\t", gameDataArray[i][j] == null ? " " : gameDataArray[i][j]);
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
