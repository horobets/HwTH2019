package task6.tictactoe;

import java.util.Scanner;

public class PlayTicTacToeGame {

    public static void main(String[] args) {

        System.out.printf("%nTic Tac Toe%n");

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        Difficulty gameDifficulty = Difficulty.NORMAL;

        Role playerRole = Role.X;

        boolean enableHints = false;

        //computer vs computer game
        boolean autoPlay = false;
        System.out.printf("%nEnable autoplay (Computer vs Computer)? (y/n): ");
        if ('y' == scanner.next().toLowerCase().charAt(0)) {
            autoPlay = true;
        }
        else {
            System.out.printf("%nDifficulty (1 - Easy; 2 - Normal; 3 - Play against a friend): ");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    gameDifficulty = Difficulty.EASY;
                    break;
                case 2:
                    gameDifficulty = Difficulty.NORMAL;
                    break;
                case 3:
                    gameDifficulty = Difficulty.FRIEND;
                    break;
                default:
                    System.out.printf("%nInvalid difficulty level selected: %d", userChoice);
                    return;
            }


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
            if (!autoPlay) {
                System.out.printf("%nEnable hints? (y/n): ");

                if ('y' == scanner.next().toLowerCase().charAt(0))
                    enableHints = true;
            }
        }

        //start the game
        TicTacToe ticTacToeGame = new TicTacToe(gameDifficulty, playerRole);

        System.out.printf("%nTable locations");
        ticTacToeGame.printTable(true);

        try {

            //play until WIN or TIE
            while (ticTacToeGame.getGameStatus() == GameStatus.PLAYER_TURN) {
                ticTacToeGame.printTable(false);
                System.out.printf("%s turn. Choose location (1 - 9): ", ticTacToeGame.getTurn());

                int proTip = ticTacToeGame.getNextTurnLocationProTip();//computer recommended choice

                if (enableHints)
                    System.out.printf("%nPro Tip: choose %d! ", proTip);

                if(!autoPlay)
                    userChoice = scanner.nextInt();
                else {//Computer vs Computer game - submit recommended choice
                    System.out.printf("%n Autoselect: %d ", proTip);
                    userChoice = proTip;
                }

                ticTacToeGame.submitChoice(userChoice);
            }

            if (ticTacToeGame.getGameStatus() == GameStatus.WIN) {
                System.out.printf("%n************************");
                System.out.printf("%n   %s wins the round!", ticTacToeGame.getWinner());
                System.out.printf("%n************************");
                ticTacToeGame.printTable(false);
            }
            if (ticTacToeGame.getGameStatus() == GameStatus.TIE) {
                System.out.printf("%n***********");
                System.out.printf("%n   TIE!");
                System.out.printf("%n***********");
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