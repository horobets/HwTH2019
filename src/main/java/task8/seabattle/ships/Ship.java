package task8.seabattle.ships;

import task8.seabattle.battlefield.CellLocation;
import task8.seabattle.battlefield.SeaBattleField;

public class Ship {
    private CellLocation shipLocation;
    private SeaBattleField field;
    private ShipType shipType;

    public Ship(CellLocation shipLocation, SeaBattleField field, ShipType shipType) {
        this.shipLocation = shipLocation;
        this.field = field;
        this.shipType = shipType;
    }

    public CellLocation getShipLocation() {
        return shipLocation;
    }

    public SeaBattleField getField() {
        return field;
    }

    public ShipType getShipType() {
        return shipType;
    }
}
