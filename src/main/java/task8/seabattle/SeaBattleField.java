package task8.seabattle;

import task8.seabattle.ships.Ship;

import java.util.HashMap;
import java.util.Map;

public class SeaBattleField {

    private final SeaBattleCellValue[][] cells;

    private final Map<CellLocation, Ship> ships;

    public SeaBattleField() {
        this(10,10);//10x10 field by default
    }

    public SeaBattleField(int fieldSizeX, int fieldSizeY) {
        cells = new SeaBattleCellValue[fieldSizeX][fieldSizeY];
        ships = new HashMap<>();
    }

    public void addShip(Ship ship, CellLocation location){

        //check location and add new ship
        ships.put(location, ship);
    }

    public Map<CellLocation, Ship> getShips() {
        return ships;
    }
}
