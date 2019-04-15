package task6.tictactoe;

import java.util.Scanner;

public class PlayTicTacToeGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Difficulty gameDifficulty;
        System.out.printf("%n%nTic Tac Toe%n%nDifficulty (1 - Normal; 2 - Impossible; 3 - Play against a friend): ");

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                gameDifficulty = Difficulty.NORMAL;
                break;
            case 2:
                gameDifficulty = Difficulty.IMPOSSIBLE;
                break;
            case 3:
                gameDifficulty = Difficulty.FRIEND;
                break;
            default:
                System.out.printf("%nInvalid difficulty level selected: %d", userChoice);
                return;
        }

        Role playerRole = Role.X;

        if (gameDifficulty != Difficulty.FRIEND) {
            System.out.printf("%nPlease choose your role (1 - X; 2 - O): ");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    playerRole = Role.X;
                    break;
                case 2:
                    playerRole = Role.O;
                    break;
                default:
                    System.out.printf("%nInvalid role selected: %d", userChoice);
                    return;
            }
        }

        //in-game tips
        boolean enableHints = false;
        System.out.printf("%nEnable hints? (y/n): ");

        if ('y' == scanner.next().toLowerCase().charAt(0))
            enableHints = true;

        //start the game
        TicTacToe ticTacToeGame = new TicTacToe(gameDifficulty, playerRole);

        System.out.printf("%nTable locations");
        ticTacToeGame.printTable(true);

        try {

            //play until WIN or TIE
            while (ticTacToeGame.getGameStatus() == GameStatus.PLAYER_TURN) {
                ticTacToeGame.printTable(false);
                System.out.printf("%s turn. Choose location (1 - 9): ", ticTacToeGame.getTurn());
                if (enableHints)
                    System.out.printf("%nPro Tip: choose %d! ", ticTacToeGame.getNextTurnLocationProTip());

                userChoice = scanner.nextInt();

                ticTacToeGame.submitChoice(userChoice);
            }

            if (ticTacToeGame.getGameStatus() == GameStatus.WIN) {
                System.out.printf("%n************************", ticTacToeGame.getWinner());
                System.out.printf("%n   %s wins the round!", ticTacToeGame.getWinner());
                System.out.printf("%n************************", ticTacToeGame.getWinner());
                ticTacToeGame.printTable(false);
            }
            if (ticTacToeGame.getGameStatus() == GameStatus.TIE) {
                System.out.printf("%n***********", ticTacToeGame.getWinner());
                System.out.printf("%n   TIE!");
                System.out.printf("%n***********", ticTacToeGame.getWinner());
                ticTacToeGame.printTable(false);
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