package task8.seabattle;

import task8.seabattle.ships.Ship;
import task8.seabattle.ships.ShipDirection;

public class PlaySeaBattle {

    public static void main(String[] args) {

        System.out.printf("Sea Battle %n%n");


        SeaBattleField battleField = new SeaBattleField();

        printTable(battleField);

        if (!battleField.addShip(new Ship(2, ShipDirection.UP), new CellLocation(3, 3)))
            System.err.printf("can't add ship");

        if (!battleField.shotToCell(new CellLocation(5, 5)))
            System.err.printf("can't shoot to cell");

        printTable(battleField);

        System.out.printf("Thanks for playing! %n");
    }

    public static void printTable(SeaBattleField battleField) {
        FieldView fieldView = new FieldView(battleField);
        BattleFieldPrinter fieldPrinter = new BattleFieldPrinter(fieldView);
        fieldPrinter.printBattleField(true);

    }
}
