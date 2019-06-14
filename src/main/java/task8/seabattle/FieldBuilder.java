package task8.seabattle;

import task8.seabattle.battlefield.*;
import task8.seabattle.ships.ShipDirection;
import task8.seabattle.ships.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FieldBuilder {

    private final List<Integer> remainingShipsSizes;
    private SeaBattleField field;

    public FieldBuilder() {
        final List<Integer> shipsLengths = new ArrayList<>();

        //submarine /single-decker /single-funnel: Size: 4 number per player: 1
        shipsLengths.add(4);

        //destroyer /two-decker /two-funnel: Size: 3 number per player: 2
        shipsLengths.add(3);
        shipsLengths.add(3);

        //cruiser /three-decker /three-funnel: Size: 2 number per player: 3
        shipsLengths.add(2);
        shipsLengths.add(2);
        shipsLengths.add(2);

        //battleship /four-decker /four-funnel: Size: 1 number per player: 4
        shipsLengths.add(1);
        shipsLengths.add(1);
        shipsLengths.add(1);
        shipsLengths.add(1);

        this.remainingShipsSizes = shipsLengths;
    }

    public FieldBuilder(List<Integer> remainingShipsSizes) {
        this.remainingShipsSizes = remainingShipsSizes;
    }

    public SeaBattleField getField() {
        return field;
    }

    public void printRemainingShips(){
        for(int i = 0; i< remainingShipsSizes.size(); i++){

            System.out.printf("%n%d. ", i+1);
            printShipBySize(remainingShipsSizes.get(i), ShipDirection.LEFT);

        }
    }
    public void printShipBySize(int shipSize, ShipDirection shipDirection){

        System.out.printf("%n");

        if(shipDirection == ShipDirection.UP || shipDirection == ShipDirection.DOWN )
        for(int j = 0; j< shipSize; j++){
            System.out.printf("%s", FieldPrinterMarker.SHIP);
        }
        else
            for(int j = 0; j< shipSize; j++){
                System.out.printf("%s\n", FieldPrinterMarker.SHIP);
            }

    }

    private void printField(SeaBattleField battleField) {

        new BattleFieldPrinter(new FieldView(battleField)).printBattleField(true);
    }
    public boolean startBuilding(boolean automatic){

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        field = new SeaBattleField();

        while (true) {


            System.out.printf("%n Field: ");
            printField(field);

            System.out.printf("%n Ships left: ");
            printRemainingShips();

            System.out.printf("%n Select a ship (1 - %d): ", remainingShipsSizes.size());

            int selectedRemainingShipSize = scanner.nextInt();


            System.out.printf("%n Ship: ", remainingShipsSizes.size());
            printShipBySize(remainingShipsSizes.get(selectedRemainingShipSize), ShipDirection.LEFT);

            System.out.printf("%n Rotate the ship (1 - Up; 2 - Down; 3 - Left; 4 - Right): ", remainingShipsSizes.size());

            int selectedDirectionIndex = scanner.nextInt() - 1;
            ShipDirection selectedShipDirection = ShipDirection.values()[selectedDirectionIndex];


            printShipBySize(remainingShipsSizes.get(selectedRemainingShipSize), selectedShipDirection);

            System.out.printf("%n Location for this ship (e.g. C3): ");
            String selectedShipLocationStr = scanner.next();
            CellLocation locationForShip = new CellLocation(selectedShipLocationStr);

            field.addShip(new ShipType(selectedRemainingShipSize, selectedShipDirection), locationForShip);

            System.out.printf("%n Field: ");
            printField(field);

            printShipBySize(remainingShipsSizes.get(selectedRemainingShipSize), ShipDirection.LEFT);


     /*          switch (userChoice) {
                case 1:
                    playerRole = Role.X;
                    break;
                case 2:
                    playerRole = Role.O;
                    break;
                default:
                    System.out.printf("%nInvalid role selected: %d", userChoice);
                    return;
            }*/
            return true;
        }
        //return true;
    }
}
