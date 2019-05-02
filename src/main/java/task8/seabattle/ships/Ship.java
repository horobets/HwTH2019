package task8.seabattle.ships;

public class Ship {
    private int shipSize;
    private ShipDirection shipDirection;

    public Ship(int shipSize, ShipDirection shipDirection) {
        this.shipSize = shipSize;
        this.shipDirection = shipDirection;
    }

    public int getShipSize() {
        return shipSize;
    }

    public ShipDirection getShipDirection() {
        return shipDirection;
    }
}
