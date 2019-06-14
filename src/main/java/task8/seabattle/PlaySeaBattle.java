package task8.seabattle;

import task8.seabattle.battlefield.*;
import task8.seabattle.ships.ShipDirection;
import task8.seabattle.ships.ShipType;

import java.util.Scanner;

public class PlaySeaBattle {

    public static void main(String[] args) {

        System.out.printf("Sea Battle %n%n");

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        GameMode gameMode = GameMode.SINGLEPLAYER;

            System.out.printf("%nGame Mode (1 - Single Player; 2 - Play against a friend; 3 - Autoplay): ");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    gameMode = GameMode.SINGLEPLAYER;
                    break;
                case 2:
                    gameMode = GameMode.MULTIPLAYER;
                    break;
                case 3:
                    gameMode = GameMode.AUTOPLAY;
                    break;
                default:
                    System.out.printf("%nInvalid mode selected: %d", userChoice);
                    return;
            }


            System.out.printf("%n Player 1 Field:");

        FieldBuilder fieldBuilder = new FieldBuilder();


        fieldBuilder.startBuilding(false);



        SeaBattleField battleField = new SeaBattleField();

        printTable(battleField);


        if (!battleField.addShip(new ShipType(2, ShipDirection.UP), new CellLocation(3, 3)))
            System.err.printf("can't add ship");

        shootAndPrintResult(battleField, new CellLocation(1, 1));

        shootAndPrintResult(battleField, new CellLocation(5, 5));
        shootAndPrintResult(battleField, new CellLocation(3, 4));

        shootAndPrintResult(battleField, new CellLocation(3, 3));
        shootAndPrintResult(battleField, new CellLocation(1, 1));

        printTable(battleField);

        System.out.printf("Thanks for playing! %n");
    }

    public static void printTable(SeaBattleField battleField) {
        FieldView fieldView = new FieldView(battleField);
        BattleFieldPrinter fieldPrinter = new BattleFieldPrinter(fieldView);
        fieldPrinter.printBattleField(true);

    }

    private static void shootAndPrintResult(SeaBattleField battleField, CellLocation cellLocation) {
        ShotResult shotResult = battleField.shotToCell(cellLocation);
        switch (shotResult) {
            case HIT:
                System.out.printf("%nHIT!%n");
                break;
            case MISS:
                System.out.printf("%nMISS!%n");
                break;
            case DESTROYED:
                System.out.printf("%nDESTROYED!%n");
                break;
            case ALREADYSHOT:
                System.err.printf("%nALREADYSHOT%n");
                break;
        }
    }
}
