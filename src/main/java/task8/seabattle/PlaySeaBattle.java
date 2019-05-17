package task8.seabattle;

import task8.seabattle.battlefield.*;
import task8.seabattle.ships.ShipDirection;
import task8.seabattle.ships.ShipType;

public class PlaySeaBattle {

    public static void main(String[] args) {

        System.out.printf("Sea Battle %n%n");


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
