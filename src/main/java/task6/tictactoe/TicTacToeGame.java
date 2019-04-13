package task6.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {

        TicTacToe ticTacToeGame = new TicTacToe(Difficulty.FRIEND, CellValue.X);

        try {

            while (ticTacToeGame.getGameStatus() == GameStatus.TURN) {
                ticTacToeGame.printTable();
                System.out.printf("%s turn. Choose location (1 - 9): ", ticTacToeGame.getTurn());

                Scanner scanner = new Scanner(System.in);
                int userChoice = scanner.nextInt();

                ticTacToeGame.submitChoice(userChoice);

            }

            if(ticTacToeGame.getGameStatus() == GameStatus.WIN){
                System.out.printf("%s wins the round!", ticTacToeGame.getWinner());
                ticTacToeGame.printTable();
            }
            if(ticTacToeGame.getGameStatus() == GameStatus.TIE){
                System.out.printf("TIE!");
                ticTacToeGame.printTable();
            }

        } catch (InvalidGameActionException ex) {
            System.err.println(ex);
        } catch (CellNotEmptyException ex) {
            System.err.println(ex);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex);
        }
    }
}